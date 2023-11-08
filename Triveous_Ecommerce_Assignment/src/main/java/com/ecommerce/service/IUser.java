package com.ecommerce.service;

import com.ecommerce.exception.UserException;
import com.ecommerce.model.User;

public interface IUser {
	
	public User resgisterUser(User user) throws UserException;
	
	

}
