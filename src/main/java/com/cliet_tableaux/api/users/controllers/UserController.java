package com.cliet_tableaux.api.users.controllers;

import com.cliet_tableaux.api.users.dtos.UserDto;
import com.cliet_tableaux.api.users.services.UserService;
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
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> signUp(@RequestBody UserDto userDto) throws Exception {
        return new ResponseEntity<>(userService.signUpUser(userDto),
                HttpStatus.CREATED);
    }

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
