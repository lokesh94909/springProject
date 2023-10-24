package com.lokesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lokesh.model.Feedback;
import com.lokesh.service.FeedbackRepositoryService;

@Controller
public class FeedbackController {

	
	private FeedbackRepositoryService feedbackRepositoryService;

	public FeedbackController(FeedbackRepositoryService feedbackRepositoryService) {
		super();
		this.feedbackRepositoryService = feedbackRepositoryService;
	}
	
	// handler method to handle list feedbacks and return mode and view
	@GetMapping("/feedbacks")
	public String listFeedbacks(Model model) {
		model.addAttribute("feedbacks", feedbackRepositoryService.getAllFeedbacks());
		return "feedbacks";
	}
	
	@GetMapping("/afeedbacks")
	public String listFeedbacksFromSupplier(Model model) {
		model.addAttribute("feedbacks", feedbackRepositoryService.getAllFeedbacks());
		return "Supplierfeedbacks";
	}
	
	
	
	@GetMapping("/feedbacks/new")
	public String createFeedbackForm(Model model) {
		
		// create feedback object to hold feedback form data
		Feedback feedback = new Feedback();
		model.addAttribute("feedback", feedback);
		return "create_feedback";
		
	}
	
	@PostMapping("/feedbacks")
	public String saveFeedback(@ModelAttribute("feedback") Feedback feedback) {
		feedbackRepositoryService.saveFeedback(feedback);
		return "create_feedback";
	}
	
//	@GetMapping("/feedbacks/edit/{id}")
//	public String editFeedbackForm(@PathVariable Long id, Model model) {
//		model.addAttribute("feedback", feedbackRepositoryService.getFeedbackById(id));
//		return "edit_feedback";
//	}
//
//	@PostMapping("/feedbacks/{id}")
//	public String updateFeedback(@PathVariable Long id,
//			@ModelAttribute("feedback") Feedback feedback,
//			Model model) {
//		
//		// get feedback from database by id
//		Feedback existingFeedback = feedbackRepositoryService.getFeedbackById(id);
//		existingFeedback.setId(id);
//		existingFeedback.setName(feedback.getName());
//		existingFeedback.setCid(feedback.getCid());
//	
//		
//		// save updated feedback object
//		//feedbackRepositoryService.updateFeedback(existingFeedback);
//		return "redirect:/feedbacks";		
//	}
//	
//	// handler method to handle delete feedback prouest
//	
//	@GetMapping("/feedbacks/{id}")
//	public String deleteFeedback(@PathVariable Long id) {
//		feedbackRepositoryService.deleteFeedbackById(id);
//		return "redirect:/feedbacks";
//	}
}
