package com.spring.discussbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.discussbox.model.Users;

@Repository("usersRepository")
public interface UsersRepository extends JpaRepository<Users, Long> {
	Users findByEmail(String email);
}
