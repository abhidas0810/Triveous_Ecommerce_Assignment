package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Product;
import com.ecommerce.service.IProduct;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProduct iProduct;
	
	@PostMapping("/registerProduct")
	public ResponseEntity<Product> registerProduct(@RequestBody Product product) throws ProductException {
		return new ResponseEntity<>(iProduct.registerProduct(product), HttpStatus.OK);
	}

	@GetMapping("/retrievebycategory/{id}")
	public ResponseEntity<List<Product>> retrieveProductByCategoryId(@PathVariable Integer id) throws ProductException {
		return new ResponseEntity<>(iProduct.retrieveProductByCategoryId(id), HttpStatus.OK);
	}

	@GetMapping("/retrieve/{id}")
	public ResponseEntity<Product> retrieveProductById(@PathVariable Integer id) throws ProductException{
		return new ResponseEntity<>(iProduct.retrieveProductById(id), HttpStatus.OK);
	}

}
