package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Product;

public interface IProduct {

	public List<Product> retrieveProductByCategoryId(Integer id) throws ProductException;

	public Product retrieveProductById(Integer id) throws ProductException;
	
	public Product registerProduct(Product product) throws ProductException;

}
