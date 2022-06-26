package com.flor.backproyect.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flor.backproyect.entity.Fav;

public interface FavRepository extends JpaRepository<Fav, Integer> {

	void deleteByIdFavAndCategory(int idFav, String category);
		
	Optional<Fav> findByUserIdAndIdFavAndCategory(int userId, int idFav, String category);
	
	void deleteByUserIdAndIdFavAndCategory(int userId, int idFav, String category);

}
