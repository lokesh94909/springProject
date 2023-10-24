package com.lokesh.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lokesh.controller.RegistrationController;
import com.lokesh.helper.Message;
import com.lokesh.model.User;
import com.lokesh.model.Admin;
import com.lokesh.service.UserRepositoryService;
import com.lokesh.service.AdminRepositoryService;

@Controller
public class RegistrationController {
	
private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

	
	@Autowired
	private AdminRepositoryService adminRepository;
	
	@Autowired
	private UserRepositoryService userRepository;
	
	@GetMapping("/userRegistration")
	public String userRegistration(Model model) {
		model.addAttribute("user", new User());
		LOGGER.info("In registration controller user registration handler is called");
		return "user_registration";
	}
	@GetMapping("/adminRegistration")
	public String adminRegistration(Model model) {
		model.addAttribute("admin", new Admin());
		LOGGER.info("In registration controller admin registration handler is called");
		return "admin_registration";
	}
	

	@PostMapping("/userRegister")
	public String doUserRegistration(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session,
			Model model) {
		try {
			if (result.hasErrors()) {
				model.addAttribute("user", user);
				LOGGER.warn("In registration controller there is error in the binding result");
				return "user_registration";
			}
			User savedUser = userRepository.save(user);
			LOGGER.info("user is successfully store in the database with the emailId "+savedUser.getEmail());
			model.addAttribute("user", new User());
			session.setAttribute("message", new Message("You have successfully registered", "alert-success"));
			return "user_registration";
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("user", user);
			session.setAttribute("message", new Message("Duplicate entry for contact number", "alert-danger"));
			LOGGER.warn("user cannot save into the databse because of the duplicate mobile number");
			return "redirect:/user_register";
		}
	}
	
	@PostMapping("/adminRegister")
	public String doAdminRegistration(@Valid @ModelAttribute("admin") Admin admin, BindingResult result, HttpSession session,
			Model model) {
		
			if (result.hasErrors()) {
				model.addAttribute("admin", admin);
				LOGGER.warn("In registration controller there is some error in the binding result at the time of the admin registration");
				return "admin_registration";
			}
			
			
			Admin adminFromDB = null;
			try {
//				admin.setContactDetails(contactDetails);
				adminFromDB = adminRepository.save(admin);
			}catch (Exception e) {
				session.setAttribute("message", new Message("Duplicate entry for contact number", "alert-danger"));
				LOGGER.warn("admin object cannot save into the database because of the duplicate mobile number");
				model.addAttribute("admin", admin);		
				return "admin_registration";
			}
			
			model.addAttribute("admin", adminFromDB);
			session.setAttribute("message", new Message("You have successfully registered", "alert-success"));
			session.setAttribute("adminId", adminFromDB.getAdminId());
			LOGGER.info("admin is successfully saved into the database whose admin id is "+adminFromDB.getAdminId());
			return "admin_registration";
		
	}
	
	

}