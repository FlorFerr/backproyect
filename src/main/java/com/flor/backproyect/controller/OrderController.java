package com.flor.backproyect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flor.backproyect.entity.Cart;
import com.flor.backproyect.entity.Orden;
import com.flor.backproyect.entity.User;
import com.flor.backproyect.service.OrderService;
import com.flor.backproyect.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class OrderController {
	
	private OrderService orderService;
	private UserService userService;	
	
	@Autowired
	public OrderController(OrderService theOrderService, UserService theUserService) {
		orderService = theOrderService;
		userService = theUserService;
	}
	
	@GetMapping("/order")
	public List<Orden> getAll(@RequestParam int userId){
		User tempUser = userService.getUser(userId);
		
		return tempUser.getOrderItems();
	}
	
	@PostMapping("/order")
	public Orden saveOrderPrueba(@RequestParam int userId) {
		
		User tempUser = userService.getUser(userId);
				
		List<Cart> cartItems = tempUser.getCartItems();
		
		if(cartItems.isEmpty()) {
			throw new RuntimeException("No hay productos en el carrito");
		}else {
			for (int i = 0; i < cartItems.size(); ++i) {
				Orden theOrder = new Orden();
				theOrder.setUserId(userId);
			    theOrder.setAmount(cartItems.get(i).getAmount());
			    theOrder.setCategory(cartItems.get(i).getCategory());
			    theOrder.setName((Math.random() * ((100 - 1) + 1)) + 100);
			    theOrder.setIdOrder(cartItems.get(i).getIdCart());
			    orderService.saveOrder(theOrder);
			    System.out.println(theOrder);
			}
		}
		return null;
	}
	
	@DeleteMapping("/order")
	public void deleteOrder(@RequestParam int userId) {
		orderService.deleteByUserId(userId);
	}
}
