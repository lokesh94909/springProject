package com.lokesh;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.lokesh.dao.RequirementRepository;
import com.lokesh.model.Requirement;

@SpringBootTest
class ContractmanagementCmsApplicationTests {

	@Autowired
	private RequirementRepository repo;
	
	@Test
	void testCreateStudent() {
		Requirement requirement=new Requirement();
		requirement.setReqType("lokesh");
		requirement.setReqDes("springboot");
		requirement.setDate("10th aug 2021");
		repo.save(requirement);
		
	}

}
