package com.lokesh.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lokesh.dao.AdminRepository;
import com.lokesh.model.Admin;
import com.lokesh.service.AdminRepositoryService;

@Service
public class AdminRepositoryServiceImpl implements AdminRepositoryService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public List<Admin> findByAdminIdAndPassword(Integer adminId, String password) {
		return adminRepository.findByAdminIdAndPassword(adminId, password);
	}

	@Override
	public Admin findByAdminId(Integer adminId) {
		return adminRepository.findByAdminId(adminId);
	}
	

	@Override
	public Admin save(Admin admin) {
		return adminRepository.save(admin);
	}

}
