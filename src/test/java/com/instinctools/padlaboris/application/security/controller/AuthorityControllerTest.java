package com.instinctools.padlaboris.application.security.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.instinctools.padlaboris.application.security.dto.AuthorityDto;
import com.instinctools.padlaboris.application.security.model.Authority;
import com.instinctools.padlaboris.application.security.repository.AuthorityRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorityControllerTest {

    @Autowired
    private AuthorityRepository authorityRepository;

    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext webAppConfiguration;

    private AuthorityDto authorityDto;

    private Integer id;

    @Before
    public void setUp() throws Exception {

        authorityRepository.deleteAll();

        final Authority authority = new Authority();

        authority.setAuthority("PATIENT");

        id = authorityRepository.save(authority).getId();

        authorityDto = new AuthorityDto();

        authorityDto.setAuthority("ADMIN");

        mockMvc = MockMvcBuilders
                .webAppContextSetup(webAppConfiguration)
                .build();
    }

    @Test
    public void update() throws Exception {

        authorityDto.setId(id);

        mockMvc.perform(request(PUT, "/authorities")
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .content(objectMapper.writeValueAsString(authorityDto))
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.authority", is(authorityDto.getAuthority())));
    }
}
