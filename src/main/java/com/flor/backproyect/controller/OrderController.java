package com.flor.backproyect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flor.backproyect.entity.Cart;
import com.flor.backproyect.entity.Orden;
import com.flor.backproyect.entity.User;
import com.flor.backproyect.service.CartService;
import com.flor.backproyect.service.OrderService;
import com.flor.backproyect.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class OrderController {
	
	private OrderService orderService;
	private UserService userService;
	private CartService cartService;
	
	
	@Autowired
	public OrderController(OrderService theOrderService, UserService theUserService, CartService theCartService) {
		orderService = theOrderService;
		userService = theUserService;
		cartService = theCartService;
	}
	
	


}
