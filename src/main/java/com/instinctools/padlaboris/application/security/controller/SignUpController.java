package com.instinctools.padlaboris.application.security.controller;

import com.instinctools.padlaboris.application.security.dto.UserDto;
import com.instinctools.padlaboris.application.security.model.User;
import com.instinctools.padlaboris.application.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SignUpController {

    private final UserService defaultUserService;

    private final DozerBeanMapper dozerBeanMapper;

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody final UserDto dto) {

        final User user=dozerBeanMapper.map(dto,User.class);

        return ResponseEntity.ok().body(defaultUserService.create(user));
    }
}
