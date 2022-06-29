package com.flor.backproyect.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.flor.backproyect.entity.Favorite;

public interface IFavoriteRepository extends JpaRepository<Favorite, Integer> {
		
	@Query("SELECT f FROM Favorite f where f.userId = ?1 AND f.productId = ?2 AND f.category = ?3")
	public Optional<Favorite> findFavorite(int userId, int productId, String category);
	
	@Transactional
	@Modifying
	@Query("delete from Favorite f where f.userId = ?1 and f.productId = ?2 and f.category = ?3")
	public void deleteFavorite(int userId, int productId, String category);
	
	@Transactional
	public void deleteByUserId(int userId);
}

