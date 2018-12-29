package org.domain.user.registration.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.domain.user.registration.domain.commands.UserCreateDTO;
import org.domain.user.registration.events.UserSource;
import org.domain.user.registration.services.commands.UserCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/users")
@Api(value = "User Commands", description = "Create, Update or Delete a User", tags = "User Commands")
@EnableBinding(UserSource.class)
public class UserCommandController {

    @Autowired
    private UserCommandService userCommandService;

    @Autowired
    private UserSource userSource;

    @PostMapping
    @ApiOperation("Registers a new user")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<String> createNewUser(@Valid @RequestBody UserCreateDTO userCreateDTO){
        return new ResponseEntity<>("New User Created: " + userCommandService.createUser(userCreateDTO), HttpStatus.CREATED);
    }
}
