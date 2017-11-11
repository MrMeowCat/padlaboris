package com.instinctools.padlaboris.security.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "authorities")
public class Authority implements Serializable, GrantedAuthority {

    private static final long serialVersionUID = -4031273181701977660L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "authority")
    private String authority;

    @Column(name = "user_id")
    private Integer userId;
}
