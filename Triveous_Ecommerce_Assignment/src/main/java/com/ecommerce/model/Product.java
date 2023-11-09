package com.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Product {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	private String description;
	private Double price;
	private boolean available;

	@ManyToOne
	private Category category;
	
	@OneToOne
    private OrderItem orderItem;
	
}
