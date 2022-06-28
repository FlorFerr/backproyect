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

import com.flor.backproyect.dao.OrderRepository;
import com.flor.backproyect.dao.UserRepository;
import com.flor.backproyect.entity.Cart;
import com.flor.backproyect.entity.Orden;
import com.flor.backproyect.entity.User;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/order/{userId}")
	public List<Orden> getAll(@PathVariable int userId){
		Optional<User> tempUser = userRepository.findById(userId);
		return tempUser.get().getOrderItems();
	}
	
	@PostMapping("/order")
	public String saveOrderPrueba(@RequestParam int userId) {
		
		Optional<User> tempUser = userRepository.findById(userId);
				
		List<Cart> cartItems = tempUser.get().getCartItems();
				
		Calendar calendario = new GregorianCalendar();
						
		if(cartItems.isEmpty()) {
			throw new RuntimeException("Cart vacío");
		}else {
			for (Cart cartItem : cartItems) {
				Orden theOrder = new Orden();
				theOrder.setUserId(userId);
				theOrder.setNumOrder(calendario.getTimeInMillis());
			    theOrder.setQuantity(cartItem.getQuantity());
			    theOrder.setCategory(cartItem.getCategory());
			    theOrder.setIdOrder(cartItem.getIdCart());
			    orderRepository.save(theOrder);
			}			
		}
		return "Orden generada";
	}
	
	@DeleteMapping("/order/{userId}")
	public String deleteOrder(@PathVariable int userId) {
		Optional<User> theUser = userRepository.findById(userId);
		if(theUser.get().getCartItems().isEmpty()) {
			throw new RuntimeException("Cart empty");
		}else {
			orderRepository.deleteByUserId(userId);
			return "Delete order user: " + userId;}
	}
	
	
	@GetMapping("/order/num_order")
	public List<Orden> getOrderByNum(@RequestParam long numOrder) {
		return orderRepository.getByNumOrder(numOrder);
		
	}
}
