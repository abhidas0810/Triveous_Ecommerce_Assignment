package com.ecommerce.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Cart {
	
    @Id
    @GeneratedValue
    private Integer id;
        
    @OneToOne
    private User user;
    
    @OneToMany
    private List<OrderItem> orderItems;
    
}

