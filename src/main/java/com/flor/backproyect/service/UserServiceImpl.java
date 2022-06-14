package com.flor.backproyect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flor.backproyect.dao.UserDAO;
import com.flor.backproyect.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDAO userDAO;
	
	@Autowired
	public UserServiceImpl(UserDAO theUserDAO) {
		userDAO = theUserDAO;
	}

	@Override
	@Transactional
	public List<User> getAll() {

		return userDAO.getAll();
	}

	@Override
	@Transactional
	public User getUser(int userId) {

		return userDAO.getUser(userId);
	}

	@Override
	@Transactional
	public User saveUser(User theUser) {
		
		return userDAO.saveUser(theUser);

	}

	@Override
	@Transactional
	public void deleteUser(int userId) {
		userDAO.deleteUser(userId);

	}

}
