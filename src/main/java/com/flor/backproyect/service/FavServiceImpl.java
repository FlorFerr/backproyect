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
	public void deleteByName(String name) {
		favRepository.deleteByName(name);
		
	}

	@Override
	@Transactional
	public Fav getByIdProduct(int idProductFav) {

		
		Optional<Fav> result = favRepository.findByIdProductFav(idProductFav);
		
		Fav theFav = null;
		
		if(result.isPresent()) {
			theFav = result.get();
		}
		else {
			throw new RuntimeException("Fav not found");
		}
		return theFav;
	}


	


	



}
