package com.mrxatecnologia.springmongo.config;

import com.mrxatecnologia.springmongo.domain.Post;
import com.mrxatecnologia.springmongo.domain.User;
import com.mrxatecnologia.springmongo.dto.AuthorDTO;
import com.mrxatecnologia.springmongo.dto.CommentDTO;
import com.mrxatecnologia.springmongo.repository.PostRepository;
import com.mrxatecnologia.springmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("31/03/2018"), "Partiu viagem","Viajando para São Paulo", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("01/04/2018"), "boa ","só vai", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem", sdf.parse("21/06/208"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite o dia", sdf.parse("22/06/208"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Bom fds", sdf.parse("23/06/208"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1,c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);

    }
}
