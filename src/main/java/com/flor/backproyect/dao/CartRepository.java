package com.flor.backproyect.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.flor.backproyect.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	@Modifying
    @Query(nativeQuery = true,value = "update cart set amount = ?1  where name = ?2 ")
	int updateCartAmountByName(int amount,String name);
	
	void deleteByIdCartAndCategory(int idCart, String category);
	
	Cart findByIdCartAndCategory(int idCart, String category);
}


//    @Query(nativeQuery = true,value = "update cart set amount = ?1  where name = ?2 ")
