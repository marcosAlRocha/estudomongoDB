package com.mrxatecnologia.springmongo.services;

import com.mrxatecnologia.springmongo.domain.User;
import com.mrxatecnologia.springmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
