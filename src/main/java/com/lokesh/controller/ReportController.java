package com.lokesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {
	
	@GetMapping("/areport")
	public String AdminReport() {
		
		return "adminReport";
	}
	@GetMapping("/areportsupplier")
	public String TotalSupplier() {
		
		return "totalSupplier";
	}
	
}
