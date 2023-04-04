package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls, Integer> {

	//method to check email exist or not at register
	public boolean existsByEmail(String email);

	//method to check email exist or not while login
	public UserDtls findByEmail(String email);
}
