package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.OrderException;
import com.ecommerce.model.Order;
import com.ecommerce.service.IOrder;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private IOrder iOrder;

	@PostMapping("/placeorder/{username}")
	public ResponseEntity<Order> placeOrder(@PathVariable String username) throws OrderException {
		return new ResponseEntity<>(iOrder.placeOrder(username), HttpStatus.CREATED);
	}

	@GetMapping("/orderhistory/{username}")
	public ResponseEntity<List<Order>> orderHistory(@PathVariable String username) throws OrderException {
		return new ResponseEntity<>(iOrder.orderHistory(username), HttpStatus.OK);
	}

	@GetMapping("/retrieve/{id}")
	public ResponseEntity<Order> retrieveOrderById(@PathVariable Integer id) throws OrderException {
		return new ResponseEntity<>(iOrder.retrieveOrderById(id), HttpStatus.OK);
	}

}
