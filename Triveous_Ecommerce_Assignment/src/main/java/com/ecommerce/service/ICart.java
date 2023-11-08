package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.CartException;
import com.ecommerce.model.OrderItem;

public interface ICart {
	
	public OrderItem addProduct(OrderItem orderItem)throws CartException;
	
	public List<OrderItem> retrieveProducts()throws CartException;
	
	public OrderItem updateProductQuantities(Integer orderItemId, Integer quantity)throws CartException;
	
	public OrderItem removeProductById(Integer id)throws CartException;
	
	

}
