package cz.michus.clvacademy.meteosimulator.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeather {

    @JsonProperty("pressure_mb")
    private String pressure;

    private String humidity;

    @JsonProperty("temp_c")
    private String temperature;

    @JsonProperty("uv")
    private String light;
}
