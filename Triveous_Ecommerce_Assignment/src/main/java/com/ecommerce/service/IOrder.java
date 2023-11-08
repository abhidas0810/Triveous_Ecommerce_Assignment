package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.OrderException;
import com.ecommerce.model.Order;
import com.ecommerce.model.OrderItem;

public interface IOrder {
	
	//public Order placeOrder() 
	
	public List<Order> orderHistory()throws OrderException;
	
	public Order retrieveOrderById(Integer id)throws OrderException;
	

}
