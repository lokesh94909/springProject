package com.lokesh.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lokesh.model.Admin;



@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
List<Admin> findByAdminIdAndPassword(Integer adminId, String password);
	
	Admin findByAdminId(Integer adminId);

}
