package com.fruitscity.biz.impl;

import java.util.List;

import com.fruitscity.biz.UserBiz;
import com.fruitscity.dao.UserDAO;
import com.fruitscity.entity.Admin;
import com.fruitscity.entity.Users;

public class UserBizImpl implements UserBiz {

	UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public List login(Users condition) {
		return userDAO.search(condition);
	}

	//添加用户
	@Override
	public void addUsers(Users users) {
		userDAO.addUsers(users);		
	}

	//管理员登录验证
	@Override
	public List login(Admin condition) {
		return userDAO.search(condition);
	}

	//修改个人信息
	@Override
	public void modifyUsers(Users users) {
		userDAO.modifyUsers(users);
	}
}
