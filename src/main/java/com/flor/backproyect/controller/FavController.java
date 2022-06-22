package com.flor.backproyect.controller;

import java.util.List;

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
	
	@PostMapping("/users/favorites")
	public Fav saveCart(@RequestParam int userId, @RequestBody Fav theFav) {
		
		User tempUser = userService.getUser(userId);
		
		tempUser.addFav(theFav);
		
		favService.saveFav(theFav);
		return theFav;
	}
	

	@DeleteMapping("users/favorites")
	public void deleteFav(@RequestParam int userId, @RequestParam String name) {
		favService.deleteByName(name);
	}
	
	@GetMapping("users/prueba")
	public Fav getFavById(@RequestParam int idProductFav) {
		
		Fav theFav = favService.getByIdProduct(idProductFav);
		
		if(theFav == null) {
			throw new RuntimeException("User id not found");
		}
		
		return theFav;
		
	}
	
	@PostMapping("users/favorites/prueba")
	public Fav saveFav(@RequestParam int userId, @RequestParam int idProductFav, @RequestBody Fav theFav) {
		Fav tempFav = favService.getByIdProduct(idProductFav);
		
		if(tempFav == null) {
			User tempUser = userService.getUser(userId);
			
			tempUser.addFav(theFav);
			
			favService.saveFav(theFav);
			return theFav;
		}
		else {
			throw new RuntimeException("El producto ya está en favoritos");
			
		}
		
	}

}

	
