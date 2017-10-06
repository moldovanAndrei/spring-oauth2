package com.andrei.security.persistent.jwt.authorization.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.andrei.security.persistent.jwt.authorization.persistence.PersistentUserDetails;

/**
 * Specific implementation of {@link UserDetails}.
 *
 * @author Andrei Moldovan
 * @since 06.10.2017
 */
public class SecurityUserDetails implements UserDetails {

	private static final long serialVersionUID = 1936710915167923536L;
	private PersistentUserDetails userDetails;

	/**
	 * Constructor.
	 * 
	 * @param userDetails
	 *            the persistent user details.
	 */
	public SecurityUserDetails(PersistentUserDetails userDetails) {
		this.userDetails = userDetails;
	}

	/**
	 * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.emptyList();
	}

	/**
	 * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
	 */
	@Override
	public String getPassword() {
		return this.userDetails.getPassword();
	}

	/**
	 * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
	 */
	@Override
	public String getUsername() {
		return this.userDetails.getUsername();
	}

	/**
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}
}
