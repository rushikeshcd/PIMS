package com.springboot.services;

import com.springboot.model.UserDtls;

public interface UserService {


	public UserDtls createUser(UserDtls user);

	public boolean checkEmail(String email);

}
