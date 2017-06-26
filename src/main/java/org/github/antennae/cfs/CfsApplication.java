package org.github.antennae.cfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Starts the application.
 * NOTE : DO not add @EnableWebMvc it breaks static content delivery ( no idea why )
 */
@SpringBootApplication
//@EnableWebMvc
public class CfsApplication {


	public static void main(String[] args) {
		SpringApplication.run(CfsApplication.class, args);
	}

}
