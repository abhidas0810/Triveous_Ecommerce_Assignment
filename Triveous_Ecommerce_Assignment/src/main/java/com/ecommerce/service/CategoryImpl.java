package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.CategoryException;
import com.ecommerce.model.Category;
import com.ecommerce.repository.CategoryRepository;

@Service
public class CategoryImpl implements ICategory{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> retrieveCategories() throws CategoryException {
		
		List<Category> categories = categoryRepository.findAll();
		
		if (categories.size() == 0) {
			throw new CategoryException("Category not found.");
		}
		
		return categories;
	}

	@Override
	public Category addCategorie(Category category) throws CategoryException {
		Category savedCategory = categoryRepository.save(category);
		if (savedCategory == null) {
			throw new CategoryException("Category not saved.");
		}
		return savedCategory;
	}
	

}
