package com.dailyfoodrest.dailyfoodrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DailyfoodrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyfoodrestApplication.class, args);
	}

}
