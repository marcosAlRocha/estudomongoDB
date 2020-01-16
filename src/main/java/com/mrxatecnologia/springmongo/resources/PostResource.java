package com.mrxatecnologia.springmongo.resources;

import com.mrxatecnologia.springmongo.domain.Post;
import com.mrxatecnologia.springmongo.domain.User;
import com.mrxatecnologia.springmongo.dto.UserDTO;
import com.mrxatecnologia.springmongo.resources.Util.URL;
import com.mrxatecnologia.springmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping(value="/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value="/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue = "") String text) {
        text = URL.decodeParam(text);

        List<Post> list = postService.findByTitle(text);

        return ResponseEntity.ok().body(list);
    }


    @GetMapping(value="/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(@RequestParam(value="text", defaultValue = "") String text,
                                                 @RequestParam(value="minDate", defaultValue = "") String minDate,
                                                 @RequestParam(value="maxDate", defaultValue = "") String maxDate) {
        text = URL.decodeParam(text);

        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());

        List<Post> list = postService.fullSearch(text,min, max);

        return ResponseEntity.ok().body(list);
    }

}
