package com.instinctools.padlaboris.application.security.service;

import com.instinctools.padlaboris.application.security.model.User;

import java.util.List;

public interface UserService {

    User create(final User user);

    User update(final User user);

    void delete(final Integer id);

    User getUserByUsername(final String username);

    User fetch(final Integer id);

    List<User> listUsers();
}
