package com.ys.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ys.entiy.User;
import com.ys.service.UserService;

public class UserAction extends ActionSupport {
	private UserService userService;
	private String username;
	private String password;
     public String getUsername() {
		return username;
	}
     
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String login(){
		//封装实体类对象
    	User user=new User();
    	user.setUsername(username);
    	user.setPassword(password);
    	User userExist=userService.login(user);
    	if(userExist!=null){
    		//将登陆信息保存到session中
    		HttpServletRequest request=ServletActionContext.getRequest();
    		request.getSession().setAttribute("user", userExist);
    		return "loginSuccess";
    	}
		return "loginFailed";
     }
}
