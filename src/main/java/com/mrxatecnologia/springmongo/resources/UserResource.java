package com.mrxatecnologia.springmongo.resources;

import com.mrxatecnologia.springmongo.domain.User;
import com.mrxatecnologia.springmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity <List<User>> findAll() {
        List<User> lista = userService.findAll();
        return ResponseEntity.ok().body(lista);
    }

}
