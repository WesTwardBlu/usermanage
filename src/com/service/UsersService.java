package com.service;

import com.domain.Users;

public interface UsersService {
	
	Users findUsersByNameAndPass(String username,String password);
	
	void insertUsers(Users users);
	
}
