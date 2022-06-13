package com.flor.backproyect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flor.backproyect.dao.UserDAO;
import com.flor.backproyect.entity.User;

@RestController
@RequestMapping("/api")
public class UserController {
	
	private UserDAO userDAO;
	
	@Autowired
	public UserController(UserDAO theUserDAO) {
		userDAO = theUserDAO;		
	}
	
	@GetMapping("/user")
	public List<User> findAll(){
		return userDAO.findAll();
		
	}

}
