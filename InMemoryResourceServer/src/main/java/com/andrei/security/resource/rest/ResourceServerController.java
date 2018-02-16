package com.andrei.security.resource.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest API on resource server side which is secured with OAuth2 in memory
 * token.
 *
 * @author Andrei Moldovan
 * @since 04.10.2017
 */
@RestController
public class ResourceServerController {

	private String message = "Hello world!";

	@GetMapping
	public String sayHello() {
		return "Unecure hello!";
	}

	@PreAuthorize("#oauth2.hasScope('resource-server-read')")
	@GetMapping("/secure")
	public String getMessage() {
		return this.message;
	}

	@PreAuthorize("#oauth2.hasScope('resource-server-write')")
	@PostMapping("/secure")
	public void updateMessage(@RequestBody String message) {
		this.message = message;
	}

}
