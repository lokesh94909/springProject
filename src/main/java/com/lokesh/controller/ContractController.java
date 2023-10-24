package com.lokesh.controller;

 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

 

import com.lokesh.model.Contract;

import com.lokesh.service.ContractRepositoryService;


 

@Controller
public class ContractController {
    
	private ContractRepositoryService contractRepositoryService;

	public ContractController(ContractRepositoryService contractRepositoryService) {
		super();
		this.contractRepositoryService = contractRepositoryService;
	}
	
	// handler method to handle list contracts and return mode and view
	@GetMapping("/contracts")
	public String listProposals(Model model) {
		model.addAttribute("contracts", contractRepositoryService.getAllContracts());
		return "contracts";
	}
	
	@GetMapping("/acontracts")
	public String listProposalsForSupplier(Model model) {
		model.addAttribute("contracts", contractRepositoryService.getAllContracts());
		return "contractsFromSupplier";
	}
	

	@GetMapping("/samenitie")
	public String listOfContractsOfSupplier(Model model) {
		model.addAttribute("contracts", contractRepositoryService.getAllContracts());
		return "setAmenitiesToContract";
	}
	
	@GetMapping("/contractsList")
	public String listOfSupplier(Model model) {
		model.addAttribute("contracts", contractRepositoryService.getAllContracts());
		return "totalSupplier";
	}
	
	

	
	
	
	@GetMapping("/contracts/new")
	public String createProposalForm(Model model) {
		
		// create contract object to hold contract form data
		Contract contract = new Contract();
		model.addAttribute("contract", contract);
		return "create_contract";
		
	}
	
	@PostMapping("/contracts")
	public String saveProposal(@ModelAttribute("contract") Contract contract) {
		contractRepositoryService.saveContract(contract);
		return "amenities";
	}
	
	@GetMapping("/contracts/edit/{id}")
	public String editProposalForm(@PathVariable Long id, Model model) {
		model.addAttribute("contract", contractRepositoryService.getContractById(id));
		return "edit_contract";
	}

	@PostMapping("/contracts/{id}")
	public String updateProposal(@PathVariable Long id,
			@ModelAttribute("contract") Contract contract,
			Model model) {
		
		// get contract from database by id
		Contract existingProposal = contractRepositoryService.getContractById(id);
		existingProposal.setId(id);
		existingProposal.setConType(contract.getConType());
		existingProposal.setSupplierName(contract.getSupplierName());
		existingProposal.setConDes(contract.getConDes());
		existingProposal.setDate(contract.getDate());
		existingProposal.setDuration(contract.getDuration());
		
		// save updated contract object
		contractRepositoryService.updateContract(existingProposal);
		return "redirect:/contracts";		
	}
	
	// handler method to handle delete contract prouest
	
	@GetMapping("/contracts/{id}")
	public String deleteProposal(@PathVariable Long id) {
		contractRepositoryService.deleteContractById(id);
		return "redirect:/feedbacks/new";
	}
 


}