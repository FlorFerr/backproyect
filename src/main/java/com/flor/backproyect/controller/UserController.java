package com.flor.backproyect.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flor.backproyect.entity.User;
import com.flor.backproyect.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService theUserService) {
		userService = theUserService;	
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

	@PostMapping("login")
	public int login(@RequestBody User theUser) {
		
		Optional<User> user = userService.findByEmailAndPass(theUser.getEmail(), theUser.getPass());
		
		
		if(user.isPresent()) {
			if(user.get().getPass() == theUser.getPass()) {
				return user.get().getId();
			}
		}else {
			throw new RuntimeException("Usuario o contraseña incorrecta");
			}
		return user.get().getId();
	}
	
	@PostMapping("users")
	public User saveUser(@RequestBody User theUser) {
		
		theUser.setId(0);
		userService.saveUser(theUser);
		
		return theUser;
	}
	
	@DeleteMapping("/users")
	public String deleteUser(@RequestParam int userId) {
	
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

	
