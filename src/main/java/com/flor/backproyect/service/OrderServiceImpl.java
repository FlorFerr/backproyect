package com.flor.backproyect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flor.backproyect.dao.OrderRepository;
import com.flor.backproyect.entity.Orden;

@Service
public class OrderServiceImpl implements OrderService {
	
	private OrderRepository orderRepository;
	
	@Autowired
	public OrderServiceImpl(OrderRepository theOrderRepository) {
		orderRepository = theOrderRepository;
	}

	@Override
	@Transactional
	public List<Orden> getAll(int userId) {
		return orderRepository.findAll();
	}
	
	@Override
	@Transactional
	public Orden saveOrder(Orden theOrder) {
		return orderRepository.save(theOrder);
	}

	@Override
	@Transactional
	public void deleteByUserId(int userId) {
		orderRepository.deleteByUserId(userId);
	}

}
