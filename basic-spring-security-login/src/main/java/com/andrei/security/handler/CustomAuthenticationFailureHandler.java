package com.andrei.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

/**
 * {@link SimpleUrlAuthenticationFailureHandler} implementation in case of login
 * failure.
 * 
 * @author Andrei Moldovan.
 * @since 20.10.2017
 */
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	/**
	 * @see org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler#onAuthenticationFailure(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse,
	 *      org.springframework.security.core.AuthenticationException)
	 */
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed: " + exception.getMessage());
	}
}