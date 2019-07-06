package com.share.springboot1.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.share.springboot1.model.Post;
import com.share.springboot1.model.User;
import com.share.springboot1.repo.PostRepo;
import com.share.springboot1.repo.UserRepo;
import com.share.springboot1.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PostRepo postRepo;
	
	public PostServiceImpl () {
		
	}
	
	@Override
	public Post savePost(String username, Post post) {
		Optional<User> user = userRepo.findByUsername(username);
		post.setUser(user.get());
		return postRepo.save(post);
	}

	@Override
	public List<Post> readAll() {
		return postRepo.findAll();
	}

	@Override
	public List<Post> readListByUsername(String username) {
		Optional<User> user = userRepo.findByUsername(username);
		return postRepo.findByUserId(user.get().getId());
	}

	@Override
	public List<Post> readListByPostTitle(String postTitle) {
		return postRepo.findByPostTitleContaining(postTitle);
	}	
	
}
