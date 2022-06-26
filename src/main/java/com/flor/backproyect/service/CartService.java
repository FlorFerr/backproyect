package com.flor.backproyect.service;

import java.util.List;
import java.util.Optional;

import com.flor.backproyect.entity.Cart;

public interface CartService {
	
	public List<Cart> getAll();
	
	public Cart saveCart(Cart cartItems);

	public int updateCartAmountByName(int amount, String name);
	
	public void deleteCart();
		
	public Optional<Cart> findByUserIdAndIdCartAndCategory(int userId, int idCart, String category);
	
	public void deleteByUserIdAndIdCartAndCategory(int userId, int idCart, String category);

	public void deleteByUserId(int userId);

	

}
