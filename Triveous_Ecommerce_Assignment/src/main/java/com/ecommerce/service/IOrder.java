package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.OrderException;
import com.ecommerce.model.Order;

public interface IOrder {

	public Order placeOrder(String username) throws OrderException;
	
	public List<Order> orderHistory(String username)throws OrderException;
	
	public Order retrieveOrderById(Integer id)throws OrderException;
	
}
