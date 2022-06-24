package com.flor.backproyect.service;

import java.util.List;
import java.util.Optional;

import com.flor.backproyect.entity.Fav;


public interface FavService {
	
	public List<Fav> getAll();
	
	public Fav saveFav(Fav theFav);
	
	public Optional<Fav> findByUserIdAndIdProductFavAndCategory(int userId, int idProductFav, String category);
	
	public void deleteByUserIdAndIdProductFavAndCategory(int userId, int idProductFav, String category);


	
	
}
