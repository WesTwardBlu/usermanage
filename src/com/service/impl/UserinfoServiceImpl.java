package com.service.impl;

import java.util.List;

import com.dao.UserinfoDao;
import com.domain.Userinfo;
import com.service.UserinfoService;

public class UserinfoServiceImpl implements UserinfoService {

	@Override
	public List<Userinfo> findUserinfos() {
		
		System.out.println("UserinfoServiceImpl.findUserinfos");
		UserinfoDao userinfoDao= new UserinfoDao();
		return userinfoDao.findUserinfos();
	}
	
	@Override
	public void addUserinfo(Userinfo userinfo) {
		System.out.println("UserinfoServiceImpl.addUserinfo");
		UserinfoDao userinfoDao= new UserinfoDao();
		userinfoDao.addUserinfo(userinfo);
	}

	
	@Override
	public Userinfo findById(String uid) {
		System.out.println("UserinfoServiceImpl.findById");
		UserinfoDao userinfoDao= new UserinfoDao();
		Userinfo userinfo = userinfoDao.findById(uid);
		return userinfo;
	}
	
	@Override
	public void update(Userinfo userinfo) {
		System.out.println("UserinfoServiceImpl.update");
		UserinfoDao userinfoDao= new UserinfoDao();
		userinfoDao.update(userinfo);
	}
	
	@Override
	public void delete(String uid) {
		System.out.println("UserinfoServiceImpl.delete");
		UserinfoDao userinfoDao= new UserinfoDao();
		userinfoDao.delete(uid);
	}
}
