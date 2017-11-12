package com.instinctools.padlaboris.application.repository;

import com.instinctools.padlaboris.application.security.model.User;
import com.instinctools.padlaboris.application.security.repository.UserRepository;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User user;

    @Before
    public void setUp() {

        user = new User();

        user.setUsername("username");
        user.setPassword("password");

        userRepository.save(user);
    }

    @Test
    public void findByUsername() {

        final String content = "username";

        final User savedUser=userRepository.findByUsername(content);

        assertThat(savedUser.getUsername(), Is.is(user.getUsername()));
    }

}
