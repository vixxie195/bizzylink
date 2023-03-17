package com.example.bizzylink.controller;

import com.example.bizzylink.dto.LoginDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        // validate the loginDto and perform login logic
        if (isValid(loginDto)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    private boolean isValid(LoginDto loginDto) {
        // perform validation logic, e.g. check if username and password match in database
        return loginDto.getUsername().equals("test") && loginDto.getPassword().equals("password");
    }
}
