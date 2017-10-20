package com.andrei.security.rest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple {@link RestController} for demo purpose.
 * 
 * @author Andrei Moldovan.
 * @since 20.10.2017
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping
	public String sayHello() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return "Hello " + username + "!";
	}
}
