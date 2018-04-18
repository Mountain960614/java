package com.ys.dao;

import java.util.List;

import com.ys.entiy.User;

public interface UserDao {

	User login(User user);

	List<User> findUserList();

}
