package com.ssafy.happyhouse.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.mapper.UserMapper;
import com.ssafy.happyhouse.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    
    @Override
	public User login(User user) throws Exception {
		if(user.getUserid() == null || user.getPassword() == null)
			return null;
		return userMapper.login(user);
	}

	@Override
	public User userInfo(String userid) throws Exception {
		return userMapper.userInfo(userid);
	}

	@Override
	public boolean registUser(User user) {
        return userMapper.registUser(user);
    }

    @Override
	public User getUser(String userid) {
        return userMapper.getUser(userid);
    }

    @Override
	public boolean update(User user) {
        return userMapper.update(user);
    }

    @Override
	public String getPw(String id, String name) {
        return userMapper.getPw(id, name);
    }

}
