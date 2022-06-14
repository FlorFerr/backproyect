package com.flor.backproyect.dao;

import java.util.List;

import com.flor.backproyect.entity.Fav;
import com.flor.backproyect.entity.User;

public interface UserDAO {
	
	public List<User> getAll();

	public User getUser(int userId);
	
	public User saveUser(User theUser);
	
	public void deleteUser(int userId);


}
