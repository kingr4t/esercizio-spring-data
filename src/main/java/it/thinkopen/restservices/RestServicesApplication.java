package it.thinkopen.restservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RestServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServicesApplication.class, args);
	}

}
