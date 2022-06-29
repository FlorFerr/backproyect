package com.flor.backproyect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flor.backproyect.dao.IUserRepository;
import com.flor.backproyect.entity.User;

@Service
public class UserService{
	
	@Autowired
	private IUserRepository userRepository;

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public Optional<User> getUser(int userId) {
		return userRepository.findById(userId);
	}

	public User saveUser(User theUser) {
		return userRepository.save(theUser);
	}

	public void deleteUser(int userId) {
		userRepository.deleteById(userId);
	}

	public Optional<User> findByEmailAndPass(String email, String pass) {
		Optional<User> theUser = userRepository.findByEmailAndPass(email, pass);
		return theUser;
	}
}
