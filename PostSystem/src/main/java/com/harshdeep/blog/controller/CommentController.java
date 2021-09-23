package com.harshdeep.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.harshdeep.blog.dao.CommentDao;
import com.harshdeep.blog.model.Comment;

public class CommentController {
	
	@Autowired
	CommentDao commentDao;
	
	@PostMapping("/comment")
	public ResponseEntity<Comment> createPost(@RequestBody Comment comment){
		try {
			Comment savedComment = commentDao.save(comment);
			return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
