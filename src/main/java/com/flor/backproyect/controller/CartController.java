package com.flor.backproyect.controller;

import java.util.List;
import java.util.Optional;

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
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/cart/{userId}")
	public List<Cart> getAll(@PathVariable int userId){
		Optional<User> theUser = userService.getUser(userId);
		return theUser.get().getCartItems();
	}
	
	@PostMapping("/cart/{userId}")
	public Cart saveCart(@PathVariable int userId, @RequestBody Cart theCart) {
		Optional<Cart> cartItem = cartService.findCartItem(theCart.getUserId(), theCart.getProductId(), theCart.getCategory());
		if(cartItem.isPresent()) {
			throw new RuntimeException("El producto ya existe");

		}else {
			Optional<User> theUser = userService.getUser(userId);
			
			theUser.get().addCartItems(theCart);
	
			cartService.saveCart(theCart);
		}
		return theCart;
	}
	
	@PutMapping("/cart/{userId}")
	public void updateCartItem(@PathVariable int userId, @RequestParam int quantity, @RequestParam int productId, @RequestParam String category) {
		cartService.updateQuantity(quantity, userId, productId, category);
	}
	
	@DeleteMapping("/cart/{userId}")
	public String deleteCartItem(@PathVariable int userId, @RequestParam int productId, @RequestParam String category) {
		Optional<Cart> theCart = cartService.findCartItem(userId, productId, category);
		if(theCart.isEmpty()) {
			throw new RuntimeException("El producto no existe");
		}else {
			cartService.deleteCartItem(userId, productId, category);
			return "CartItem eliminado";
		}
	}
	
	@DeleteMapping("/cart/deletecart/{userId}")
	public String deleteCart(@PathVariable int userId){
			cartService.deleteByUserId(userId);
			return "Cart vacío";
	}
}