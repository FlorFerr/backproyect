package com.flor.backproyect.service;

import java.util.List;

import com.flor.backproyect.entity.Cart;

public interface CartService {
	
	public List<Cart> getAll();
	
	public Cart saveCart(Cart cartItems);

	public int updateCartAmountByName(int amount, String name);
	
	public void deleteByIdCartAndCategory(int idCart, String category);

	public void deleteCart();

	
	

}
