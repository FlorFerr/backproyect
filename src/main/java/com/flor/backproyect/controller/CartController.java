package com.flor.backproyect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flor.backproyect.entity.Cart;
import com.flor.backproyect.entity.User;
import com.flor.backproyect.service.CartService;
import com.flor.backproyect.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CartController {
	
	private CartService cartService;
	private UserService userService;
	
	@Autowired
	public CartController(CartService theCartService, UserService theUserService) {
		cartService = theCartService;
		userService = theUserService;
	}
	
	@GetMapping("/users/{userId}/cart")
	public List<Cart> getAll(@PathVariable int userId){
		
		User tempUser = userService.getUser(userId);
		return tempUser.getCartItems();
		
	}
	
	@PostMapping("/users/{userId}/cart")
	public Cart saveCart(@RequestBody Cart theCart, @PathVariable int userId) {
		
		User tempUser = userService.getUser(userId);
		
		tempUser.addCartItems(theCart);
		
		cartService.saveCart(theCart);
		return theCart;
	}
	
	@PutMapping("users/{userId}/cart")
	public void updateUser(@RequestParam int amount, @RequestParam String name, @PathVariable int userId) {
		
		cartService.updateCartAmountByName(amount, name);
		
		
	}
	
	@DeleteMapping("users/{userId}/cart")
	public void deleteCartItem(@RequestParam String name, @PathVariable int userId) {
		
		cartService.deleteByName(name);
		
	}
	
	@DeleteMapping("users/{userId}/cart/deleteAll")
	public void deleteCart(@PathVariable int userId) {
		
		cartService.deleteCart();
		
	}
}
