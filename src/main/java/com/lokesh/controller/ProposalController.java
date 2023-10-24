package com.lokesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lokesh.model.Proposal;
import com.lokesh.service.ProposalRepositoryService;

@Controller
public class ProposalController {
	
	private ProposalRepositoryService proposalRepositoryService;

	public ProposalController(ProposalRepositoryService proposalRepositoryService) {
		super();
		this.proposalRepositoryService = proposalRepositoryService;
	}
	
	// handler method to handle list proposals and return mode and view
	@GetMapping("/proposals")
	public String listProposals(Model model) {
		model.addAttribute("proposals", proposalRepositoryService.getAllProposals());
		return "proposals";
	}
	
	@GetMapping("/status")
	public String status(Model model) {
		model.addAttribute("proposals", proposalRepositoryService.getAllProposals());
		return "status";
	}
	
	
	
	@GetMapping("/proposals/new")
	public String createProposalForm(Model model) {
		
		// create proposal object to hold proposal form data
		Proposal proposal = new Proposal();
		model.addAttribute("proposal", proposal);
		return "create_proposal";
		
	}
	
	@PostMapping("/proposals")
	public String saveProposal(@ModelAttribute("proposal") Proposal proposal) {
		proposalRepositoryService.saveProposal(proposal);
		return "create_proposal";
	}
	
	@GetMapping("/proposals/edit/{id}")
	public String editProposalForm(@PathVariable Long id, Model model) {
		model.addAttribute("proposal", proposalRepositoryService.getProposalById(id));
		return "edit_proposal";
	}

	@PostMapping("/proposals/{id}")
	public String updateProposal(@PathVariable Long id,
			@ModelAttribute("proposal") Proposal proposal,
			Model model) {
		
		// get proposal from database by id
		Proposal existingProposal = proposalRepositoryService.getProposalById(id);
		existingProposal.setId(id);
		existingProposal.setProId(proposal.getProId());
		existingProposal.setSupplierName(proposal.getSupplierName());
		existingProposal.setProDes(proposal.getProDes());
		existingProposal.setDate(proposal.getDate());
		existingProposal.setStatus(proposal.getStatus());
		
		// save updated proposal object
		proposalRepositoryService.updateProposal(existingProposal);
		return "redirect:/proposals";		
	}
	
	// handler method to handle delete proposal prouest
	
	@GetMapping("/proposals/{id}")
	public String deleteProposal(@PathVariable Long id) {
		proposalRepositoryService.deleteProposalById(id);
		return "redirect:/proposals";
	}

}
