package com.harshdeep.blog.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.harshdeep.blog.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

}
