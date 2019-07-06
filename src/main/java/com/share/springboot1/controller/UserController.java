package com.share.springboot1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.share.springboot1.model.Post;
import com.share.springboot1.model.RedisPost;
import com.share.springboot1.model.User;
import com.share.springboot1.repo.RedisPostRepo;
import com.share.springboot1.service.PostService;
import com.share.springboot1.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PostService postService;
	
	@Autowired
	RedisPostRepo redisPostRepo;
	
	public UserController() { }
	
	@GetMapping("")
	public List<User> getUserList(@RequestParam(required = false) String name) {
		List<User> userList = userService.readUserList(); //Arrays.asList(u1, u2);
		if(name==null)
			//all data
			return userList;
		else {
			//filtered data
			return userService.readUserListFilterdByName(name);
//			return userList.stream()
//					.filter(u -> u.getUsername().toLowerCase().contains(name.toLowerCase()) )
//					.collect(Collectors.toList());
		}
	}
	
	@PostMapping("") 
	public User createUser(@RequestBody User user) {
//		System.out.println(user);
		return userService.saveAUser(user);
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		Optional<User> u1 = userService.readUserByUsername(username);
		return u1.isPresent() ? u1.get() : null;
	}
	
	// /users/kyawkyaw PUT
	@PutMapping("/{username}")
	public User updateUser(@PathVariable("username")String username, @RequestBody User user) {
		return userService.updateByUsername(username, user);
	}
	
	@DeleteMapping("/{username}")
	public String deleteUser(@PathVariable("username") String username) {
		userService.deleteUserByUsername(username);
		return username;
	}
	
	@PostMapping("/{username}/posts")
	public Post createPost(@PathVariable("username")String username, @RequestBody Post post) {
		Post resultPost = postService.savePost(username, post);
		RedisPost rp = new RedisPost(resultPost);
		// save rp to redis server
		redisPostRepo.save(rp);
		return resultPost;
	}
	
	@GetMapping("/{username}/posts")
	public List<Post> readPostOfUser(@PathVariable("username")String username ) {
		return postService.readListByUsername(username);
	}
	
}


