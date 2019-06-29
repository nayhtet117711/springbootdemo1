package com.share.springboot1.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.share.springboot1.model.User;
import com.share.springboot1.repo.UserRepo;
import com.share.springboot1.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo userRepo;
	
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User saveAUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public List<User> readUserList() {
		return userRepo.findAll();
	}

	@Override
	public List<User> readUserListFilterdByName(String name) {
		return userRepo.findAllByUsernameContaining(name);
	}

	@Override
	public Optional<User> readUserByUsername(String name) {
		return userRepo.findByUsername(name);
	}

	@Override
	public User updateByUsername(String name, User user) {
		user.setUsername(name);
		int result = userRepo.updateByUsername(user.getEmail(), user.getPhone(), user.getAge(), user.getUsername());
		User returnUser = null;
		if(result!=0) {
			Optional<User> updatedUser = readUserByUsername(name);
			returnUser = updatedUser.isPresent() ? updatedUser.get() : null;
		} 
		return returnUser;
	}

	@Override
	public boolean deleteUserByUsername(String username) {
		userRepo.deleteByUsername(username);
		return true;
	}

}
