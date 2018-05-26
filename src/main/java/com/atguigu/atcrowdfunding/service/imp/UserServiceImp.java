package com.atguigu.atcrowdfunding.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atcrowdfunding.commons.bean.User;
import com.atguigu.atcrowdfunding.dao.UserDao;
import com.atguigu.atcrowdfunding.service.UserService;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public User queryUser(Integer id) {
		// TODO Auto-generated method stub
		return userDao.queryUser(id);
	}

	@Override
	public User queryUser4Login(User user) {
		// TODO Auto-generated method stub
		return userDao.queryUser4Login(user);
	}

	@Override
	public List<User> queryPageUsers(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return userDao.queryPageUsers(paramMap);
	}

	@Override
	public int queryPageCount(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return userDao.queryPageCount(paramMap);
	}

}
