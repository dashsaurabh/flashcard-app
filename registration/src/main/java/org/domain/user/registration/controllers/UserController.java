package org.domain.user.registration.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @GetMapping(value = "/api/user")
    private Principal getUser(Principal principal){
        return principal;
    }
}
