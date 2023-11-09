package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.UserException;
import com.ecommerce.model.User;
import com.ecommerce.service.IUser;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUser iUser;

	@PostMapping("/register")
	public ResponseEntity<User> resgisterUser(@RequestBody User user) throws UserException {
		System.out.println(user);
		return new ResponseEntity<>(iUser.resgisterUser(user), HttpStatus.CREATED);
	}

}
