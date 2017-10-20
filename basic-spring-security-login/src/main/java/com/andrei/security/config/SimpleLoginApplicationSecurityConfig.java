package com.andrei.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.andrei.security.handler.CustomAuthenticationFailureHandler;
import com.andrei.security.handler.CustomAuthenticationSuccessHandler;

/**
 * Application security configuration.
 * 
 * @author Andrei Moldovan
 * @since 20.10.2017
 */
@Configuration
@EnableWebSecurity
public class SimpleLoginApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	private CustomAuthenticationSuccessHandler authenticationSuccessHandler;
	private CustomAuthenticationFailureHandler authenticationFailureHandler;
	private AuthenticationEntryPoint authenticationEntryPoint;
	private LogoutSuccessHandler logoutSuccessHandler;

	@Autowired
	public SimpleLoginApplicationSecurityConfig(CustomAuthenticationSuccessHandler authenticationSuccessHandler,
			CustomAuthenticationFailureHandler authenticationFailureHandler,
			AuthenticationEntryPoint authenticationEntryPoint, LogoutSuccessHandler logoutSuccessHandler) {
		this.authenticationSuccessHandler = authenticationSuccessHandler;
		this.authenticationFailureHandler = authenticationFailureHandler;
		this.authenticationEntryPoint = authenticationEntryPoint;
		this.logoutSuccessHandler = logoutSuccessHandler;
	}

	@Override
	protected void configure(final HttpSecurity httpSecurity) throws Exception {
		httpSecurity.exceptionHandling().authenticationEntryPoint(this.authenticationEntryPoint);
		httpSecurity.csrf().disable();
		httpSecurity.authorizeRequests().anyRequest().authenticated();
		httpSecurity.formLogin().successHandler(this.authenticationSuccessHandler)
				.failureHandler(this.authenticationFailureHandler).permitAll();
		httpSecurity.logout().logoutSuccessHandler(this.logoutSuccessHandler).permitAll();
	}

	/**
	 * User in memory authentication with two hardcoded users.
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("andrei").password("secret")
				.authorities(new SimpleGrantedAuthority("USER")).and().withUser("admin").password("admin")
				.authorities(new SimpleGrantedAuthority("ADMIN"));
	}
}
