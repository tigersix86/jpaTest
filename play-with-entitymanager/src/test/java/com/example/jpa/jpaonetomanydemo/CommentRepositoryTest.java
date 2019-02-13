package com.example.jpa.jpaonetomanydemo;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.jpa.PlayWithEntityManager;
import com.example.jpa.config.PersistenceJPAConfig;
import com.example.jpa.model.Comment;
import com.example.jpa.model.Post;
import com.example.jpa.repository.ExtendedCommentRepository;
import com.example.jpa.repository.ExtendedPostRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {PlayWithEntityManager.class, PersistenceJPAConfig.class})
public class CommentRepositoryTest {
	
	@Resource
	private ExtendedCommentRepository repo;
	@Resource
	private ExtendedPostRepository postRepo;

	@Before
	public void setUp() throws Exception {
		Post post = new Post();
		post.setContent("");
		post.setDescription("");
		post.setTitle("");
		postRepo.save(post);
		repo.save(new Comment("good", post));
		repo.save(new Comment("bad", post));
		repo.save(new Comment("ordinary", post));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		List<Comment> comments = repo.findByAttributeContainsText("text", "o");
		assertTrue(comments.size() == 2);
		comments.stream().forEach(c -> System.out.println("************ " + c.getText() + " ************"));
	}

}
