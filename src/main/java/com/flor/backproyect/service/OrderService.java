package com.flor.backproyect.service;

import java.util.List;

import com.flor.backproyect.entity.Orden;

public interface OrderService {

	public Orden saveOrder(Orden theOrder);
	
	public List<Orden> getAll(int userId);
	
	public void deleteByUserId(int userId);
	
	public List<Orden> getByNumOrder(long numOrder);

}
