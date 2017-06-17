package com.service;

import java.util.List;

import com.domain.Userinfo;

public interface UserinfoService {
	
	List<Userinfo> findUserinfos();
	
	void addUserinfo(Userinfo userinfo);
	
	Userinfo findById(String uid);
	
	void update(Userinfo userinfo);
	
	void delete(String uid);
}
