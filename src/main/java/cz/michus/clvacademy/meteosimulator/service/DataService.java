package cz.michus.clvacademy.meteosimulator.service;

import cz.michus.clvacademy.meteosimulator.ApplicationProperties;
import cz.michus.clvacademy.meteosimulator.model.MeteoData;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class DataService {

    @Autowired
    private ApplicationProperties applicationProperties;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Scheduled(cron = "0 0 * * * *")
    public void load() {
        Map<String, String> data = applicationProperties.getServers();
        
        for (Map.Entry<String,String> entry : data.entrySet()) {
            log.info("Loading weather from {}.", entry.getKey());
            WeatherResponse response = restTemplate
                    .getForObject("https://api.weatherapi.com/v1/current.json?key=" + this.applicationProperties.getKey() + "&q=" + entry.getKey() + "&aqi=no",
                            WeatherResponse.class);
            
            log.info("{}",response);
            
            restTemplate.postForEntity(entry.getValue(), new MeteoData(Double.parseDouble(response.getCurrent().getHumidity()),
                    Double.parseDouble(response.getCurrent().getTemperature()), 
                    Double.parseDouble(response.getCurrent().getLight()),
                    Double.parseDouble(response.getCurrent().getPressure())), Void.class);
        }
    }
}
