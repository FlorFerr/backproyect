package com.flor.backproyect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flor.backproyect.dao.IOrderRepository;
import com.flor.backproyect.entity.Order;

@Service
public class OrderService{
	
	@Autowired
	private IOrderRepository orderRepository;

	public List<Order> getAll(int userId) {
		return orderRepository.findAll();
	}

	public Order saveOrder(Order theOrder) {
		return orderRepository.save(theOrder);
	}

	public void deleteByUserId(int userId) {
		orderRepository.deleteByUserId(userId);
	}

	public List<Order> getByNumOrder(long numOrder) {
		return orderRepository.getByNumOrder(numOrder);
	}
	
	public void deleteOrder(int userId, long numOrder) {
		orderRepository.deleteByUserIdAndNumOrder(userId, numOrder);
	}
}
