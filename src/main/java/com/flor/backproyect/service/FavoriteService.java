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
	private IFavoriteRepository favRepository;

	public List<Favorite> getAll() {
		return favRepository.findAll();	
		}

	public Favorite saveFavorite(Favorite theFav) {
		return favRepository.save(theFav);
	}

	public Optional<Favorite> findFavorite(int userId, int idFav, String category) {
		return favRepository.findFavorite(userId, idFav, category);
	}

	public void deleteFavorite(int userId, int productId, String category) {
		favRepository.deleteFavorite(userId, productId, category);
	}
}
