package com.flor.backproyect.service;

import java.util.List;

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
    public int updateCartAmountByName(int amount,String name){
		
		return cartRepository.updateCartAmountByName(amount, name);
    }

	@Override
	@Transactional
	public void deleteCart() {
		cartRepository.deleteAll();
	}

	@Override
	@Transactional
	public void deleteByIdCartAndCategory(int idCart, String category) {
		cartRepository.deleteByIdCartAndCategory(idCart, category);
	}

	@Override
	@Transactional
	public Cart findByIdCartAndCategory(int idCart, String category) {
		return cartRepository.findByIdCartAndCategory(idCart, category);
	}
}
