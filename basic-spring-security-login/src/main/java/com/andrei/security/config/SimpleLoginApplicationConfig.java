package com.andrei.security.config;

import org.springframework.boot.autoconfigure.security.Http401AuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.andrei.security.handler.CustomAuthenticationFailureHandler;
import com.andrei.security.handler.CustomAuthenticationSuccessHandler;

/**
 * Application configuration.
 * 
 * @author Andrei Moldovan.
 * @since 20.10.2017
 */
@Configuration
public class SimpleLoginApplicationConfig {

	/**
	 * TODO: describe default behaviour.
	 * 
	 * Override default behaviour by supplying a custom
	 * {@link AuthenticationSuccessHandler}-
	 */
	@Bean
	public CustomAuthenticationSuccessHandler successHandler() {
		return new CustomAuthenticationSuccessHandler();
	}

	/**
	 * TODO: describe default behaviour.
	 * 
	 * Override default behaviour by supplying a custom
	 * {@link AuthenticationFailureHandler}.
	 */
	@Bean
	public CustomAuthenticationFailureHandler authenticationFailureHandler() {
		return new CustomAuthenticationFailureHandler();
	}

	/**
	 * By default, spring security redirects to the login page in case of
	 * unauthorized access.
	 * 
	 * Override default behaviour by returning HTTP 401.
	 */
	@Bean
	AuthenticationEntryPoint authenticationEntryPoint() {
		return new Http401AuthenticationEntryPoint("simple-login-app");
	}

	/**
	 * Logout by default redirects to login page.
	 * 
	 * Override default behaviour by returning HTTP 200.
	 */
	@Bean
	LogoutSuccessHandler logoutSuccessHandler() {
		return new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK);
	}
}
