package cz.michus.clvacademy.meteosimulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MeteoSimulatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeteoSimulatorApplication.class, args);
	}

}
