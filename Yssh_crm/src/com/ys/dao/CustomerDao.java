package com.ys.dao;

import java.util.List;

import com.ys.entiy.Customer;

public interface CustomerDao {

	void addForm(Customer customer);

	List<Customer> findCustomerList();

	List<Customer> findOne(int uid);

	void deleteOne(Customer customer);

	void updateCustomerDetail(Customer customer);

	int findCount();

	List<Customer> findPage(int begin, int pageSize);

	List<Customer> listConditions(Customer customer);

}
