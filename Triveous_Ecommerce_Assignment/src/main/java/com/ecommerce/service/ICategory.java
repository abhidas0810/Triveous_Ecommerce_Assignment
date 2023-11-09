package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.CategoryException;
import com.ecommerce.model.Category;

public interface ICategory {
	
	public List<Category> retrieveCategories() throws CategoryException;
	
	public Category addCategorie(Category category) throws CategoryException;

}
