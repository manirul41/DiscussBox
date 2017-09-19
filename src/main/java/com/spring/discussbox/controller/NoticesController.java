package com.spring.discussbox.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.discussbox.model.Categories;
import com.spring.discussbox.model.Notices;
import com.spring.discussbox.model.Users;
import com.spring.discussbox.service.CatService;
import com.spring.discussbox.service.NoticesService;
import com.spring.discussbox.service.UsersService;

@Controller
public class NoticesController {
	
	@Autowired
	UsersService usersService;
	@Autowired
	NoticesService noticesService;
	@Autowired
	CatService catService;
	
	
	@RequestMapping(value="/admin/addNotice", method = RequestMethod.GET)
	public ModelAndView addNotice() {
		ModelAndView mv = new ModelAndView();
		Notices notices = new Notices();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Users users = usersService.findUserByEmail(auth.getName());
		mv.addObject("userName", users.getFullname());
		mv.addObject("notices", notices);
		mv.setViewName("admin/addNotice");
		return mv;
	}
	
	@RequestMapping(value="/admin/savenotice", method = RequestMethod.POST)
	public ModelAndView saveNotice(Notices notices, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			mv.addObject("msg", "error");
			mv.setViewName("admin/addNotice");
			System.out.println("error");
		} else {
			noticesService.saveNotice(notices);
			mv.setViewName("redirect:/admin/allnotice");
		}
		return mv;
	}
	
	@RequestMapping("/admin/allnotice")
	public ModelAndView showNotices() {
		
		ModelAndView mv = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Users users = usersService.findUserByEmail(auth.getName());
		mv.addObject("userName", users.getFullname());
		
		List<Notices> notices = (List<Notices>) noticesService.findAll();
		Collections.reverse(notices);
		
		List<Categories> categories = (List<Categories>) catService.findAll();
		Collections.reverse(categories);
		
		System.out.println("Notices out-----------"+notices);
		System.out.println("Cat out-----------"+categories);
		mv.addObject("categories", categories);
		mv.addObject("notices", notices);
		mv.setViewName("admin/home");
		return mv;
	}
	
	@RequestMapping("/admin/mynotice")
	public ModelAndView showOneNotices() {
		
		ModelAndView mv = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Users users = usersService.findUserByEmail(auth.getName());
		mv.addObject("userName", users.getFullname());
		
		List<Notices> notices = (List<Notices>) noticesService.findByName(auth.getName());
		Collections.reverse(notices);
		
		
		System.out.println("Notices out-----------"+notices);
		mv.addObject("notices", notices);
		mv.setViewName("admin/home");
		return mv;
	}
	
	@RequestMapping("/admin/{ntitle}")
	public ModelAndView showOneNotice(@PathVariable ( value="ntitle") String ntitle) {
		
		ModelAndView mv = new ModelAndView();
		System.out.println(ntitle);
		Notices notice = noticesService.findByPara(ntitle);
		System.out.println("Notice out--------"+notice);
		System.out.println("Notice out--------"+notice.getNtitle());
		mv.addObject("notice", notice);
		mv.setViewName("/admin/notice");
		return mv;
		
	}
	
//	@RequestMapping("/admin/allnotice")
//	public ModelAndView showPrimeNews() {
//		ModelAndView mv = new ModelAndView();
//		
//		Notices primeNews = noticesService.findPrime();
//		System.out.println("PrimeNews--------"+primeNews);
//		System.out.println("PrimeNews---------"+primeNews.getNtitle());
//		mv.addObject("primeNews", primeNews);
//		mv.setViewName("admin/home");
//		return mv;
//	}

}
