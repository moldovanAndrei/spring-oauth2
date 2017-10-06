package com.andrei.security.persistent.jwt.authorization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import com.andrei.security.persistent.jwt.authorization.persistence.PersistentClientDetails;
import com.andrei.security.persistent.jwt.authorization.persistence.PersistentClientDetailsRepository;

/**
 * Implementation of {@link ClientDetailsService}.
 * 
 * @author Andrei Moldovan
 * @since 06.10.2017
 */
@Primary
@Service
public class SecurityClientDetailsService implements ClientDetailsService {

	private PersistentClientDetailsRepository clientDetailsRepository;

	/**
	 * Constructor.
	 * 
	 * @param clientDetailsRepository
	 *            the repository for the persistent client details.
	 */
	@Autowired
	public SecurityClientDetailsService(PersistentClientDetailsRepository clientDetailsRepository) {
		this.clientDetailsRepository = clientDetailsRepository;
	}

	/**
	 * @see org.springframework.security.oauth2.provider.ClientDetailsService#loadClientByClientId(java.lang.String)
	 */
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		PersistentClientDetails clientDetails = this.clientDetailsRepository.findByClientId(clientId);
		if (clientDetails == null) {
			throw new ClientRegistrationException("Client with id " + clientId + " is not registered!");
		}
		return new SecurityClientDetails(clientDetails);
	}
}
