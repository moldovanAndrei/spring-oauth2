package com.andrei.security.persistent.jwt.authorization.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Entity for application users.
 * 
 * @author Andrei Moldovan
 * @since 06.10.2017
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "UC_USER_DETAILS_USERNAME", columnNames = { "username" }) })
public class PersistentUserDetails {

	@Id
	private Long id;

	@NotBlank
	@Column(nullable = false)
	private String username;

	@NotBlank
	@Column(nullable = false)
	private String password;

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}
}
