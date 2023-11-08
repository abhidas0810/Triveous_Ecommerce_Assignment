package com.ecommerce.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Order {
	
    @Id
    @GeneratedValue
    private Integer id;
    private LocalDateTime orderDate;
    
    @ManyToOne
    private User user;
    
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
    
}

