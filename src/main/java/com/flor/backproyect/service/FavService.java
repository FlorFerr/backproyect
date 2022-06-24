package com.flor.backproyect.service;

import java.util.List;
import java.util.Optional;

import com.flor.backproyect.entity.Fav;


public interface FavService {
	
	public List<Fav> getAll();
	
	public Fav saveFav(Fav theFav);

	public void deleteByIdProductFavAndCategory(int idProductFav, String category);
	
	public Optional<Fav> findByIdProductFavAndCategory(int idProductFav, String category);
	
}
