package com.service.impl;

import com.dao.UsersDao;
import com.domain.Users;
import com.service.UsersService;

public class UsersServiceImpl implements UsersService{

	@Override
	public Users findUsersByNameAndPass(String username, String password) {
		System.out.println("UsersServiceImpl.findUsersByNameAndPass");
		Users users= null;
		UsersDao usersDao= new UsersDao();
		
		if (username!=null && password!=null ) {
			users= usersDao.findUsersByNameAndPass(username, password);
		}
		
		return users;
	}

	@Override
	public void insertUsers(Users users) {
		System.out.println("UsersServiceImpl.insertUsers");
		UsersDao usersDao= new UsersDao();
		if (null!=users) {
			usersDao.insertUsers(users);
		}
	}
	
}
