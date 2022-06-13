package com.flor.backproyect.dao;

import java.util.List;
 
import javax.persistence.EntityManager;
 
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flor.backproyect.entity.User;
 

 
@Repository
public class UserDAOImpl implements UserDAO {
 
	// define field for entitymanager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public UserDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	@Transactional
	public List<User> findAll() {
 
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<User> theQuery =
				currentSession.createQuery("from User", User.class);
		
		// execute query and get result list
		List<User> employees = theQuery.getResultList();
		
		// return the results		
		return employees;
	}


	@Override
	@Transactional
	public User getUser(int userId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		User theUser = currentSession.get(User.class, userId);
		
		return theUser;
	}



 
}
