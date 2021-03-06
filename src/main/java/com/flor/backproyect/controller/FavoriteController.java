package com.flor.backproyect.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flor.backproyect.entity.Favorite;
import com.flor.backproyect.entity.User;
import com.flor.backproyect.service.FavoriteService;
import com.flor.backproyect.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class FavoriteController {
	
	@Autowired
	private FavoriteService favoriteService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/favorites/{userId}")
	public List<Favorite> getAllFavorites(@PathVariable int userId){
		Optional<User> theUser = userService.getUser(userId);
		return theUser.get().getFavs();
	}
	
	@PostMapping("/favorites/{userId}")
	public Favorite saveFavorite(@PathVariable int userId, @RequestBody Favorite favorite) {
		Optional<Favorite> theFavorite = favoriteService.findFavorite(favorite.getUserId(), favorite.getProductId(), favorite.getCategory());
		if(theFavorite.isEmpty()) {
			Optional<User> theUser = userService.getUser(userId);
			theUser.get().addFav(favorite);
			favoriteService.saveFavorite(favorite);
		}else {
			throw new RuntimeException("El producto ya está en favoritos");
		}
		return favorite;
	}
	
	@DeleteMapping("/favorites/{userId}")
	public String deleteFavorite(@PathVariable int userId, @RequestParam int productId, @RequestParam String category) {
		Optional<Favorite> favorite = favoriteService.findFavorite(userId, productId, category);
		if(favorite.isEmpty()) {
			throw new RuntimeException("El producto no existe");
		}else {
			favoriteService.deleteFavorite(userId, productId, category);
			return "Favorito eliminado";
		}		
	}
	
	@DeleteMapping("/favorites/deleteall/{userId}")
	public String deleteAllFavorites(@PathVariable int userId) {
		favoriteService.deleteAllFavorites(userId);
		return "Favoritos eliminados";
		
	}
}

	
