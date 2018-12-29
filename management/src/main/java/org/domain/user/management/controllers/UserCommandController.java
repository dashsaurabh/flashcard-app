package org.domain.user.management.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.domain.user.management.domain.commands.UserUpdateDTO;
import org.domain.user.management.services.commands.UserCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/api/users")
@Api(value = "User Commands", description = "Update or Delete a User", tags = "User Commands")
public class UserCommandController {

    @Autowired
    private UserCommandService userCommandService;

    @PutMapping(value = "/{userName}")
    @ApiOperation("Updates a user")
    @ResponseStatus(HttpStatus.ACCEPTED)
    private ResponseEntity<String> updateUser(@PathVariable(name = "userName") String userName, @Valid @RequestBody UserUpdateDTO userUpdateDTO){
        return new ResponseEntity<>("User Updated: " + userCommandService.updateUser(userName, userUpdateDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{userName}")
    @ApiOperation("Deletes a user")
    @ResponseStatus(HttpStatus.ACCEPTED)
    private ResponseEntity<String> deletePassword(@PathVariable(name = "userName") String userName){
        return new ResponseEntity<>("User Deleted: " + userCommandService.deleteUser(userName), HttpStatus.ACCEPTED);
    }

}
