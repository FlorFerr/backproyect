package com.flor.backproyect.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flor.backproyect.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
	
	public Optional<User> findByEmailAndPass(String email, String pass);	
}
