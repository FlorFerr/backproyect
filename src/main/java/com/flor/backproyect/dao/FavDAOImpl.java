package com.flor.backproyect.dao;

import java.util.List;
 
import javax.persistence.EntityManager;
 
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flor.backproyect.entity.Fav;

 

 
@Repository
public class FavDAOImpl implements FavDAO {
 
	// define field for entitymanager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public FavDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Fav> getAll() {
 
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Fav> theQuery =
				currentSession.createQuery("from Fav", Fav.class);
		
		// execute query and get result list
		List<Fav> favs = theQuery.getResultList();
		
		// return the results		
		return favs;
	}


	@Override
	@Transactional
	public Fav saveFav(Fav theFav) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theFav);
		return theFav;
	}


 
}
