package com.flor.backproyect.service;

import java.util.List;

import com.flor.backproyect.entity.Fav;
import com.flor.backproyect.entity.User;


public interface FavService {
	
	public List<Fav> getAll();
	
	public Fav saveFav(Fav theFav);




	
}
