package com.andrei.security.persistent.jwt.authorization.persistence;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.security.oauth2.provider.ClientDetails;

/**
 * {@link Entity} for persistent {@link ClientDetails}.
 * 
 * @author Andrei Moldovan
 * @since 06.10.2017
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "UC_CLIENT_DETAILS_CLIENT_ID", columnNames = { "clientId" }) })
public class PersistentClientDetails {

	@Id
	private Long id;

	@NotNull
	private String clientId;

	@NotNull
	private String password;

	@Column(columnDefinition = "varchar2(255)")
	@Convert(converter = SetOfStringToJsonConverter.class)
	private Set<String> authorizedGrantTypes = new HashSet<>();

	@Column(columnDefinition = "varchar2(255)")
	@Convert(converter = SetOfStringToJsonConverter.class)
	private Set<String> scope = new HashSet<>();

	@NotNull
	private Integer accessTokenValiditySeconds;

	/**
	 * May be null, since authentication via client_credentials does not emit
	 * refresh token.
	 */
	private Integer refreshTokenValiditySeconds;

	/**
	 * No-arg constructor.
	 */
	public PersistentClientDetails() {
		// empty
	}

	/**
	 * Returns the client id.
	 * 
	 * @return the client id.
	 */
	public String getClientId() {
		return this.clientId;
	}

	/**
	 * Returns the client password.
	 * 
	 * @return the client password.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Returns the authorized grant types.
	 * 
	 * @return the authorized grant types.
	 */
	public Set<String> getAuthorizedGrantTypes() {
		return this.authorizedGrantTypes;
	}

	/**
	 * Returns the access token validity (in seconds).
	 * 
	 * @return the access token validity.
	 */
	public Integer getAccessTokenValiditySeconds() {
		return this.accessTokenValiditySeconds;
	}

	/**
	 * Returns the refresh token validity (in seconds).
	 * 
	 * @return the refresh token validity.
	 */
	public Integer getRefreshTokenValiditySeconds() {
		return this.refreshTokenValiditySeconds;
	}

	public Set<String> getScope() {
		return this.scope;
	}
}
