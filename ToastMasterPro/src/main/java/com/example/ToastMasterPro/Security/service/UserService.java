package com.example.ToastMasterPro.Security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToastMasterPro.Security.model.User;
import com.example.ToastMasterPro.Security.repository.UserRepository;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // public void registerUser(User userDto) {
    //     // User user = User.builder()
    //     //                 .username(userDto.getUsername())
    //     //                 .password(userDto.getPassword()) // Use passwordEncoder to encode the password
    //     //                  .role(userDto.getRole())
    //     //                 .build();
    //     // userRepository.save(user);
    // }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getUser(int id)
    {
        User savedUser=userRepository.findById(id).get();
        return savedUser;
    }
}
