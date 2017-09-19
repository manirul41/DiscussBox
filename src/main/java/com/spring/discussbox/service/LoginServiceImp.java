package com.spring.discussbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.discussbox.model.Login;
import com.spring.discussbox.model.Users;
import com.spring.discussbox.repository.LoginRepository;

@Service("loginService")
public class LoginServiceImp implements LoginService {

	@Autowired
	LoginRepository loginRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void savelogin(Login login, Users users) {
		login.setPassword(bCryptPasswordEncoder.encode(login.getPassword()));
		login.setUsers(users);
		login.setActive(true);
		login.setRole("ADMIN");
		loginRepository.save(login);
		
	}
}
