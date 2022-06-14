package com.flor.backproyect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flor.backproyect.entity.Fav;
import com.flor.backproyect.entity.User;
import com.flor.backproyect.service.FavService;
import com.flor.backproyect.service.UserService;

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
	
	@GetMapping("/users/{userId}/favs")
	public List<Fav> findAll(@PathVariable int userId){
		
		User tempUser = userService.getUser(userId);
		return tempUser.getFavs();
		
	}
	
	@PostMapping("/users/{userId}/favs")
	public Fav saveFav(@RequestBody Fav theFav, @PathVariable int userId) {
		
		User theUser = userService.getUser(userId);
		
		theUser.addFavs(theFav);
		
		favService.saveFav(theFav);
		
		return theFav;
		
	}
	
	


}

	
