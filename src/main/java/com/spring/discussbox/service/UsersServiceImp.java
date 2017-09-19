package com.spring.discussbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.discussbox.model.Users;
import com.spring.discussbox.repository.UsersRepository;

@Service("usersService")
public class UsersServiceImp implements UsersService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public Users findUserByEmail(String email) {
		
		return usersRepository.findByEmail(email);
	}

	@Override
	public void saveusers(Users users) {
		usersRepository.save(users);
		
	}
	
	

}
