package com.instinctools.padlaboris.application.security.service;

import com.instinctools.padlaboris.application.security.model.User;
import com.instinctools.padlaboris.application.security.repository.UserRepository;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultUserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    private Integer id;

    private User user;

    @Before
    public void setUp() {

        user = new User();

        user.setUsername("username");
        user.setPassword("password");

        id = userRepository.save(user).getId();
    }

    @Test
    public void create() {

        final String content = "newCreate";

        user.setUsername(content);

        final User savedUser = userService.create(user);

        assertThat(savedUser.getUsername(), Is.is(content));
    }

    @Test
    public void update() {

        final String content = "update";

        final User userToUpdate = userRepository.findOne(id);

        userToUpdate.setPassword(content);

        final User updatedUser = userService.update(userToUpdate);

        assertThat(updatedUser.getPassword(), Is.is(content));
    }

    @Test
    public void delete() {

        userService.delete(id);

        assertThat(userRepository.exists(id), Is.is(false));
    }

    @Test
    public void getUserByUsername() {

        final String content = "username";

        final User findUser = userService.getUserByUsername(content);

        assertThat(findUser.getUsername(), Is.is(user.getUsername()));
    }

    @Test
    public void fetch() throws Exception {

        final User receivedUser = userService.fetch(id);

        assertThat(receivedUser.getUsername(), Is.is(user.getUsername()));
    }

    @Test
    public void listUsers() throws Exception {

        final List<User> users = userService.listUsers();

        assertThat(users.get(0).getUsername(), Is.is(user.getUsername()));
    }
}
