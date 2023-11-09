package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.CartException;
import com.ecommerce.exception.ProductException;
import com.ecommerce.model.OrderItem;
import com.ecommerce.service.ICart;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private ICart iCart;

	@PostMapping("/addtocart/{quantity}/{productId}/{cartId}")
	public ResponseEntity<OrderItem> addItemToCart(@PathVariable Integer quantity, @PathVariable Integer productId,
			@PathVariable Integer cartId) throws CartException, ProductException {
		return new ResponseEntity<>(iCart.addItemToCart(quantity, productId, cartId), HttpStatus.CREATED);
	}

	@GetMapping("/retrieveitems")
	public ResponseEntity<List<OrderItem>> retrieveCartProducts() throws CartException {
		return new ResponseEntity<>(iCart.retrieveCartProducts(), HttpStatus.OK);
	}

	@PutMapping("/updatequantities/{orderItemId}/{quantity}")
	public ResponseEntity<OrderItem> updateProductQuantities(@PathVariable Integer orderItemId,
			@PathVariable Integer quantity) throws CartException {
		return new ResponseEntity<>(iCart.updateProductQuantities(orderItemId, quantity), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/removeitem/{id}/{cartId}")
	public ResponseEntity<OrderItem> removeOrderItemById(@PathVariable Integer id, @PathVariable Integer cartId)
			throws CartException {
		return new ResponseEntity<>(iCart.removeOrderItemById(id, cartId), HttpStatus.ACCEPTED);
	}

}
