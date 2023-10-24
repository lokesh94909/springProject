package com.lokesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lokesh.model.Requirement;
import com.lokesh.service.RequirementRepositoryService;

@Controller
public class RequirementController {
	
	private RequirementRepositoryService requirementRepositoryService;

	public RequirementController(RequirementRepositoryService requirementRepositoryService) {
		super();
		this.requirementRepositoryService = requirementRepositoryService;
	}
	
	// handler method to handle list requirements and return mode and view
	@GetMapping("/requirements")
	public String listRequirements(Model model) {
		model.addAttribute("requirements", requirementRepositoryService.getAllRequirements());
		return "requirements";
	}
	
	@GetMapping("/SupplierRequirement")
	public String listRequirementsForSupplier(Model model) {
		model.addAttribute("requirements", requirementRepositoryService.getAllRequirements());
		return "SupplierRequirement";
	}
	
	
	
	@GetMapping("/requirements/new")
	public String createRequirementForm(Model model) {
		
		// create requirement object to hold requirement form data
		Requirement requirement = new Requirement();
		model.addAttribute("requirement", requirement);
		return "create_requirement";
		
	}
	
	@PostMapping("/requirements")
	public String saveRequirement(@ModelAttribute("requirement") Requirement requirement) {
		requirementRepositoryService.saveRequirement(requirement);
		return "create_requirement";
	}
	
	@GetMapping("/requirements/edit/{id}")
	public String editRequirementForm(@PathVariable Long id, Model model) {
		model.addAttribute("requirement", requirementRepositoryService.getRequirementById(id));
		return "edit_requirement";
	}

	@PostMapping("/requirements/{id}")
	public String updateRequirement(@PathVariable Long id,
			@ModelAttribute("requirement") Requirement requirement,
			Model model) {
		
		// get requirement from database by id
		Requirement existingRequirement = requirementRepositoryService.getRequirementById(id);
		existingRequirement.setId(id);
		existingRequirement.setReqType(requirement.getReqType());
		existingRequirement.setReqDes(requirement.getReqDes());
		existingRequirement.setDate(requirement.getDate());
		
		// save updated requirement object
		requirementRepositoryService.updateRequirement(existingRequirement);
		return "redirect:/requirements";		
	}
	
	// handler method to handle delete requirement request
	
	@GetMapping("/requirements/{id}")
	public String deleteRequirement(@PathVariable Long id) {
		requirementRepositoryService.deleteRequirementById(id);
		return "redirect:/requirements";
	}

}
