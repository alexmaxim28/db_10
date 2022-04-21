package com.example.tema_10.controller;

import com.example.tema_10.model.User;
import com.example.tema_10.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserRepository userRepository;



}
