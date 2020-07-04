package com.spring.interview.controllers;

import java.util.HashSet;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.interview.models.Role;
import com.spring.interview.models.User;
import com.spring.interview.respos.UserDao;
import com.spring.interview.services.SecurityService;
import com.spring.interview.services.UserService;
import com.spring.interview.validator.UserValidator;

@Controller
public class MainController {

	 	@Autowired
	    private UserService userService;
	    @Autowired
	    private SecurityService securityService;
	    @Autowired
	    private UserValidator userValidator;
	    @Autowired
	    BCryptPasswordEncoder passwdEncoder;
	    
	    
	    @GetMapping("/registration")
	    public String registration(Model model) {
	        model.addAttribute("userForm", new User());

	        return "registration";
	    }

	    @PostMapping("/registration")
	    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
	        userValidator.validate(userForm, bindingResult);

	        if (bindingResult.hasErrors()) {
	            return "registration";
	        }

	        userService.save(userForm);

	        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

	        return "redirect:/welcome";
	    }

	    @GetMapping("/login")
	    public String login(Model model, String error, String logout) {
	        if (error != null)
	            model.addAttribute("error", "Your username and password is invalid.");

	        if (logout != null)
	            model.addAttribute("message", "You have been logged out successfully.");

	        return "login";
	    }
	    

	    @GetMapping({"/", "/welcome"})
	    public String welcome(Model model) {
	        return "welcome";
	    }
	    
	    @Autowired
	    private UserDao userDao;
	    @GetMapping("/saveTestUser")
	    public @ResponseBody Integer saveTestUser() {
	    	
	    	User user = new User();
	    	user.setUsername("FirstTest");
	    	user.setPassword(passwdEncoder.encode("passwd"));
	    	HashSet users = new HashSet();
	    	users.add(user);
	    	Role role = new Role();
	    	role.setName("Test");
	    	role.setUsers(users);
	    	
	    	return userDao.createUser(user);
	    }
}
