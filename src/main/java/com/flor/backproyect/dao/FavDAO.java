package com.flor.backproyect.dao;

import java.util.List;

import com.flor.backproyect.entity.Fav;

public interface FavDAO {
	
	public List<Fav> getAll();

	public Fav saveFav(Fav theFav);



}
