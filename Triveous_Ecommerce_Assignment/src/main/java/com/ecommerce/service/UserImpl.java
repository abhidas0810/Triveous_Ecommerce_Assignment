package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.UserException;
import com.ecommerce.model.Cart;
import com.ecommerce.model.User;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.UserRepository;

@Service
public class UserImpl implements IUser {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CartRepository cartRepository;

	@Override
	public User resgisterUser(User user) throws UserException {

		Cart cart = new Cart();
		user.setCart(cartRepository.save(cart));

		User registerUser = userRepository.save(user);

		if (registerUser == null) {
			throw new UserException("UserController not registered.");
		}
		return registerUser;
	}

}
