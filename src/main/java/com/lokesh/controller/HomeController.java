package com.lokesh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.lokesh.controller.HomeController;

@Controller
public class HomeController {

private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	
	@GetMapping("/")
	public String home() {
		LOGGER.info("In home controller the handler method is called which is returning the home page");
		return "home";
	}
	
	@GetMapping("/aDashboard")
	public String ReturnAdminDashBoard() {
		
		return "admin/admin-dashboard";
	}
	
	@GetMapping("/uDashboard")
	public String ReturnSupplierDashBoard() {
		
		return "user/user-dashboard";
	}
	

}
