package com.ys.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ys.dao.UserDao;
import com.ys.entiy.User;
@Transactional
public class UserService {
     private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
    //登陆的方法
	public User login(User user) {
		return userDao.login(user);
	}
	public List<User> findUserList() {
		// TODO Auto-generated method stub
		return userDao.findUserList();
	}
     
}
