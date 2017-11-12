package com.instinctools.padlaboris.application.security.service;

import com.instinctools.padlaboris.application.security.model.Authority;
import com.instinctools.padlaboris.application.security.model.AuthorityType;
import com.instinctools.padlaboris.application.security.model.User;
import com.instinctools.padlaboris.application.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    private final AuthorityService authorityService;

    @Override
    public User create(User user) {

        Authority authority = new Authority();
        authority.setAuthority(AuthorityType.PATIENT.toString());

        authority = authorityService.create(authority);

        user.setAuthorities(Collections.singletonList(authority));
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {

        final User saved = userRepository.findOne(user.getId());

        user.setUsername(saved.getUsername());

        user.setAuthorities(saved.getAuthorities());

        user.setPassword(user.getPassword() == null ? saved.getPassword() : user.getPassword());

        return userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {

        userRepository.delete(id);
    }

    @Override
    public User getUserByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    @Override
    public User fetch(Integer id) {

        return userRepository.findOne(id);
    }

    @Override
    public List<User> listUsers() {

        return userRepository.findAll();
    }
}
