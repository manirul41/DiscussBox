package com.spring.discussbox.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.discussbox.model.Login;
import com.spring.discussbox.model.Users;
import com.spring.discussbox.service.LoginService;
import com.spring.discussbox.service.UsersService;

@Controller
public class LoginController {
	
	@Autowired
	UsersService usersService;	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = { "/","/login" }, method = RequestMethod.GET)
	public ModelAndView showlogin() {
		ModelAndView mv = new ModelAndView();
		/*Login login = new Login();
		mv.addObject("login", login);*/
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping(value = "/reg", method = RequestMethod.GET)
	public ModelAndView showReg() {
		ModelAndView mv = new ModelAndView();
		Users users = new Users();
		Login login = new Login();
		mv.addObject("users", users);
		mv.addObject("login", login);
		mv.setViewName("registration");
		return mv;
	}
	
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public ModelAndView proReg(@Valid Users users, @Valid Login login, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
		Users exUser = usersService.findUserByEmail(users.getEmail());
		if(exUser != null) {
			//bindingResult.rejectValue("email", "error.users", "There is already a user registered with the email provided");
			mv.addObject("xemailMessage", "There is already a user registered with the email provided");
			mv.setViewName("registration");
		}
		if(bindingResult.hasErrors()) {
			mv.addObject("msg", "error");
			mv.setViewName("registration");
		} else {
			usersService.saveusers(users);
			loginService.savelogin(login,users);
			mv.addObject("successMessage", "User has been registered successfully");
			mv.addObject("users", new Users());
			mv.addObject("login", new Login());
			mv.setViewName("login");
		}
		return mv;
	}
	
	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getName());
		Users users = usersService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", users.getFullname());
//		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		modelAndView.setViewName("redirect:/admin/allnotice");
		return modelAndView;
	}
}
