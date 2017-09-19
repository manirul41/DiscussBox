package com.spring.discussbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.discussbox.model.Login;

@Repository("loginRepository")
public interface LoginRepository extends JpaRepository<Login, Long> {

}
