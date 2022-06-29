package com.flor.backproyect.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flor.backproyect.dao.IOrderRepository;
import com.flor.backproyect.dao.IUserRepository;
import com.flor.backproyect.entity.Cart;
import com.flor.backproyect.entity.Order;
import com.flor.backproyect.entity.User;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	private IOrderRepository orderService;
	
	@Autowired
	private IUserRepository userService;
	
	@GetMapping("/order/{userId}")
	public List<Order> getAll(@PathVariable int userId){
		Optional<User> theUser = userService.findById(userId);
		return theUser.get().getOrderItems();
	}
	
	@PostMapping("/order/{userId}")
	public String saveOrder(@PathVariable int userId) {
		
		Optional<User> theUser = userService.findById(userId);
				
		List<Cart> cartItems = theUser.get().getCartItems();
				
		Calendar calendario = new GregorianCalendar();
						
		if(cartItems.isEmpty()) {
			throw new RuntimeException("Cart vacío");
		}else {
			for (Cart cartItem : cartItems) {
				Order theOrder = new Order();
				theOrder.setUserId(userId);
				theOrder.setNumOrder(calendario.getTimeInMillis());
			    theOrder.setQuantity(cartItem.getQuantity());
			    theOrder.setCategory(cartItem.getCategory());
			    theOrder.setProductId(cartItem.getProductId());
			    orderService.save(theOrder);
			}			
		}
		return "Orden generada";
	}
	
	@DeleteMapping("/order/{userId}")
	public String deleteOrder(@PathVariable int userId) {
		Optional<User> theUser = userService.findById(userId);
		if(theUser.get().getCartItems().isEmpty()) {
			throw new RuntimeException("Cart vacío");
		}else {
			orderService.deleteByUserId(userId);
			return "Orden usuario " + userId + " eliminada";}
	}
	
	
	@GetMapping("/order/num_order")
	public List<Order> getOrderByNum(@RequestParam long numOrder) {
		return orderService.getByNumOrder(numOrder);
	}
}
