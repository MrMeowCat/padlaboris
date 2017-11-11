package com.instinctools.padlaboris.application.security.repository;

import com.instinctools.padlaboris.application.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(final String userName);
}
