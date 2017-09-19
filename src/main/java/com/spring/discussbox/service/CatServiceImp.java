package com.spring.discussbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.discussbox.model.Categories;
import com.spring.discussbox.repository.CatRepository;

@Service("catService")
public class CatServiceImp implements CatService {

	@Autowired
	CatRepository catRepository;
	
	@Override
	public List<Categories> findAll() {
		
		return catRepository.findAll();
	}

}
