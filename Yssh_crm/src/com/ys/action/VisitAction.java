package com.ys.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ys.entiy.Customer;
import com.ys.entiy.User;
import com.ys.entiy.Visit;
import com.ys.service.CustomerService;
import com.ys.service.UserService;
import com.ys.service.VisitService;

public class VisitAction extends ActionSupport implements ModelDriven<Visit> {
        private VisitService visitService;
		public void setVisitService(VisitService visitService) {
			this.visitService = visitService;
		}
		//展示所有客户
		private CustomerService customerService;
		public void setCustomerService(CustomerService customerService) {
			this.customerService = customerService;
		}
		//展示所有用户
		private UserService userService;
		public void setUserService(UserService userService) {
			this.userService = userService;
		}
		public String addCustomerVisit(){
			//查询用户和客户
			List<Customer>customerList=customerService.findCustomerList();
			List<User>userList=userService.findUserList();
			ServletActionContext.getRequest().setAttribute("customerList", customerList);
			ServletActionContext.getRequest().setAttribute("userList", userList);
			return "addCustomerVisit";
		}
		//添加拜访管理
		public String addVisit(){
			visitService.addVisit(visit);
			return "addVisit";
		}
		//使用模型驱动
		private Visit visit=new Visit();
		@Override
		public Visit getModel() {
			// TODO Auto-generated method stub
			return visit;
		}
}
