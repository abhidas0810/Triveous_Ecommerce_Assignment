package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.CartException;
import com.ecommerce.exception.ProductException;
import com.ecommerce.model.OrderItem;

public interface ICart {
	
	public OrderItem addItemToCart(Integer quantity, Integer productId, Integer cartId)throws CartException, ProductException;
	
	public List<OrderItem> retrieveCartProducts()throws CartException;
	
	public OrderItem updateProductQuantities(Integer orderItemId, Integer quantity)throws CartException;
	
	public OrderItem removeOrderItemById(Integer id, Integer cartId)throws CartException;
	
}
