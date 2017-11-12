package com.instinctools.padlaboris.application.security.repository;

import com.instinctools.padlaboris.application.security.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface for working with the database.
 */
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
