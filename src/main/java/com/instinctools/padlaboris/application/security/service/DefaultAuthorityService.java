package com.instinctools.padlaboris.application.security.service;

import com.instinctools.padlaboris.application.security.model.Authority;
import com.instinctools.padlaboris.application.security.repository.AuthorityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultAuthorityService implements AuthorityService {

    private final AuthorityRepository authorityRepository;

    @Override
    public Authority create(Authority authority) {

        return authorityRepository.save(authority);
    }

    @Override
    public Authority update(Authority authority) {

        final Authority saved = authorityRepository.findOne(authority.getId());

        authority.setAuthority(authority.getAuthority() == null ?
                saved.getAuthority() : authority.getAuthority());
        authority.setUserId(saved.getUserId());

        return authorityRepository.save(authority);
    }
}
