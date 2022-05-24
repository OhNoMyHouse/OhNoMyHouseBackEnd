package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dto.User;

@Mapper
public interface UserMapper {
	
	public User login(User user) throws SQLException;
	public User userInfo(String userid) throws SQLException;

	
	boolean registUser(User user);

	User getUser(String userid);

	boolean update(User user);

	String getPw(String id, String name);

}