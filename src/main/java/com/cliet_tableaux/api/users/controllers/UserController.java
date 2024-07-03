package com.cliet_tableaux.api.users.controllers;

import com.cliet_tableaux.api.users.dtos.UserDto;
import com.cliet_tableaux.api.users.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Users API")
public class UserController {
    @Autowired
    UserService userService;

    @Operation(
            summary = "Sign up a new user",
            description = "Returns the newly created user"
    )
    @PostMapping("/register")
    public ResponseEntity<UserDto> signUp(@RequestBody UserDto userDto) throws Exception {
        return new ResponseEntity<>(userService.signUpUser(userDto),
                HttpStatus.CREATED);
    }

    @Operation(
            summary = "Login an user",
            description = "Returns the logged user"
    )
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.loginUser(userDto),
                HttpStatus.OK);
    }

    /*@PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.logout(userDto),
                HttpStatus.OK);
    }*/
}
