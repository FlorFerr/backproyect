package com.flor.backproyect.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.flor.backproyect.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	@Modifying
    @Query(nativeQuery = true,value = "update cart set quantity = ?  where user_id = ? and id_cart = ? and category = ?  ")
	int updateCartItemQuantity(int quantity,int userId, int idCart, String category);
		
	Optional<Cart> findByUserIdAndIdCartAndCategory(int userId, int idCart, String category);
	
	void deleteByUserIdAndIdCartAndCategory(int userId, int idCart, String category);
	
	void deleteByUserId(int userId);
}
