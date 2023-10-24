package com.lokesh.service;

import java.util.List;

import com.lokesh.model.User;

public interface UserRepositoryService {
	
	List<User> findByEmailAndPassword(String email, String password);

	User findByEmail(String email);
	
	User findByUserId(int id);

	User save (User user);

}
