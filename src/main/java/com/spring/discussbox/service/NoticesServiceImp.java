package com.spring.discussbox.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.spring.discussbox.model.Notices;
import com.spring.discussbox.model.Users;
import com.spring.discussbox.repository.NoticesRepository;

@Service("noticesService")
public class NoticesServiceImp implements NoticesService {
	
	@Autowired
	NoticesRepository noticesRepository;
	
	/*@Autowired
	LoginRepository loginRepository;*/
	
	@Autowired
	UsersService usersService;
	
	@Override
	public void saveNotice(Notices notices) {
		Date now = new Date();
		notices.setDate(now);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getName());
		Users users = usersService.findUserByEmail(auth.getName());
		
		notices.setUsers(users);
		noticesRepository.save(notices);		
	}

	@Override
	public List<Notices> findAll() {
		return noticesRepository.findAll();
	}

	@Override
	public List<Notices> findByName(String email) {
		return noticesRepository.findByName(email);
	}

	@Override
	public Notices findByPara(String ntitle) {
		return noticesRepository.findByPara(ntitle);
	}

	@Override
	public Notices findPrime() {
		return noticesRepository.findPrime();
	}

}
