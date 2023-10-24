package com.lokesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LogoutController {

	@GetMapping("/logout")
	public String home() {
		return "home";
	}
}
