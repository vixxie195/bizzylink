package com.example.bizzylink.service;

import com.example.bizzylink.model.repositories.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserService {

    @Autowired
    private UserRepository userRepository;
}
