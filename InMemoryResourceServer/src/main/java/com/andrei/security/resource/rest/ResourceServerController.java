package com.andrei.security.resource.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest API on resource server side which is secured with OAuth2 in memory token.
 *
 * @author DVM5CLT
 * @version $Id: ResourceServerController.java 31604 2014-10-30 08:03:19Z DVM5CLT $$
 * @since 04.10.2017
 */
@RestController
public class ResourceServerController {

	private String message = "Hello world!";

	@PreAuthorize("#oauth2.hasScope('resource-server-read')")
	@GetMapping
	public String getMessage() {
		return message;
	}

	@PreAuthorize("#oauth2.hasScope('resource-server-write')")
	@PostMapping
	public void updateMessage(@RequestBody String message) {
		this.message = message;
	}
}
