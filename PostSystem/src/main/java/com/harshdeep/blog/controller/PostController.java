package com.harshdeep.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.harshdeep.blog.dao.PostDao;
import com.harshdeep.blog.model.Post;

@RestController
public class PostController {

	@Autowired
	PostDao postDao;
	
	@PostMapping("/post")
	public ResponseEntity<Post> createPost(@RequestBody Post post){
		try {
			Post savedPost = postDao.save(post);
			return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/posts")
	public List<Post> getAllPost(){
		return (List<Post>) postDao.findAll();
	}
	
	@GetMapping("/postsByOrder")
	public List<Post> getAllPostByOrder(){
		return (List<Post>) postDao.getPostbyOrder();
	}
	
	@GetMapping("/postsOrderByMsg")
	public List<Post> getAllPostOrderbyMsg(){
		return (List<Post>) postDao.getPostOrderbyMessage();
	}
	
}
