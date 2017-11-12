package com.instinctools.padlaboris.application.security.dto;

import com.instinctools.padlaboris.application.security.model.Authority;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserDto implements Serializable {

    private static final long serialVersionUID = 5381524464602378056L;

    private Integer id;

    private String username;

    private String password;

    private List<Authority> authorities;
}
