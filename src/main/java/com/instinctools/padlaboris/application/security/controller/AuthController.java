package com.instinctools.padlaboris.application.security.controller;

import com.instinctools.padlaboris.application.security.dto.TokenDto;
import com.instinctools.padlaboris.application.security.dto.UserDto;
import com.instinctools.padlaboris.application.security.service.jwt.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Rest Controller for Authenticating User.
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {

    private final TokenService tokenService;

    /**
     * Method for Authenticating User.
     *
     * @param userDto UserDto userDto.
     * @return TokenDto response.
     * @throws Exception Exception exception.
     */
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity authenticate(@RequestBody final UserDto userDto) throws Exception {

        final Optional<String> token = Optional.ofNullable(tokenService.getToken(userDto.getUsername(),
                userDto.getPassword()));

        if (token.isPresent()) {

            final TokenDto response = new TokenDto();
            response.setToken(token.get());

            return ResponseEntity.ok().header("access-token", response.getToken())
                    .body("Successfully");
        } else {

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No Authentication!");
        }
    }
}
