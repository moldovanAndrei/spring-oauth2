package com.andrei.security.persistent.jwt.resource.rest;

import java.util.Collections;
import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

	@PreAuthorize("#oauth2.hasScope('resource-server-read')")
	@GetMapping
	public Map<String, String> getMessage() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return Collections.singletonMap("message", auth.getName() + ": " + this.message);
	}

	@PreAuthorize("#oauth2.hasScope('resource-server-write')")
	@PostMapping
	public void updateMessage(@RequestBody String message) {
		this.message = message;
	}
}
