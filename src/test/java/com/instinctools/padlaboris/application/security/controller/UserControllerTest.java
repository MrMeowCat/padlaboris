package com.instinctools.padlaboris.application.security.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.instinctools.padlaboris.application.security.dto.UserDto;
import com.instinctools.padlaboris.application.security.model.User;
import com.instinctools.padlaboris.application.security.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext webAppConfiguration;

    @Autowired
    private UserRepository userRepository;

    private UserDto userDto;

    private User user;

    private Integer id;

    @Before
    public void setUp() {

        userRepository.deleteAll();

        user = new User();

        user.setPassword("userPassword");
        user.setUsername("userUsername");

        id = userRepository.save(user).getId();

        userDto = new UserDto();

        userDto.setUsername("dtoUserName");
        userDto.setPassword("dtoPassword");

        mockMvc = MockMvcBuilders
                .webAppContextSetup(webAppConfiguration)
                .build();
    }

    @Test
    public void create() throws Exception {

        mockMvc.perform(request(POST, "/users")
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .content(objectMapper.writeValueAsString(userDto))
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.username", is(userDto.getUsername())))
                .andExpect(jsonPath("$.password", is(userDto.getPassword())));
    }

    @Test
    public void update() throws Exception {

        userDto.setPassword("updatePassword");
        userDto.setId(id);

        mockMvc.perform(request(PUT, "/users")
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .content(objectMapper.writeValueAsString(userDto))
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.password", is(userDto.getPassword())));
    }

    @Test
    public void fetchAll() throws Exception {

        mockMvc.perform(request(GET, "/users")
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id", is(user.getId())))
                .andExpect(jsonPath("$.[0].username", is(user.getUsername())))
                .andExpect(jsonPath("$.[0].password", is(user.getPassword())));
    }

    @Test
    public void fetch() throws Exception {

        mockMvc.perform(request(GET, "/users/" + id)
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username", is(user.getUsername())))
                .andExpect(jsonPath("$.password", is(user.getPassword())));
    }

    @Test
    public void delete() throws Exception {

        mockMvc.perform(request(DELETE, "/users/" + id)
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk());

        assertThat(userRepository.exists(id), is(false));
    }
}
