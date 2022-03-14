package cz.michus.clvacademy.meteosimulator.model;

import lombok.Value;

@Value
public class MeteoData {
    
    private final Double humidity;
    
    private final Double temperature;
    
    private final Double light;
    
    private final Double pressure;
}
