package com.instinctools.padlaboris.application.security.repository;

import com.instinctools.padlaboris.application.security.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
