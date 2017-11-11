package com.instinctools.padlaboris.application.security.service;

import com.instinctools.padlaboris.application.security.model.User;
import com.instinctools.padlaboris.application.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    @Override
    public User create(User user) {

        return userRepository.save(user);
    }

    @Override
    public User update(User user) {

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
