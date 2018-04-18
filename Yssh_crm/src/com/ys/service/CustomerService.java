package com.ys.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ys.dao.CustomerDao;
import com.ys.entiy.Customer;
import com.ys.entiy.PageBean;
@Transactional
public class CustomerService {
   private CustomerDao customerDao;

public void setCustomerDao(CustomerDao customerDao) {
	this.customerDao = customerDao;
}
//添加客户信息
public void addForm(Customer customer) {
	// TODO Auto-generated method stub
	customerDao.addForm(customer);
}
public List<Customer> findCustomerList() {
	// TODO Auto-generated method stub
	return customerDao.findCustomerList();
}
public List<Customer> findOne(int attribute) {
	// TODO Auto-generated method stub
	return customerDao.findOne(attribute);
}
public void deleteOne(Customer customer) {
	// TODO Auto-generated method stub
	customerDao.deleteOne(customer);
}
public void ceupdateCustomerDetail(Customer customer) {
     customerDao.updateCustomerDetail(customer);	
}
public PageBean listPage(Integer currentPage) {
	//创建pageBean对象；
	PageBean pageBean=new PageBean();
	//
	   //当前页
		pageBean.setCurrentPage(currentPage);
		//总记录数
		int totalCount=customerDao.findCount();
		pageBean.setTotalCount(totalCount);
		//每页显示记录数
		int pageSize=3;
		//总页数
		int totalPage;
		if(totalCount%pageSize==0){
			totalPage=totalCount/pageSize;
		}else{
			totalPage=totalCount/pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		//开始位置 重点
		int begin=(currentPage-1)*pageSize;
		pageBean.setBegin(begin);
		//每页记录的list集合
		 List<Customer>list=customerDao.findPage(begin,pageSize);
		 pageBean.setList(list);
	return pageBean;
}
public List<Customer> listConditions(Customer customer) {
	// TODO Auto-generated method stub
	return customerDao.listConditions(customer);
}


   
}
