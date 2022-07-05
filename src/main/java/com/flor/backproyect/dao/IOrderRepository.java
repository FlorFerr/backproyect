package com.flor.backproyect.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flor.backproyect.entity.Order;

public interface IOrderRepository extends JpaRepository<Order, Integer> {
	
	@Transactional
	public void deleteByUserId(int userId);
	
	public Optional<Order> getByNumOrder(long numOrder);
	
	@Transactional
	public void deleteByUserIdAndNumOrder(int userId, long numOrder);
	
		
}
