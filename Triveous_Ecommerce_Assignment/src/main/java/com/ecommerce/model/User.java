package com.ecommerce.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class User {

	@Id
	private String username;
	private String name;	
	private String password;
	
	@OneToOne
	private Cart cart;
	
	@OneToMany
	private List<Order> order;

}
