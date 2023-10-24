package com.lokesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lokesh.model.Delivery;
import com.lokesh.service.DeliveryRepositoryService;

@Controller
public class DeliveryController {

	private DeliveryRepositoryService deliveryRepositoryService;

	public DeliveryController(DeliveryRepositoryService deliveryRepositoryService) {
		super();
		this.deliveryRepositoryService = deliveryRepositoryService;
	}
	
	// handler method to handle list deliverys and return mode and view
	@GetMapping("/deliverys")
	public String listDeliverys(Model model) {
		model.addAttribute("deliverys", deliveryRepositoryService.getAllDeliverys());
		return "deliverys";
	}
	
	@GetMapping("/adeliverys")
	public String listDeliverysOfSupplier(Model model) {
		model.addAttribute("deliverys", deliveryRepositoryService.getAllDeliverys());
		return "Admindelivery";
	}
	
	
	@GetMapping("/SupplierDelivery")
	public String listDeliverysForSupplier(Model model) {
		model.addAttribute("deliverys", deliveryRepositoryService.getAllDeliverys());
		return "SupplierDelivery";
	}
	
	
	
	@GetMapping("/deliverys/new")
	public String createDeliveryForm(Model model) {
		
		// create delivery object to hold delivery form data
		Delivery delivery = new Delivery();
		model.addAttribute("delivery", delivery);
		return "create_delivery";
		
	}
	
	@PostMapping("/deliverys")
	public String saveDelivery(@ModelAttribute("delivery") Delivery delivery) {
		deliveryRepositoryService.saveDelivery(delivery);
		return "create_delivery";
	}
	
	@GetMapping("/deliverys/edit/{id}")
	public String editDeliveryForm(@PathVariable Long id, Model model) {
		model.addAttribute("delivery", deliveryRepositoryService.getDeliveryById(id));
		return "edit_delivery";
	}

	@PostMapping("/deliverys/{id}")
	public String updateDelivery(@PathVariable Long id,
			@ModelAttribute("delivery") Delivery delivery,
			Model model) {
		
		// get delivery from database by id
		Delivery existingDelivery = deliveryRepositoryService.getDeliveryById(id);
		existingDelivery.setId(id);
		existingDelivery.setStatus(delivery.getStatus());
		
		// save updated delivery object
		deliveryRepositoryService.updateDelivery(existingDelivery);
		return "redirect:/deliverys";		
	}
	
	// handler method to handle delete delivery prouest
	
	@GetMapping("/deliverys/{id}")
	public String deleteDelivery(@PathVariable Long id) {
		deliveryRepositoryService.deleteDeliveryById(id);
		return "redirect:/deliverys";
	}
}
