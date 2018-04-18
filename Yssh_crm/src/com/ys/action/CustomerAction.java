package com.ys.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ys.entiy.Customer;
import com.ys.entiy.PageBean;
import com.ys.service.CustomerService;

public class CustomerAction extends ActionSupport implements
ModelDriven<Customer> {
     private CustomerService customerService;
     private Customer customer=new Customer();
     private Integer currentPage;
     public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Customer getModel() {
 		return customer;
 	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	//条件查询，结果展示
	public String listConditions(){
		//判断输入框的值是否为空
		String cName=customer.getCustName();
		List<Customer>list;
		if(cName==null){
			list=customerService.findCustomerList();
		}else{
			list=customerService.listConditions(customer);
		}
		ServletActionContext.getRequest().setAttribute("list", list);	
		return "listConditions";
	}
	//实现客户分页展示
	public String listPage(){
		//调用service的方法实现封装
		PageBean pageBean=customerService.listPage(currentPage);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "listPage";
	}
	//到添加客户页面
     public String toAddPage(){
    	 return "addPage";
     }
     public String addForm(){
    	 customerService.addForm(customer);
    	 return "add";
     }
     //客户列表
     public String customerList(){
    	List<Customer> list=customerService.findCustomerList();
    	ServletActionContext.getRequest().setAttribute("list", list);
    	 return "customerList";
     }
     //删除客户
     public String deleteCustomer(){
    	//先查询，再删除 
    	 int uid=(Integer) ServletActionContext.getRequest().getAttribute("uid");
    	 System.out.println(uid);
    	 List<Customer>list=customerService
    			 .findOne(uid);
    	 if(list!=null&&list.size()!=0){
    		 customerService.deleteOne(list.get(0));
    	 }
    	 return "delete";
     }
	//修改客户
     public String updateCustomer(){
    	 //使用模型驱动获得uid的值 customer.getUid()
    	 List<Customer>list=customerService.findOne(customer.getUid());
    	 Customer customer=list.get(0);
    	 ServletActionContext.getRequest().setAttribute("customer", customer);
    	 return "updateCustomer";
     }
     //修改客户详细信息
     public String  updateCustomerDetail(){
    	 
    	customerService.ceupdateCustomerDetail(customer);
    	List<Customer>list=customerService.findCustomerList();
    	ServletActionContext.getRequest().setAttribute("list",list);
    	 return "updateCustomerDetail";
     }
}
