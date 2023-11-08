package com.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class OrderItem {
	
    @Id
    @GeneratedValue
    private Integer id;
    private Integer quantity;
    
    @ManyToOne
    private Product product;
    
    @ManyToOne
    private Order order;
    
}

