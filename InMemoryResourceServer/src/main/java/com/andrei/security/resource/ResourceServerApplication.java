package com.andrei.security.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot application class to start the resource server.
 *
 * @author DVM5CLT
 * @version $Id: ResourceServerOAuth2Application.java 31604 2014-10-30 08:03:19Z DVM5CLT $$
 * @since 04.10.2017
 */
@SpringBootApplication
public class ResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceServerApplication.class, args);
	}
}
