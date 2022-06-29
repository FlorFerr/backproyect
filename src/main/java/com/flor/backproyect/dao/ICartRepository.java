package com.flor.backproyect.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.flor.backproyect.entity.Cart;

public interface ICartRepository extends JpaRepository<Cart, Integer> {
	
	@Transactional
	@Modifying
    @Query(nativeQuery = true,value = "update cart set quantity = ?  where user_id = ? and product_id = ? and category = ?  ")
	public int updateQuantity(int quantity,int userId, int productId, String category);
	
	@Query("select c from Cart c where c.userId = ?1 and c.productId = ?2 and c.category = ?3")
	public Optional<Cart> findCartItem(int userId, int productId, String category);
	
	@Transactional
	@Modifying
	@Query("delete from Cart c where c.userId = ?1 and c.productId = ?2 and c.category = ?3")
	public void deleteCartItem(int userId, int productId, String category);
	
	@Transactional
	public void deleteByUserId(int userId);
}
