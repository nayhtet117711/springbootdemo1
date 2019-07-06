package com.share.springboot1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.share.springboot1.model.Post;

public interface PostRepo extends JpaRepository<Post, Long> {

	List<Post> findByUserId(Long id);
	
	List<Post> findByPostTitleContaining(String postTitle);

}
