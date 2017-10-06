package com.andrei.security.persistent.jwt.authorization.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link PersistentClientDetails}.
 * 
 * @author Andrei Moldovan
 * @since 06.10.2017
 */
@Repository
public interface PersistentClientDetailsRepository extends JpaRepository<PersistentClientDetails, String> {

	/**
	 * Returns a {@link PersistentClientDetails} entity by it's client id.
	 * 
	 * @param clientId
	 *            the client id.
	 * @return the entity with the given client id.
	 */
	PersistentClientDetails findByClientId(String clientId);
}
