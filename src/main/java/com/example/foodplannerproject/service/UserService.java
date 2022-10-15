package com.example.foodplannerproject.service;


import com.example.foodplannerproject.domain.User;
import com.example.foodplannerproject.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    public User findById(Long id){
        return userRepository.findAllById(id).orElseThrow();
    }

    public List<User> findAll(){
        return  userRepository.findAll();
    }
}
