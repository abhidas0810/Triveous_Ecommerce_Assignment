package com.ecommerce.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cart {
	
    @Id
    @GeneratedValue
    private Integer id;
        
    @OneToMany
    private List<OrderItem> orderItems;
    
}

