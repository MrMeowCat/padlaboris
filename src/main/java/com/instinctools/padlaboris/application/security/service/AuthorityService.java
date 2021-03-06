package com.instinctools.padlaboris.application.security.service;

import com.instinctools.padlaboris.application.security.model.Authority;

/**
 * Interface for Authority work with database.
 */
public interface AuthorityService {

    /**
     * Method for create Authority.
     *
     * @param authority Authority authority.
     * @return created Authority authority.
     */
    Authority create(Authority authority);

    /**
     * Method for update Authority.
     *
     * @param authority Authority authority.
     * @return updated Authority authority.
     */
    Authority update(Authority authority);
}
