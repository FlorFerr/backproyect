package com.flor.backproyect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flor.backproyect.dao.FavRepository;
import com.flor.backproyect.entity.Fav;



@Service
public class FavServiceImpl implements FavService {
	
	private FavRepository favRepository;
	
	@Autowired
	public FavServiceImpl(FavRepository theFavRepository) {
		favRepository = theFavRepository;
	}

	@Override
	@Transactional
	public List<Fav> getAll() {

		return favRepository.findAll();	
		}

	@Override
	@Transactional
	public Fav saveFav(Fav theFav) {
		
		return favRepository.save(theFav);

	}
	
	@Override
	@Transactional
	public Fav getFav(int user, String category, int idProductFav) {
		
		return favRepository.findByUserIdAndCategoryAndIdProductFav(user, category, idProductFav);

	}

	@Override
	@Transactional
	public void deleteFav(int userId, String category, int idProductFav) {
		
		favRepository.deleteByUserIdAndCategoryAndIdProductFav(userId, category, idProductFav);
		
	}
	


	



}
