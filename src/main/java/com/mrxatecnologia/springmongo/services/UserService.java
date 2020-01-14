package com.mrxatecnologia.springmongo.services;

import com.mrxatecnologia.springmongo.domain.User;
import com.mrxatecnologia.springmongo.repository.UserRepository;
import com.mrxatecnologia.springmongo.services.Exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

    }

}
