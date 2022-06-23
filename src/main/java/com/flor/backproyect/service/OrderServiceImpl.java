package com.flor.backproyect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flor.backproyect.dao.OrderRepository;
import com.flor.backproyect.entity.Cart;
import com.flor.backproyect.entity.Orden;

@Service
public class OrderServiceImpl implements OrderService {
	
	private OrderRepository orderRepository;
	
	@Autowired
	public OrderServiceImpl(OrderRepository theOrderRepository) {
		orderRepository = theOrderRepository;
	}









}
