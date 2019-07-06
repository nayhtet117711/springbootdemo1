package com.share.springboot1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.share.springboot1.model.Post;
import com.share.springboot1.model.RedisPost;
import com.share.springboot1.repo.RedisPostRepo;
import com.share.springboot1.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	RedisPostRepo redisPostRepo;
	
	@GetMapping("")
	public List<Post> getAllPost(@RequestParam(required = false) String postTitle) {
		if(postTitle!=null) return postService.readListByPostTitle(postTitle);
		return postService.readAll();
	}
	
	@GetMapping("/latest10")
	public List<Post> getLatest10Post() {
		Iterable<RedisPost> redisPostList = redisPostRepo.findAll();
		List<Post> postList = new ArrayList<>();
		redisPostList.forEach( rp -> postList.add(new Post(rp)) );
		if(postList.size()>10) {
			for(int i=0; i<postList.size()-10; i++) {
				redisPostRepo.delete(new RedisPost(postList.get(i)));
			}
		}
		return postList;
	}
	
}
