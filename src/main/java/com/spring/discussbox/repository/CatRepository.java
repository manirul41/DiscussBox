package com.spring.discussbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.discussbox.model.Categories;

@Repository("catRepository")
public interface CatRepository extends JpaRepository<Categories, Integer> {

}
