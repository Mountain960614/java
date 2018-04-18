package com.ys.daoImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.opensymphony.xwork2.conversion.impl.DateConverter;
import com.ys.dao.CustomerDao;
import com.ys.entiy.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao{

	@Override
	public void addForm(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}

	@Override
	public List<Customer> findCustomerList() {
		
		return (List<Customer>) this.getHibernateTemplate().find("from Customer");
	}

	@Override
	public List<Customer> findOne(int uid) {
		// TODO Auto-generated method stub
		//find返回的是一个list
		return (List<Customer>) this.getHibernateTemplate().find("from Customer where uid=?", uid);
		//get 方法返回的是一个对象
		//return (List<Customer>) this.getHibernateTemplate().get(Customer.class, uid);
	}

	@Override
	public void deleteOne(Customer c) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(c);
	}

	@Override//修改客户的详细信息
	public void updateCustomerDetail(Customer customer) {
		this.getHibernateTemplate().update(customer);
	}

	@SuppressWarnings("unchecked")
	@Override//查询总记录数
	public int findCount() {
        List<Customer>list=(List<Customer>) 
        		this.getHibernateTemplate().find("from Customer");
		if(list!=null&&list.size()!=0){
			return list.size();
		}
        return  0;
	}

	@SuppressWarnings("unchecked")
	@Override//查询当前页面
	public List<Customer> findPage(int begin, int pageSize) {
		//创建离线类对象来查询
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Customer.class);
		List<Customer>list=(List<Customer>) this.getHibernateTemplate()
				.findByCriteria(detachedCriteria, begin, pageSize);
		return list;
	}

	@Override//表单条件模糊查询
	public List<Customer> listConditions(Customer customer) {
		//创建离线对象，设置对那个实体类进行操作；
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Customer.class);
		//设置对身体类那个属性
		detachedCriteria.add(Restrictions.like("custName","%"+customer.getCustName()+"%"));
		//得到hibernateTemplate对象
		List<Customer>list=(List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		return list;
	}

}
