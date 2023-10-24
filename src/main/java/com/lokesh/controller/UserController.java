package com.lokesh.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lokesh.controller.UserController;
import com.lokesh.exception.NoUserFoundException;
import com.lokesh.helper.Message;

import com.lokesh.model.User;

import com.lokesh.service.UserRepositoryService;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserRepositoryService userRepositoryService;
	
	@PostMapping("/userDashboard")
	public String validateUser(@ModelAttribute("user") User user, HttpSession session, Model model) throws NoUserFoundException {
		LOGGER.info("In user controller validateUser handler method is called");
		List<User> userList = null;
		
		try {
			userList = userRepositoryService.findByEmailAndPassword(user.getEmail(), user.getPassword());
			if(userList.size()==0) {
				throw new NoUserFoundException("User is not found in the database by the given email id and password");
			}
		}catch(NoUserFoundException e) {
			
		}
		catch (Exception e) {
			session.setAttribute("message", new Message("Your email-id or password is invalid", "alert-danger"));
			return "redirect:/userLogin";
		}
		if (userList.size() > 0) {
			User userFromDB = userRepositoryService.findByEmail(user.getEmail());
			model.addAttribute("userId", userFromDB.getUserId());
			model.addAttribute("user", userFromDB);
			LOGGER.info("user is succefully authenticated and is redirected to the user dashboard");
			return "user/user-dashboard";
		}
		LOGGER.warn("the user email " + user.getEmail() + " user password " + user.getPassword() + " is not matched");

		session.setAttribute("message", new Message("Your email-id or password is invalid", "alert-danger"));
		return "redirect:/userLogin";
	}







}
