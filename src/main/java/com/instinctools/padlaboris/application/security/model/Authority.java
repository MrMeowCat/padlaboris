package com.instinctools.padlaboris.application.security.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity that describes the authority.
 */
@Entity
@Data
@Table(name = "authorities")
@SuppressWarnings("PMD.AvoidFieldNameMatchingTypeName")
public class Authority implements GrantedAuthority {

    private static final long serialVersionUID = -4031273181701977660L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id")
    private Integer id;

    @Column(name = "authority")
    private String authority;

    @Column(name = "user_id")
    private Integer userId;
}
