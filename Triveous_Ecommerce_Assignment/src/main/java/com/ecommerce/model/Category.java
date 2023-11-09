package com.ecommerce.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Category {
	
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    
    @OneToMany
    private List<Product> products;
    
}

