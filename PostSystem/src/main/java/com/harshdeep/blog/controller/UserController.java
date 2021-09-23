package com.harshdeep.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.harshdeep.blog.dao.UserDao;
import com.harshdeep.blog.model.User;

@RestController
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@PostMapping("/user")
	public ResponseEntity<User> createPost(@RequestBody User user){
		try {
			User saveduser = userDao.save(user);
			return new ResponseEntity<>(saveduser, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
