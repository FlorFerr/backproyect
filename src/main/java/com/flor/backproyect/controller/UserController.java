package com.flor.backproyect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flor.backproyect.entity.Fav;
import com.flor.backproyect.entity.User;
import com.flor.backproyect.service.FavService;
import com.flor.backproyect.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	private UserService userService;
	private FavService favService;
	
	@Autowired
	public UserController(UserService theUserService, FavService theFavService) {
		userService = theUserService;	
		favService = theFavService;
	}
	
	@GetMapping("/users")
	public List<User> findAll(){
		return userService.getAll();
		
	}
	
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable int userId) {
		
		User theUser = userService.getUser(userId);
		
		if(theUser == null) {
			throw new RuntimeException("User id not found");
		}
		
		return theUser;
	}
	
	@PostMapping("users")
	public User saveUser(@RequestBody User theUser) {
		
		theUser.setId(0);
		userService.saveUser(theUser);
		
		return theUser;
	}
	
	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable int userId) {
	
		User tempUser = userService.getUser(userId);
		
		if(tempUser == null) {
			throw new RuntimeException("User not found");
		}
		
		userService.deleteUser(userId);
		return "Delete";
	}
	
	@PutMapping("users")
	public User updateUser(@RequestBody User theUser) {
		
		userService.saveUser(theUser);
		return theUser;
		
	}
	

	

}

	
