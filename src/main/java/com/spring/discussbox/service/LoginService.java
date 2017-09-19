package com.spring.discussbox.service;

import com.spring.discussbox.model.Login;
import com.spring.discussbox.model.Users;

public interface LoginService {
	void savelogin(Login login,Users users);
	
}
