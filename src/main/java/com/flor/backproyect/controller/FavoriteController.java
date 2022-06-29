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

import com.flor.backproyect.dao.IFavoriteRepository;
import com.flor.backproyect.dao.IUserRepository;
import com.flor.backproyect.entity.Favorite;
import com.flor.backproyect.entity.User;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class FavoriteController {
	
	@Autowired
	private IFavoriteRepository favService;
	
	@Autowired
	private IUserRepository userService;
	
	@GetMapping("/favorites/{userId}")
	public List<Favorite> getAllFavorites(@PathVariable int userId){
		Optional<User> theUser = userService.findById(userId);
		return theUser.get().getFavs();
	}
	
	@PostMapping("/favorites/{userId}")
	public Favorite saveFavorite(@PathVariable int userId, @RequestParam int productId, @RequestParam String category, @RequestBody Favorite favorite) {
		Optional<Favorite> theFavorite = favService.findFavorite(userId, productId, category);
		if(theFavorite.isEmpty()) {
			Optional<User> theUser = userService.findById(userId);
			theUser.get().addFav(favorite);
			favService.save(favorite);
		}else {
			throw new RuntimeException("El producto ya está en favoritos");
		}
		return favorite;
	}
	
	@DeleteMapping("/favorites/{userId}")
	public String deleteFavorite(@PathVariable int userId, @RequestParam int productId, @RequestParam String category) {
		Optional<Favorite> favorite = favService.findFavorite(userId, productId, category);
		if(favorite.isEmpty()) {
			throw new RuntimeException("El producto no existe");
		}else {
			favService.deleteFavorite(userId, productId, category);
			return "Favorito eliminado";
		}		
	}
}

	
