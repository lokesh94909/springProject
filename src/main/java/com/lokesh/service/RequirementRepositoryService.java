package com.lokesh.service;

import java.util.List;

import com.lokesh.model.Requirement;

public interface RequirementRepositoryService {
	
List<Requirement> getAllRequirements();
	
	Requirement saveRequirement(Requirement requirement);
	
	Requirement getRequirementById(Long id);
	
	Requirement updateRequirement(Requirement requirement);
	
	void deleteRequirementById(Long id);

}
