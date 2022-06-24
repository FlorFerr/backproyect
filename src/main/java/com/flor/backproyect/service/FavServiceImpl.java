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
	public Optional<Fav> findByIdProductFavAndCategory(int idProductFav, String category) {

		Optional<Fav> theFav = favRepository.findByIdProductFavAndCategory(idProductFav, category);
		return theFav;
	}

	@Override
	@Transactional
	public void deleteByIdProductFavAndCategory(int idProductFav, String category) {
		
		favRepository.deleteByIdProductFavAndCategory(idProductFav, category);
		
	}

	@Override
	@Transactional
	public Optional<Fav> findByUserIdAndIdProductFavAndCategory(int userId, int idProductFav, String category) {
		return favRepository.findByUserIdAndIdProductFavAndCategory(userId, idProductFav, category);
	}

	@Override
	@Transactional
	public void deleteByUserIdAndIdProductFavAndCategory(int userId, int idProductFav, String category) {
		favRepository.deleteByUserIdAndIdProductFavAndCategory(userId, idProductFav, category);
	}

	

	


	


	



}
