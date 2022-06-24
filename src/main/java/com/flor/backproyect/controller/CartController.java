package com.flor.backproyect.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/cart")
	public List<Cart> getAll(@RequestParam int userId){
		User tempUser = userService.getUser(userId);
		return tempUser.getCartItems();
	}
	
	@PostMapping("/cart")
	public Cart saveCart(@RequestParam int userId, @RequestBody Cart theCart) {
		User tempUser = userService.getUser(userId);
		tempUser.addCartItems(theCart);
		cartService.saveCart(theCart);
		return theCart;
	}
	/*
	@PutMapping("/cart")
	public void updateCartItem(@RequestParam int userId, @RequestParam int amount, @RequestParam String name) {
		cartService.updateCartAmountByName(amount, name);
	}
	@DeleteMapping("users/cart/deleteAll")
	public void deleteCart(@RequestParam int userId) {
		cartService.deleteCart();
	}
	
	@GetMapping("users/cartitem")
	public Cart findCartItem(@RequestParam int userId, @RequestParam int idCart, @RequestParam String category) {
		
		Cart cartItem = cartService.findByIdCartAndCategory(idCart, category);
		return cartItem;		
	}
	
		@GetMapping("/cart/pruebita")
	public Optional<Cart> findCartItemPrueba(@RequestParam int userId, @RequestParam int idCart, @RequestParam String category){
		
		Optional<Cart> tempCart = cartService.findByUserIdAndIdCartAndCategory(userId, idCart, category);
		
		return tempCart;
		
	}
	
	*/
	
	@DeleteMapping("/cart")
	public void deleteCartItem(@RequestParam int userId, @RequestParam int idCart, @RequestParam String category) {
		Optional<Cart> tempCart = cartService.findByUserIdAndIdCartAndCategory(userId, idCart, category);
		
		if(tempCart.isEmpty()) {
			throw new RuntimeException("El producto no existe");
		}else {
			cartService.deleteByUserIdAndIdCartAndCategory(userId, idCart, category);
		}
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

