package com.instinctools.padlaboris.security.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TokenDto implements Serializable {

    private static final long serialVersionUID = -3529358992430924385L;

    private String token;
}
