package com.example.jpa.repository;

import org.springframework.stereotype.Repository;

import com.example.jpa.model.Post;

@Repository
public interface ExtendedPostRepository extends ExtendedRepository<Post, Long> {

}