package com.flor.backproyect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flor.backproyect.dao.CartRepository;
import com.flor.backproyect.dao.FavRepository;
import com.flor.backproyect.entity.Cart;
import com.flor.backproyect.entity.Fav;



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



}
