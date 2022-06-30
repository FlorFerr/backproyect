package com.flor.backproyect.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flor.backproyect.entity.User;
import com.flor.backproyect.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> findAll(){
		return userService.getAll();
	}
	
	@GetMapping("/users/find/{userId}")
	public Optional<User> getUser(@PathVariable int userId) {
		Optional<User> theUser = userService.getUser(userId);
		if(theUser == null) {
			throw new RuntimeException("Usuario no encontrado");
		}
		return theUser;
	}

	@PostMapping("/login")
	public Optional<User> login(@RequestBody User theUser) {
		Optional<User> user = userService.findByEmailAndPass(theUser.getEmail(), theUser.getPass());
		if(user.isPresent()) {
			if(user.get().getPass() == theUser.getPass()) {
				return user;
			}
		}else {
			throw new RuntimeException("Usuario o contraseña incorrecta");
			}
		return user;
	}
	
	@PostMapping("/users")
	public User saveUser(@RequestBody User theUser) {
		theUser.setId(0);
		userService.saveUser(theUser);
		return theUser;
	}
	
	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable int userId) {
		Optional<User> tempUser = userService.getUser(userId);
		if(tempUser == null) {
			throw new RuntimeException("Usuario no encontrado");
		}
		userService.deleteUser(userId);
		return "Delete user: " + userId;
	}
}

	
