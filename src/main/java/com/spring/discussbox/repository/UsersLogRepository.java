package com.spring.discussbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.discussbox.model.UsersLog;

public interface UsersLogRepository extends JpaRepository<UsersLog, Integer> {

}
