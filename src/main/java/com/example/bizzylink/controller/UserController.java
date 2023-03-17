package com.example.bizzylink.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import com.example.bizzylink.dto.EditPasswordDto;
import com.example.bizzylink.dto.LoginDto;
import com.example.bizzylink.dto.UserDto;
import com.example.bizzylink.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody UserDto userDto) {
        userService.signUp(userDto);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        String token = userService.login(loginDto);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<String> editProfile(@RequestBody UserDto userDto) {
        userService.editProfile(userDto);
        return new ResponseEntity<>("Profile updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProfile() {
        userService.deleteProfile();
        return new ResponseEntity<>("Profile deleted successfully", HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        userService.logout();
        return new ResponseEntity<>("Logged out successfully", HttpStatus.OK);
    }

    @PostMapping("/upload-profile-picture")
    public ResponseEntity<String> uploadProfilePicture(@RequestParam("file") MultipartFile file) throws IOException {
        userService.uploadProfilePicture(file);
        return new ResponseEntity<>("Profile picture uploaded successfully", HttpStatus.OK);
    }

    @PutMapping("/edit-password")
    public ResponseEntity<String> editPassword(@RequestBody EditPasswordDto editPasswordDto) {
        editPasswordDto.setNewPassword(passwordEncoder.encode(editPasswordDto.getNewPassword()));
        userService.editPassword(editPasswordDto);
        return new ResponseEntity<>("Password updated successfully", HttpStatus.OK);
    }

}

