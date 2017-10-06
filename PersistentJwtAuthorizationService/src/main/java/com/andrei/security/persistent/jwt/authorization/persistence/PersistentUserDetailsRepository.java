package com.andrei.security.persistent.jwt.authorization.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link PersistentUserDetails}.
 * 
 * @author Andrei Moldovan
 * @since 06.10.2017
 */
@Repository
public interface PersistentUserDetailsRepository extends JpaRepository<PersistentUserDetails, Long> {

	PersistentUserDetails findByUsername(String username);
}
