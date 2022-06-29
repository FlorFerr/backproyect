package com.flor.backproyect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flor.backproyect.dao.ICartRepository;
import com.flor.backproyect.entity.Cart;

@Service
public class CartService {
	
	@Autowired
	private ICartRepository cartRepository;

	public List<Cart> getAll() {
		return cartRepository.findAll();	
	}

	public Cart saveCart(Cart cartItems) {
		return cartRepository.save(cartItems);
	}

	public Optional<Cart> findCartItem(int userId, int productId, String category) {
		return cartRepository.findCartItem(userId, productId, category);
	}

	public void deleteCartItem(int userId, int productId, String category) {
		cartRepository.deleteCartItem(userId, productId, category);
	}

	public void deleteByUserId(int userId) {
		cartRepository.deleteByUserId(userId);
	}

	public int updateQuantity(int quantity, int userId, int productId, String category) {
		return cartRepository.updateQuantity(quantity, userId, productId, category);
	}

}
