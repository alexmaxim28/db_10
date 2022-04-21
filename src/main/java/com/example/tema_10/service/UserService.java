package com.example.tema_10.service;

import com.example.tema_10.model.User;
import com.example.tema_10.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUserById(Long id) { return userRepository.getById(id); }

    public List<User> getAllUsers() { return userRepository.findAll(); }

    public void addUser(User user) { userRepository.save(user); }

    public void removeUser(User user) { userRepository.delete(user); }

    public void deleteUserById(Long id) { userRepository.delete(getUserById(id)); }
}
