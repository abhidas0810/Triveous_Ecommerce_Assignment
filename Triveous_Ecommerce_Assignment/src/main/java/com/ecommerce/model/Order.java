package com.ecommerce.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "order_table")
public class Order {
	
    @Id
    @GeneratedValue
    private Integer id;
    private LocalDateTime orderDate;
    
    @ManyToOne
    private User user;
    
    @OneToMany
    private List<OrderItem> orderItems;
    
}

