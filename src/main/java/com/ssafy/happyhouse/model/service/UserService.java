package com.ssafy.happyhouse.model.service;

import java.util.Map;

import com.ssafy.happyhouse.model.dto.User;

public interface UserService {

	boolean registUser(User user);

	String login(Map<String, String> map);

	User getUser(String userid);

	boolean update(User user);

	String getPw(String id, String name);

}