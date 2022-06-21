package com.flor.backproyect.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/favorites")
	public Fav getFav(@RequestParam int userId, @RequestParam String category, @RequestParam int favId) {
		
		Fav theFav = favService.getFav(userId, category, favId);
		
		return theFav;
	}
	
	@PostMapping("/favorites/{userId}")
	public Fav saveCart(@RequestBody Fav theFav, @RequestParam int userId) {
		
		User tempUser = userService.getUser(userId);
		
		tempUser.addFav(theFav);
		
		favService.saveFav(theFav);
		return theFav;
		
	}
	

	
	@DeleteMapping("/favorites")
	public void deleteFav(@RequestParam int userId, @RequestParam String category, @RequestParam int favId) {
		favService.deleteFav(userId, category, favId);
	}

	

}

	
