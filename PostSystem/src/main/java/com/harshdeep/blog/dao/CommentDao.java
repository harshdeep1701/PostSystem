package com.harshdeep.blog.dao;

import org.springframework.data.repository.CrudRepository;

import com.harshdeep.blog.model.Comment;

public interface CommentDao extends CrudRepository<Comment, Long> {

}
