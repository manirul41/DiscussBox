package com.spring.discussbox.service;

import java.util.List;

import com.spring.discussbox.model.Notices;

public interface NoticesService {

	void saveNotice(Notices notices);

	List<Notices> findAll();

	List<Notices> findByName(String email);

	Notices findByPara(String ntitle);

	Notices findPrime();
	
}
