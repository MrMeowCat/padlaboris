package com.instinctools.padlaboris.application.security.service;

import com.instinctools.padlaboris.application.security.model.Authority;

public interface AuthorityService {

    Authority create(final Authority authority);

    Authority update(final Authority authority);
}
