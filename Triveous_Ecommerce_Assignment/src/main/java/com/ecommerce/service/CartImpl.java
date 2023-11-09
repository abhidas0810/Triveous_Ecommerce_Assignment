package com.ecommerce.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.CartException;
import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Cart;
import com.ecommerce.model.OrderItem;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.OrderItemRepository;

@Service
public class CartImpl implements ICart {

	@Autowired
	private IProduct iProduct;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public OrderItem addItemToCart(Integer quantity, Integer productId, Integer cartId) throws CartException, ProductException {

		OrderItem orderItem = new OrderItem();
		orderItem.setQuantity(quantity);
		orderItem.setProduct(iProduct.retrieveProductById(productId));
		OrderItem addorderItem = orderItemRepository.save(orderItem);

		if (addorderItem == null) {
			throw new CartException("Order Item not added to cart.");
		}
		
		Cart cart = cartRepository.findById(cartId).orElseThrow(()-> new CartException("Order Item not added to cart."));
		cart.getOrderItems().add(addorderItem);
		cartRepository.save(cart);
		
		return addorderItem;
	}

	@Override
	public List<OrderItem> retrieveCartProducts() throws CartException {

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
	public OrderItem removeOrderItemById(Integer id, Integer cartId) throws CartException {

		OrderItem orderItem = orderItemRepository.findById(id)
				.orElseThrow(() -> new CartException("Product not removed."));
		
		Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new CartException("Cart not existed."));
		
		cart.getOrderItems().remove(orderItem);
		cartRepository.save(cart);
		return orderItem;
	}

}
