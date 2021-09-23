package com.harshdeep.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.harshdeep.blog.dao.PostDao;
import com.harshdeep.blog.model.Comment;
import com.harshdeep.blog.model.Post;
import com.harshdeep.blog.model.User;

@SpringBootApplication
public class PostSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PostSystemApplication.class, args);
	}

	@Autowired
	PostDao postDao;
	
	@Override
	public void run(String... args) throws Exception {
		Post post = new Post();
		post.setPostMessage("Main post");
		
		User user = new User();
		user.setUsername("user1");
		user.setPersonName("user1");
		
		post.setUser(user);
		
		Comment comment = new Comment("Comment1");
		comment.setUser(user);
		post.getComments().add(comment);
		
		
		postDao.save(post);
		
		User user2 = new User();
		user2.setUsername("user2");
		user2.setPersonName("user2");
		
		Post post2 = new Post();
		post2.setUser(user2);
		post2.setPostMessage("Second post");
		
		
		Comment comment2 = new Comment("Comment2");
		comment2.setUser(user2);
		post2.getComments().add(comment2);
		
		Comment comment3 = new Comment("Comment3");
		comment3.setUser(user2);
		post2.getComments().add(comment3);
		
		postDao.save(post2);
	}

}
