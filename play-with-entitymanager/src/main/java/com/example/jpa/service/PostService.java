package com.example.jpa.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.model.Comment;
import com.example.jpa.model.Post;
import com.example.jpa.repository.ExtendedCommentRepository;
import com.example.jpa.repository.ExtendedPostRepository;

@Service
public class PostService {
	
	@Autowired
	private ExtendedPostRepository postRepo;
	
	@Autowired
	private ExtendedCommentRepository commentRepo;

	@Transactional
	public Post addPostWithDefaultComment(Post post) {
		Post addedPost = postRepo.save(post);
		Comment c = new Comment("Standardkommentar", addedPost);
		if(post.getContent().equalsIgnoreCase("fel")) {
			throw new RuntimeException();
		}
		commentRepo.save(c);
		return addedPost;
	}
	
}
