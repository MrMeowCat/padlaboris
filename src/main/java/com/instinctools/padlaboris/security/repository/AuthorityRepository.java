package com.instinctools.padlaboris.security.repository;

import com.instinctools.padlaboris.security.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority,Integer>{
}
