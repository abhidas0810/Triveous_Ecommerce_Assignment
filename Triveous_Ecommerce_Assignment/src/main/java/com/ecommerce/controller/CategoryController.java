package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.CategoryException;
import com.ecommerce.model.Category;
import com.ecommerce.service.ICategory;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private ICategory iCategory;

	@GetMapping("/retrieve")
	public ResponseEntity<List<Category>> retrieveCategories() throws CategoryException {
		return new ResponseEntity<>(iCategory.retrieveCategories(), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Category> addCategorie(@RequestBody Category category) throws CategoryException {
		return new ResponseEntity<>(iCategory.addCategorie(category), HttpStatus.CREATED);
	}

}
