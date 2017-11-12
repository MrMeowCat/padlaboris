package com.instinctools.padlaboris.application.security.service;

import com.instinctools.padlaboris.application.security.model.Authority;
import com.instinctools.padlaboris.application.security.repository.AuthorityRepository;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultAuthorityServiceTest {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private AuthorityService authorityService;

    private Integer id;

    private Authority authority;

    @Before
    public void setUp() throws Exception {

        authority = new Authority();

        authority.setAuthority("ADMIN");

        id = authorityRepository.save(authority).getId();
    }

    @Test
    public void create() throws Exception {

        final String content = "PATIENT";

        authority.setAuthority(content);

        final Authority savedAuthority = authorityService.create(authority);

        assertThat(savedAuthority.getAuthority(), Is.is(content));
    }

    @Test
    public void update() throws Exception {

        final String content = "DOCTOR";

        final Authority authorityToUpdate = authorityRepository.findOne(id);

        authorityToUpdate.setAuthority(content);

        final Authority updatedAuthority = authorityService.update(authorityToUpdate);

        assertThat(updatedAuthority.getAuthority(), Is.is(content));
    }
}
