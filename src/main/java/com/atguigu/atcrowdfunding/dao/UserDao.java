package com.atguigu.atcrowdfunding.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.atguigu.atcrowdfunding.commons.bean.User;

public interface UserDao {

	@Select("select * from t_user where id = #{id}")
	User queryUser(Integer id);

	@Select("select * from t_user where loginacct = #{loginacct} and userpswd = #{userpswd}")
	User queryUser4Login(User user);

	List<User> queryPageUsers(Map<String, Object> paramMap);

	int queryPageCount(Map<String, Object> paramMap);

}
