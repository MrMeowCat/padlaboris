package com.instinctools.padlaboris.application.security.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthorityDto implements Serializable {

    private static final long serialVersionUID = -472846764698867871L;

    private Integer id;

    private String authority;

    private Integer userId;
}
