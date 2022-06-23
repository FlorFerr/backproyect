package com.flor.backproyect.dao;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flor.backproyect.entity.Fav;

public interface FavRepository extends JpaRepository<Fav, Integer> {

	void deleteByIdProductFavAndCategory(int idProductFav, String category);
	
	Optional<Fav> findByIdProductFavAndCategory(int idProductFav, String category);
	
	
}
