package com.flor.backproyect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flor.backproyect.dao.FavDAO;
import com.flor.backproyect.entity.Fav;


@Service
public class FavServiceImpl implements FavService {
	
	private FavDAO favDAO;
	
	@Autowired
	public FavServiceImpl(FavDAO theFavDAO) {
		favDAO = theFavDAO;
	}

	@Override
	@Transactional
	public List<Fav> getAll() {

		return favDAO.getAll();
	}

	@Override
	@Transactional
	public Fav saveFav(Fav theFav) {
		
		return favDAO.saveFav(theFav);

	}



}
