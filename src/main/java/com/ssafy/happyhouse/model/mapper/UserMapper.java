package com.ssafy.happyhouse.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dto.User;

@Mapper
public interface UserMapper {

	boolean registUser(User user);

	String login(Map<String, String> map);

	User getUser(String userid);

	boolean update(User user);

	String getPw(String id, String name);

}