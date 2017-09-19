package com.spring.discussbox.service;

import com.spring.discussbox.model.Users;

public interface UsersService {
	public Users findUserByEmail(String email);

	public void saveusers(Users users);
	
}
