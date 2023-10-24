package com.lokesh.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lokesh.controller.AdminController;
import com.lokesh.helper.Message;

import com.lokesh.model.Admin;
import com.lokesh.service.AdminRepositoryService;

@RequestMapping("/admin")
@Controller
public class AdminController {

	
private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

	
	@Autowired
	private AdminRepositoryService adminRepositoryService;

	@PostMapping("/adminDashboard")
	public String validateAdmin(@ModelAttribute("admin") Admin admin, HttpSession session, Model model) {
		List<Admin> adminList;
		LOGGER.info("In admin controller validateAdmin handler method is called");
		try {
			adminList = adminRepositoryService.findByAdminIdAndPassword(admin.getAdminId(), admin.getPassword());
		} catch (Exception e) {
			session.setAttribute("message", new Message("Your admin-id or password is invalid", "alert-danger"));
			return "redirect:/adminLogin";
		}
		if (adminList.size() > 0) {
			model.addAttribute("admin", admin);
		
			LOGGER.info("admin is succefully authenticated and is redirected to the admin dashboard");
			return "admin/admin-dashboard";
		}
		LOGGER.warn("the admin ID "+admin.getAdminId()+" admin password "+admin.getPassword()+" is not matched");
		session.setAttribute("message", new Message("Your email-id or password is invalid", "alert-danger"));
		return "redirect:/adminLogin";
	}




	
	}

