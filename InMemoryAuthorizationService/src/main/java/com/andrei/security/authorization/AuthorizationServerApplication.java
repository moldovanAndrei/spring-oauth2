package com.andrei.security.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot App for authorization server.
 *
 * @author Andrei Moldovan.
 * @since 04.10.2017
 */
@SpringBootApplication
public class AuthorizationServerApplication {

	/**
	 * Main method to start the application.
	 *
	 * @param args
	 *            the arguments of the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(AuthorizationServerApplication.class, args);
	}
}
