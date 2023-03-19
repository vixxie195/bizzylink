package com.example.bizzylink.service;

import com.example.bizzylink.exceptions.BadRequestException;
import com.example.bizzylink.model.dto.UserSignUpRequestDTO;
import com.example.bizzylink.model.entities.User;
import com.example.bizzylink.model.repositories.UserRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@Data
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void signUp(UserSignUpRequestDTO userDto) {
        String username = userDto.getUsername();
        String email = userDto.getEmail();

        if (userRepository.findByUsername(username).isPresent()){
            throw new BadRequestException("Username already exists!");
        }
//        if (userRepository.findByEmail(email).isPresent()){
//            throw new BadRequestException("Email already exists!");
//        }

        String password = userDto.getPassword();
        String confirmedPassword = userDto.getConfirmedPassword();

        if(!password.equals(confirmedPassword)){
            throw new BadRequestException("Passwords do not match!");
        }

        User user = modelMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }
}
