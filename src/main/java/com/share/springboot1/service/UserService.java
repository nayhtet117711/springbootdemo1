package com.share.springboot1.service;

import java.util.List;
import java.util.Optional;

import com.share.springboot1.model.User;

public interface UserService {
	
	User saveAUser(User user);
	
	List<User> readUserList();
	
	List<User> readUserListFilterdByName(String name);
	
	Optional<User> readUserByUsername(String name);
	
	User updateByUsername(String name, User user);
	
	boolean deleteUserByUsername(String username);
	
}