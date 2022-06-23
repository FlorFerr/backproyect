package com.flor.backproyect.service;

import java.util.List;
import java.util.Optional;

import com.flor.backproyect.entity.Fav;


public interface FavService {
	
	public List<Fav> getAll();
	
	public Fav saveFav(Fav theFav);

	public void deleteByName(String name);
	
	public Optional<Fav> findByName(String name);




	
}
