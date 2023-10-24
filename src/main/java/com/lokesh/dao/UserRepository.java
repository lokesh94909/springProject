package com.lokesh.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lokesh.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
List<User> findByEmailAndPassword(String email, String password);
	
	User findByEmail(String email);
	
	User findByUserId(int id);

}
