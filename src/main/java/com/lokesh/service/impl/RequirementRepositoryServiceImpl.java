package com.lokesh.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lokesh.dao.RequirementRepository;
import com.lokesh.model.Requirement;
import com.lokesh.service.RequirementRepositoryService;

@Service
public class RequirementRepositoryServiceImpl implements RequirementRepositoryService {

private RequirementRepository requirementRepository;
	
	public RequirementRepositoryServiceImpl(RequirementRepository requirementRepository) {
		super();
		this.requirementRepository = requirementRepository;
	}

	@Override
	public List<Requirement> getAllRequirements() {
		return requirementRepository.findAll();
	}

	@Override
	public Requirement saveRequirement(Requirement requirement) {
		return requirementRepository.save(requirement);
	}

	@Override
	public Requirement getRequirementById(Long id) {
		return requirementRepository.findById(id).get();
	}

	@Override
	public Requirement updateRequirement(Requirement requirement) {
		return requirementRepository.save(requirement);
	}

	@Override
	public void deleteRequirementById(Long id) {
		requirementRepository.deleteById(id);	
	}
	
}
