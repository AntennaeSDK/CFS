package org.github.antennae.cfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Starts the application.
 * NOTE : DO not add @EnableWebMvc it breaks static content delivery ( no idea why )
 */
@SpringBootApplication
public class CfsApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {
		SpringApplication.run(CfsApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CfsApplication.class);
	}
}
