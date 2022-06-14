package com.flor.backproyect.service;

import java.util.List;

import com.flor.backproyect.entity.User;

public interface UserService {
	
	public List<User> getAll();

	public User getUser(int userId);
	
	public User saveUser(User theUser);
	
	public void deleteUser(int userId);

}
