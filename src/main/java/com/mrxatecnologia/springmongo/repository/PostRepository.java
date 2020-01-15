package com.mrxatecnologia.springmongo.repository;

import com.mrxatecnologia.springmongo.domain.Post;
import com.mrxatecnologia.springmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
