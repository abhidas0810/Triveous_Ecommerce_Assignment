package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.UserException;
import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;

@Service
public class UserImpl implements IUser{
	
	@Autowired
	public UserRepository userRepository;

	@Override
	public User resgisterUser(User user) throws UserException {
		
		User registerUser = userRepository.save(user);
		
		if (registerUser != null) {
			throw new UserException("User not registered.");
		}
		return registerUser;
	}

}
