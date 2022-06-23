package com.flor.backproyect.service;

import java.util.List;
import java.util.Optional;

import com.flor.backproyect.entity.User;

public interface UserService {
	
	public List<User> getAll();

	public User getUser(int userId);
	
	public User saveUser(User theUser);
	
	public void deleteUser(int userId);

	public Optional<User> findByEmailAndPass(String email, String pass);
}
