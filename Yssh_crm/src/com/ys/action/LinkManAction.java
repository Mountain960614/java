package com.ys.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ys.entiy.Customer;
import com.ys.entiy.LinkMan;
import com.ys.service.CustomerService;
import com.ys.service.LinkManService;

public class LinkManAction  extends ActionSupport implements ModelDriven<LinkMan>{
   private LinkManService linkManService;
   private LinkMan linkMan=new LinkMan();
   private CustomerService customerService;
   /*
	 * 需要上传文件（流）
	 * 需要上传文件名称
	 * （1）在action里面成员变量位置定义变量（命名规范）
	 * - 一个表示上传文件
	 * - 一个表示文件名称
	 * （2）生成变量的get和set方法
	 * 
	 * 还有一个变量，上传文件的mime类型
	 * */
	// 上传文件
	//变量的名称需要是表单里面文件上传项的name值
	private File upload;
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	//上传文件名称   表单里面文件上传项的name值FileName
	private String uploadFileName;
	
	//生成get和set方法
public void setCustomerService(CustomerService customerService) {
	this.customerService = customerService;
}
public void setLinkManService(LinkManService linkManService) {
	this.linkManService = linkManService;
}
   public String addContactPerson(){
	   //将所属客户做成 一个下拉列表;
	   List<Customer> listCustomer=customerService.findCustomerList();
	   ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
	   return "addContactPerson";
   }
   //添加add.jsp里面的信息到数据库
   public String addLinkMan() throws IOException{
	   //通过upload判断上传文件选项是否为空
	   if(upload!=null){
		   //1.在上传到服务器里面创建文件
		   File servletFile=new File("E:\\ssh"+"/"+uploadFileName);
		   //2.把上传本地文件复制到服务器的文件中；
		   //第一个参数为上传文件
		   //第二个参数为服务器文件
		   FileUtils.copyFile(upload, servletFile);
	   }
	   linkManService.addForm(linkMan);
	   return "addLinkMan";
   }
   //返回联系人列表
   public String  linkManList(){
	   List<LinkMan> linkManList=linkManService.findLinkManList();
	   ServletActionContext.getRequest().setAttribute("linkManList", linkManList);
	   return "linkManList";
   }
   //联系人修改
   public String showLinkMan(){
	  LinkMan link=linkManService.findOne(linkMan.getLinkId());
	  ServletActionContext.getRequest().setAttribute("linkMan", link);
	  List<Customer>customerList=customerService.findCustomerList();
	  ServletActionContext.getRequest().setAttribute("customerList",customerList);
	   return "showLinkMan";
   }
   //修改linkMan的信息
   public  String updateLinkMan(){
	   linkManService.updateLinkMan(linkMan);
	   return "updateLinkMan";
   }
@Override 
public LinkMan getModel() {
	
	return linkMan;
}

}
