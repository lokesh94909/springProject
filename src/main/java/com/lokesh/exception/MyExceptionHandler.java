package com.lokesh.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(value = NoUserFoundException.class)
	public String handleNoUserFoundException(Model model) {
		model.addAttribute("errMsg", "No user found by the given credentials");
		return "error";
	}
	
	
	
	@ExceptionHandler(value=NullPointerException.class)
	public String handleNullPointerException(Model model) {
		
		model.addAttribute("msg", "Null pointer exception occured");
		return "error";
	}
}
