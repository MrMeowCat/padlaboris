package com.instinctools.padlaboris.application.security.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    private static final long serialVersionUID = 5381524464602378056L;

    private String username;

    private String password;
}
