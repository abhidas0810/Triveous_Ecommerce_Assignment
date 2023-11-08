package com.ecommerce.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.CartException;
import com.ecommerce.model.OrderItem;
import com.ecommerce.repository.OrderItemRepository;
import com.ecommerce.repository.ProductRepository;

@Service
public class CartImpl implements ICart {

	@Autowired
	public ProductRepository productRepository;

	@Autowired
	public OrderItemRepository orderItemRepository;

	@Override
	public OrderItem addProduct(OrderItem orderItem) throws CartException {

		OrderItem addorderItem = orderItemRepository.save(orderItem);

		if (addorderItem == null) {
			throw new CartException("Order Item not added to cart.");
		}

		return addorderItem;
	}

	@Override
	public List<OrderItem> retrieveProducts() throws CartException {

		List<OrderItem> orderItems = orderItemRepository.findAll();

		if (orderItems.size() == 0) {
			throw new CartException("Order items not found in cart.");

		}
		return orderItems;
	}

	@Override
	public OrderItem updateProductQuantities(Integer orderItemId, Integer quantity) throws CartException {

		OrderItem orderItem = orderItemRepository.findById(orderItemId)
				.orElseThrow(() -> new CartException("Product quantities not updated"));
		orderItem.setQuantity(quantity);
		return orderItemRepository.save(orderItem);
	}

	@Override
	public OrderItem removeProductById(Integer id) throws CartException {

		OrderItem orderItem = orderItemRepository.findById(id)
				.orElseThrow(() -> new CartException("Product not removed."));

		orderItemRepository.delete(orderItem);

		return orderItem;
	}

}
