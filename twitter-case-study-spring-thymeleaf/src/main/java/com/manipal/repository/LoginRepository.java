package com.manipal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manipal.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {
	
	//@Query("SELECT l FROM Login l WHERE l.userName = ?1")
	Login findByUserName(String userName);
}
