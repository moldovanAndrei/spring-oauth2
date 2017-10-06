package com.andrei.security.persistent.jwt.authorization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.andrei.security.persistent.jwt.authorization.persistence.PersistentUserDetails;
import com.andrei.security.persistent.jwt.authorization.persistence.PersistentUserDetailsRepository;

/**
 * Implementation of {@link UserDetailsService}.
 *
 * @author Andrei Moldovan
 * @since 06.10.2017
 */
@Service
public class SecurityUserDetailsService implements UserDetailsService {

	private PersistentUserDetailsRepository userDetailsRepository;

	/**
	 * Constructor.
	 * 
	 * @param userDetailsRepository
	 *            the {@link PersistentUserDetailsRepository}
	 */
	@Autowired
	public SecurityUserDetailsService(PersistentUserDetailsRepository userDetailsRepository) {
		this.userDetailsRepository = userDetailsRepository;
	}

	/**
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		PersistentUserDetails persistentUserDetails = this.userDetailsRepository.findByUsername(username);
		if (persistentUserDetails == null) {
			throw new UsernameNotFoundException(username);
		}
		return new SecurityUserDetails(persistentUserDetails);
	}
}