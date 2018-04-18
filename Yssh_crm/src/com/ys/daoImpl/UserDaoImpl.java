package com.ys.daoImpl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.ys.dao.UserDao;
import com.ys.entiy.User;




public class UserDaoImpl implements UserDao{
   private HibernateTemplate hibernateTemplate;

public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
}

@Override
public User login(User user) {
	List<User>list=(List<User>) hibernateTemplate
			.find("from User where username=?and password=?", user.getUsername(),user.getPassword());
	
	if(list!=null&&list.size()!=0){
		
		return list.get(0);
	}
	return null;
}

@Override
public List<User> findUserList() {
	// TODO Auto-generated method stub
	return (List<User>) hibernateTemplate.find("from User");
}
   
}
