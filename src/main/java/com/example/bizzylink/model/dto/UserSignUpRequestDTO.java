package com.example.bizzylink.model.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class UserSignUpRequestDTO {
    //no spaces, 1-16 symbols
    @NotBlank(message = "Username cannot be empty")
    @Pattern(regexp = "^[^\\s]{1,16}$", message = "Invalid username")
    private String username;

    @NotBlank(message = "First name cannot be empty")
    private String FName;

    @NotBlank(message = "Last name cannot be empty")
    private String LName;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email")
    private String email;

    //upper case, lower case, number, alpha-numeric character, 8-16 symbols
    @NotBlank(message = "Password cannot be empty")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}$",
            message = "Password is too weak")
    private String password;

    @NotBlank(message = "Confirmed password cannot be empty")
    private String confirmedPassword;

    private boolean isBusinessUser;
}
