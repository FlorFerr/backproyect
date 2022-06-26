package com.flor.backproyect.service;

import java.util.List;
import java.util.Optional;

import com.flor.backproyect.entity.Fav;


public interface FavService {
	
	public List<Fav> getAll();
	
	public Fav saveFav(Fav theFav);
	
	public Optional<Fav> findByUserIdAndIdFavAndCategory(int userId, int idFav, String category);
	
	public void deleteByUserIdAndIdFavAndCategory(int userId, int idFav, String category);

}
