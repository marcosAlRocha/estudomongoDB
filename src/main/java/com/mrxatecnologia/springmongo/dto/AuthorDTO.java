package com.mrxatecnologia.springmongo.dto;

import com.mrxatecnologia.springmongo.domain.User;
import lombok.Data;

import java.io.Serializable;

@Data
public class AuthorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    public AuthorDTO(User user) {
        id = user.getId();
        name = user.getName();
    }

}
