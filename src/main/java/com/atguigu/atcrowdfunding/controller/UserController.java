package com.atguigu.atcrowdfunding.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.commons.bean.AjaxResult;
import com.atguigu.atcrowdfunding.commons.bean.Page;
import com.atguigu.atcrowdfunding.commons.bean.User;
import com.atguigu.atcrowdfunding.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@ResponseBody
	@RequestMapping("pageQuery")
	public Object pageQuery(Integer pageno, Integer pagesize) {
		AjaxResult result = new AjaxResult();

		try {
			// 分页查询用户信息
			int start = (pageno - 1) * pagesize;
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("start", start);
			paramMap.put("size", pagesize);

			List<User> users = userService.queryPageUsers(paramMap);
			int totalsize = userService.queryPageCount(paramMap);

			Page<User> userPage = new Page<User>();
			userPage.setPageno(pageno);
			userPage.setPagesize(pagesize);
			userPage.setTotalsize(totalsize);
			userPage.setDatas(users);

			result.setData(userPage);
			result.setSuccess(true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setSuccess(false);
		}

		return result;
	}

	@RequestMapping("index")
	public String index() {
		return "user/index";
	}

	/**
	 * 
	 * @param query
	 *            模糊查询
	 * @param pageno
	 *            第几页
	 * @param pagesize
	 *            每页显示的数据的条数
	 * @param start
	 *            分页中的起始 limit(start,pagesize)
	 * @param users
	 *            每页显示的数据
	 * @param totalsize
	 *            总共的数据条数
	 * @param totalno
	 *            总页数
	 * @return 跳转页面
	 */
	@RequestMapping("/index1")
	public String index1(String query,
			@RequestParam(value = "pageno", required = false, defaultValue = "1") Integer pageno,
			@RequestParam(value = "pagesize", required = false, defaultValue = "2") Integer pagesize, Model model) {

		int start = (pageno - 1) * pagesize;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("start", start);
		paramMap.put("size", pagesize);
		paramMap.put("query", query);

		List<User> users = userService.queryPageUsers(paramMap);
		int totalsize = userService.queryPageCount(paramMap);

		Page<User> userPage = new Page<User>();
		userPage.setPageno(pageno);
		userPage.setPagesize(pagesize);
		userPage.setTotalsize(totalsize);
		userPage.setDatas(users);

		model.addAttribute("userPage", userPage);

		return "user/index1";
	}

}
