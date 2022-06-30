package com.flor.backproyect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flor.backproyect.dao.IFavoriteRepository;
import com.flor.backproyect.entity.Favorite;

@Service
public class FavoriteService {
	
	@Autowired
	private IFavoriteRepository favoriteRepository;

	public List<Favorite> getAll() {
		return favoriteRepository.findAll();	
		}

	public Favorite saveFavorite(Favorite theFav) {
		return favoriteRepository.save(theFav);
	}

	public Optional<Favorite> findFavorite(int userId, int idFav, String category) {
		return favoriteRepository.findFavorite(userId, idFav, category);
	}

	public void deleteFavorite(int userId, int productId, String category) {
		favoriteRepository.deleteFavorite(userId, productId, category);
	}
	
	public void deleteAllFavorites(int userId) {
		favoriteRepository.deleteByUserId(userId);
	}
}
