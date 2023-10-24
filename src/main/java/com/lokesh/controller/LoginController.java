package com.lokesh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.lokesh.controller.LoginController;

@Controller
public class LoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);



	@GetMapping("/userLogin")
	public String userLogin() {
		LOGGER.info("In login controller user login handler is called");
		return "user/user-login";
	}
	
	@GetMapping("/adminLogin")
	public String adminLogin() {
		LOGGER.info("In login controller admin admin handler is called");
		return "admin/admin-login";
	}


}