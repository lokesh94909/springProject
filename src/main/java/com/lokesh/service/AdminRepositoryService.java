package com.lokesh.service;

import java.util.List;

import com.lokesh.model.Admin;

public interface AdminRepositoryService {

List<Admin> findByAdminIdAndPassword(Integer adminId, String password);
	
	Admin findByAdminId(Integer adminId);
	
	
	Admin save(Admin admin);
	
}
