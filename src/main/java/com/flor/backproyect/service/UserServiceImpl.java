package com.flor.backproyect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flor.backproyect.dao.UserRepository;
import com.flor.backproyect.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository theUserRepository) {
		userRepository = theUserRepository;
	}

	@Override
	@Transactional
	public List<User> getAll() {

		return userRepository.findAll();
	}

	@Override
	@Transactional
	public User getUser(int userId) {
		
		Optional<User> result = userRepository.findById(userId);
		
		User theUser = null;
		if(result.isPresent()) {
			theUser = result.get();
		}
		else {
			throw new RuntimeException("User not found");
		}
		
		return theUser;
	}

	@Override
	@Transactional
	public User saveUser(User theUser) {
		
		return userRepository.save(theUser);

	}

	@Override
	@Transactional
	public void deleteUser(int userId) {
		userRepository.deleteById(userId);

	}

}
