package com.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class OrderItem {
	
    @Id
    @GeneratedValue
    private Integer id;
    private Integer quantity;
    
    @ManyToOne
    private Cart cart;
    
    @ManyToOne
    private Order order;
    
    @OneToOne
    private Product product;
        
}

