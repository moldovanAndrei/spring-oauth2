package com.andrei.security.persistent.jwt.authorization.service;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import com.andrei.security.persistent.jwt.authorization.persistence.PersistentClientDetails;

/**
 * Specific implementation of {@link ClientDetails}.
 * 
 * @author Andrei Moldovan
 * @since 06.10.2017
 */
public class SecurityClientDetails implements ClientDetails {

	private static final long serialVersionUID = -8704644100479999283L;

	PersistentClientDetails clientDetails;

	/**
	 * Constructor.
	 * 
	 * @param clientDetails
	 *            the persistent client details.
	 */
	public SecurityClientDetails(PersistentClientDetails clientDetails) {
		this.clientDetails = clientDetails;
	}

	/**
	 * @see org.springframework.security.oauth2.provider.ClientDetails#getClientId()
	 */
	@Override
	public String getClientId() {
		return this.clientDetails.getClientId();
	}

	/**
	 * @see org.springframework.security.oauth2.provider.ClientDetails#getResourceIds()
	 */
	@Override
	public Set<String> getResourceIds() {
		return Collections.emptySet();
	}

	/**
	 * @see org.springframework.security.oauth2.provider.ClientDetails#isSecretRequired()
	 */
	@Override
	public boolean isSecretRequired() {
		return true;
	}

	/**
	 * @see org.springframework.security.oauth2.provider.ClientDetails#getClientSecret()
	 */
	@Override
	public String getClientSecret() {
		return this.clientDetails.getPassword();
	}

	/**
	 * @see org.springframework.security.oauth2.provider.ClientDetails#isScoped()
	 */
	@Override
	public boolean isScoped() {
		return false;
	}

	/**
	 * @see org.springframework.security.oauth2.provider.ClientDetails#getScope()
	 */
	@Override
	public Set<String> getScope() {
		return this.clientDetails.getScope();
	}

	/**
	 * @see org.springframework.security.oauth2.provider.ClientDetails#getAuthorizedGrantTypes()
	 */
	@Override
	public Set<String> getAuthorizedGrantTypes() {
		return this.clientDetails.getAuthorizedGrantTypes();
	}

	/**
	 * TODO: add reason for override!
	 * 
	 * @see org.springframework.security.oauth2.provider.ClientDetails#getRegisteredRedirectUri()
	 */
	@Override
	public Set<String> getRegisteredRedirectUri() {
		// TODO add implementation!
		throw new UnsupportedOperationException("getRegisteredRedirectUri not implemented yet!");
	}

	/**
	 * TODO: Implement!
	 * 
	 * @see org.springframework.security.oauth2.provider.ClientDetails#getAuthorities()
	 */
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return Collections.emptyList();
	}

	/**
	 * @see org.springframework.security.oauth2.provider.ClientDetails#getAccessTokenValiditySeconds()
	 */
	@Override
	public Integer getAccessTokenValiditySeconds() {
		return this.clientDetails.getAccessTokenValiditySeconds();
	}

	/**
	 * @see org.springframework.security.oauth2.provider.ClientDetails#getRefreshTokenValiditySeconds()
	 */
	@Override
	public Integer getRefreshTokenValiditySeconds() {
		return this.clientDetails.getRefreshTokenValiditySeconds();
	}

	/**
	 * @see org.springframework.security.oauth2.provider.ClientDetails#isAutoApprove(java.lang.String)
	 */
	@Override
	public boolean isAutoApprove(String scope) {
		return true;
	}

	/**
	 * @see org.springframework.security.oauth2.provider.ClientDetails#getAdditionalInformation()
	 */
	@Override
	public Map<String, Object> getAdditionalInformation() {
		return Collections.emptyMap();
	}

}
