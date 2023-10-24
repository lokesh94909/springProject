package com.lokesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lokesh.model.Amenitie;
import com.lokesh.service.AmenitieRepositoryService;

@Controller
public class AmenitieController {
	
	private AmenitieRepositoryService amenitieRepositoryService;

	public AmenitieController(AmenitieRepositoryService amenitieRepositoryService) {
		super();
		this.amenitieRepositoryService = amenitieRepositoryService;
	}
	
	// handler method to handle list amenities and return mode and view
	@GetMapping("/amenities")
	public String listAmenities(Model model) {
		model.addAttribute("amenities", amenitieRepositoryService.getAllAmenities());
		return "amenities";
	}
	

		
	
	
	@GetMapping("/amenities/new")
	public String createAmenitieForm(Model model) {
		
		// create amenitie object to hold amenitie form data
		Amenitie amenitie = new Amenitie();
		model.addAttribute("amenitie", amenitie);
		return "create_amenitie";
		
	}
	
	@PostMapping("/amenities")
	public String saveAmenitie(@ModelAttribute("amenitie") Amenitie amenitie) {
		amenitieRepositoryService.saveAmenitie(amenitie);
		return "create_amenitie";
	}
	
	@GetMapping("/amenities/edit/{id}")
	public String editAmenitieForm(@PathVariable Long id, Model model) {
		model.addAttribute("amenitie", amenitieRepositoryService.getAmenitieById(id));
		return "edit_amenitie";
	}

	@PostMapping("/amenities/{id}")
	public String updateAmenitie(@PathVariable Long id,
			@ModelAttribute("amenitie") Amenitie amenitie,
			Model model) {
		
		// get amenitie from database by id
		Amenitie existingAmenitie = amenitieRepositoryService.getAmenitieById(id);
		existingAmenitie.setId(id);
		existingAmenitie.setAmId(amenitie.getAmId());
		existingAmenitie.setAmHours(amenitie.getAmPeople());
		existingAmenitie.setAmHours(amenitie.getAmHours());
		existingAmenitie.setAmPrice(amenitie.getAmPrice());
		
		
		// save updated amenitie object
		amenitieRepositoryService.updateAmenitie(existingAmenitie);
		return "redirect:/amenities";		
	}
	
	// handler method to handle delete amenitie prouest
	
	@GetMapping("/amenities/{id}")
	public String deleteAmenitie(@PathVariable Long id) {
		amenitieRepositoryService.deleteAmenitieById(id);
		return "redirect:/amenities";
	}

}
