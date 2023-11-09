package com.ecommerce.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.OrderException;
import com.ecommerce.model.Cart;
import com.ecommerce.model.Order;
import com.ecommerce.model.User;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.UserRepository;

@Service
public class OrderImpl implements IOrder {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CartRepository cartRepository;
	

	@Override
	public Order placeOrder(String username) throws OrderException {
		
		User user = userRepository.findById(username).orElseThrow(() -> new OrderException("Invalid username " + username));
		Cart cart = user.getCart();
		
		Order order = new Order();
		order.setOrderDate(LocalDateTime.now());
		order.setUser(user);
		if (!cart.getOrderItems().isEmpty()) {
			order.setOrderItems(cart.getOrderItems());
		}else {
			throw new OrderException("Cart is empty.");
		}
		
		Order orderConfirmedOrder = orderRepository.save(order);
		cart.getOrderItems().clear();;
		cartRepository.save(cart);
		
		return orderConfirmedOrder;
	}

	@Override
	public List<Order> orderHistory(String username) throws OrderException {
		List<Order> orders = orderRepository.findByUserUsername(username);

		if (orders.isEmpty()) {
			throw new OrderException("No order found by username " + username);
		}

		return orders;
	}

	@Override
	public Order retrieveOrderById(Integer id) throws OrderException {

		return orderRepository.findById(id).orElseThrow(() -> new OrderException("No order found by id " + id));

	}

}
