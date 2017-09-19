package com.spring.discussbox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.discussbox.model.Notices;

public interface NoticesRepository extends JpaRepository<Notices, Long> {

	@Query("SELECT p FROM Notices p WHERE users.email = :email")
	List<Notices> findByName(@Param("email") String email);
	
	@Query("SELECT s FROM Notices s WHERE ntitle = :ntitle")
	Notices findByPara(@Param("ntitle") String ntitle);

	@Query("select 1  from Notices  ORDER By notice_id DESC")
	Notices findPrime();

}
