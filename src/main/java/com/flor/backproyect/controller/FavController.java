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

import com.flor.backproyect.entity.Fav;
import com.flor.backproyect.entity.User;
import com.flor.backproyect.service.FavService;
import com.flor.backproyect.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class FavController {
	
	@Autowired
	private FavService favService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/favorites/{userId}")
	public List<Fav> getAllFavorites(@PathVariable int userId){
		User tempUser = userService.getUser(userId);
		return tempUser.getFavs();
	}
	
	@PostMapping("/favorites")
	public Fav saveFavorite(@RequestParam int userId, @RequestParam int idFav, @RequestParam String category, @RequestBody Fav theFav) {
		
		Optional<Fav> tempFav = favService.findByUserIdAndIdFavAndCategory(userId, idFav, category);
		
		if(tempFav.isEmpty()) {
			User tempUser = userService.getUser(userId);
			
			tempUser.addFav(theFav);
			
			favService.saveFav(theFav);
		}else {
			throw new RuntimeException("El producto ya está en favoritos");
		}
		return theFav;
	}
	
	@DeleteMapping("/favorites")
	public void deleteFavorite(@RequestParam int userId, @RequestParam int idFav, @RequestParam String category) {
		Optional<Fav> tempFav = favService.findByUserIdAndIdFavAndCategory(userId, idFav, category);
		
		if(tempFav.isEmpty()) {
			throw new RuntimeException("El producto no existe");
		}else {
			favService.deleteByUserIdAndIdFavAndCategory(userId, idFav, category);
		}		
	}
}

	
