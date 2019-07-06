package com.share.springboot1.service;

import java.util.List;

import com.share.springboot1.model.Post;

public interface PostService {
	
	public Post savePost(String username, Post post);
	
	public List<Post> readAll();

	public List<Post> readListByUsername(String username);
	
	public List<Post> readListByPostTitle(String postTitle);
	
}
