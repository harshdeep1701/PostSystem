package com.harshdeep.blog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.harshdeep.blog.model.Post;

@Repository
public interface PostDao extends CrudRepository<Post, Long> {
	
	@Query("from Post order by postId")
	public List<Post> getPostbyOrder();
	
	@Query("from Post order by postMessage desc")
	public List<Post> getPostOrderbyMessage();

}
