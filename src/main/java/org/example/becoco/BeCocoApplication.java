package org.example.becoco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BeCocoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeCocoApplication.class, args);
	}

}
