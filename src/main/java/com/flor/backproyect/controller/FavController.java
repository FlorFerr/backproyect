package com.flor.backproyect.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	private FavService favService;
	private UserService userService;
	
	@Autowired
	public FavController(FavService theFavService, UserService theUserService) {
		favService = theFavService;		
		userService = theUserService;
	}
	
	@GetMapping("/users/favorites")
	public List<Fav> getAll(@RequestParam int userId){
		User tempUser = userService.getUser(userId);
		return tempUser.getFavs();
	}
	

	

	@DeleteMapping("users/favorites")
	public void deleteFav(@RequestParam int userId, @RequestParam int idProductFav, @RequestParam String category) {
		favService.deleteByIdProductFavAndCategory(idProductFav, category);
	}
	
	@PostMapping("users/favorites")
	public Fav guardarFav(@RequestParam int userId, @RequestParam int idProductFav, @RequestParam String category, @RequestBody Fav theFav) {
		
		Optional<Fav> tempFav = favService.findByIdProductFavAndCategory(idProductFav, category);
		
		if(tempFav.isEmpty()) {
			User tempUser = userService.getUser(userId);
			
			tempUser.addFav(theFav);
			
			favService.saveFav(theFav);
		}else {
			throw new RuntimeException("El producto ya está en favoritos");
		}
		
		
		return theFav;
		
	}
	
	
	

}

	
