package com.flor.backproyect.service;

import java.util.List;

import com.flor.backproyect.entity.Cart;

public interface CartService {
	
	public List<Cart> getAll();
	
	public Cart saveCart(Cart cartItems);

	int updateCartAmountByName(int amount, String name);

}
