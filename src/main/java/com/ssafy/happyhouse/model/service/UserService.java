package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.dto.User;

public interface UserService {

	User login(User user) throws Exception;
	
	public User userInfo(String userid) throws Exception;

	User getUser(String userid);
	
	boolean registUser(User user);

	boolean update(User user);

	String getPw(String id, String name);

}