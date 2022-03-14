package cz.michus.clvacademy.meteosimulator;

import java.util.Map;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Value
@ConstructorBinding
@ConfigurationProperties(prefix = "app")
public class ApplicationProperties {
    
    private Map<String, String> servers;
    private String key;
}
