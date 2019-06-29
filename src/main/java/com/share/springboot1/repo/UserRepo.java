package com.share.springboot1.repo;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.share.springboot1.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
//	@Query(value = "select * from users where username like %?1%", nativeQuery = true)
//	List<User> getAllFilteredName(String name);
	
	List<User> findAllByUsernameContaining(String name);

	Optional<User> findByUsername(String name);
	
	@Modifying
	@Transactional
	@Query(value="update users set email=?1, phone=?2, age=?3 where username=?4", nativeQuery = true)
	int updateByUsername(String email, String phone, Integer age, String username);
	
	@Modifying
	@Transactional
	void deleteByUsername(String username);
	
}