package com.platzi.play;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.platzi.play.persistence.entity")
public class PlatziPlayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlatziPlayApplication.class, args);
	}

}
