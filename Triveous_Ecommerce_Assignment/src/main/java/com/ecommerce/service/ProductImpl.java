package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;

@Service
public class ProductImpl implements IProduct {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product registerProduct(Product product) throws ProductException {
		
		Product registeredProduct = productRepository.save(product);
		
		if (registeredProduct == null) {
			throw new ProductException("Product not registered.");
		}
		
		return registeredProduct;
	}

	@Override
	public List<Product> retrieveProductByCategoryId(Integer id) throws ProductException {
		List<Product> products = productRepository.findByCategoryId(id);
		
		if (products.isEmpty()) {
			throw new ProductException("No product found with category id " + id);
		}
		
		return products;
	}

	@Override
	public Product retrieveProductById(Integer id) throws ProductException {
		
		return productRepository.findById(id)
				.orElseThrow(() -> new ProductException("No product found with id " + id));

	}

	

}
