package com.flor.backproyect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flor.backproyect.dao.CartRepository;
import com.flor.backproyect.entity.Cart;

@Service
public class CartServiceImpl implements CartService {
	
	private CartRepository cartRepository;
	
	@Autowired
	public CartServiceImpl(CartRepository theCartRepository) {
		cartRepository = theCartRepository;
	}

	@Override
	@Transactional
	public List<Cart> getAll() {
		return cartRepository.findAll();	
	}

	@Override
	@Transactional
	public Cart saveCart(Cart cartItems) {
		return cartRepository.save(cartItems);
	}

	@Override
	@Transactional
	public Optional<Cart> findByUserIdAndIdCartAndCategory(int userId, int idCart, String category) {
		return cartRepository.findByUserIdAndIdCartAndCategory(userId, idCart, category);
	}

	@Override
	@Transactional
	public void deleteByUserIdAndIdCartAndCategory(int userId, int idCart, String category) {
		cartRepository.deleteByUserIdAndIdCartAndCategory(userId, idCart, category);
	}

	@Override
	@Transactional
	public void deleteByUserId(int userId) {
		cartRepository.deleteByUserId(userId);
	}

	@Override
	@Transactional
	public int updateCartItemQuantity(int quantity, int userId, int idCart, String category) {
		return cartRepository.updateCartItemQuantity(quantity, userId, idCart, category);
	}

}
