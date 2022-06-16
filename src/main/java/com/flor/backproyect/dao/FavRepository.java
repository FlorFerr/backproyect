package com.flor.backproyect.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flor.backproyect.entity.Fav;

public interface FavRepository extends JpaRepository<Fav, Integer> {
	
	Fav findByUserIdAndCategoryAndIdProductFav(int userId, String category, int idProductFav);
	
	void deleteByUserIdAndCategoryAndIdProductFav(int userId, String category, int idProductFav);


}
