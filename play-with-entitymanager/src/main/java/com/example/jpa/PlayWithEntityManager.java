package com.example.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa.model.Comment;
import com.example.jpa.repository.ExtendedCommentRepository;

@SpringBootApplication
public class PlayWithEntityManager implements CommandLineRunner {

	@Autowired
	private ExtendedCommentRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(PlayWithEntityManager.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Comment> comments = repo.findByAttributeContainsText("text", "eat");
		List<Comment> comments2 = repo.findByAttributeContainsText("text", "oo");
		comments.stream().forEach(c -> System.out.println(c.getText()));
		System.out.println("******************");
		comments2.stream().forEach(c -> System.out.println(c.getText()));
	}

}
