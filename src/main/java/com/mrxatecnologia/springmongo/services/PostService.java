package com.mrxatecnologia.springmongo.services;

import com.mrxatecnologia.springmongo.domain.Post;
import com.mrxatecnologia.springmongo.domain.User;
import com.mrxatecnologia.springmongo.dto.UserDTO;
import com.mrxatecnologia.springmongo.repository.PostRepository;
import com.mrxatecnologia.springmongo.repository.UserRepository;
import com.mrxatecnologia.springmongo.services.Exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> user = postRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 *1000);
        return postRepository.fullSearch(text, minDate, maxDate);
    }

}
