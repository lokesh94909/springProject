package com.lokesh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lokesh.dao.UserRepository;
import com.lokesh.model.User;
import com.lokesh.service.UserRepositoryService;

@Service
public class UserRepositoryServiceImpl implements UserRepositoryService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User findByUserId(int id) {
		return userRepository.findByUserId(id);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}
	
}
