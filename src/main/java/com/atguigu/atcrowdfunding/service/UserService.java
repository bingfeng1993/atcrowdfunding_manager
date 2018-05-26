package com.atguigu.atcrowdfunding.service;

import java.util.List;
import java.util.Map;

import com.atguigu.atcrowdfunding.commons.bean.User;

public interface UserService {

	User queryUser(Integer id);

	User queryUser4Login(User user);

	List<User> queryPageUsers(Map<String, Object> paramMap);

	int queryPageCount(Map<String, Object> paramMap);

}
