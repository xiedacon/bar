package cn.xiedacon.bar.admin.action.impl;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import cn.xiedacon.bar.admin.action.AdminAction;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.util.PageBean;

public class AdminActionImpl implements AdminAction{

	//变量区
	
	private PageBean<User> pageBean;
	public PageBean<User> getPageBean() {
		return pageBean;
	}
	
/////////////////////////////////////////////////////////////////////////
	
	//私有方法区
	
	private PrintWriter getWriter(){
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		try {
			return ServletActionContext.getResponse().getWriter();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private User getAdmin(){
		return (User) ServletActionContext.getRequest().getSession().getAttribute("user");
	}
	
/////////////////////////////////////////////////////////////////////////
	
	//公共方法区
	
	@Override
	public void toBackStage(){
		if(getAdmin()==null){
			//未登录用户
			return;
		}else{
			getWriter().print(ServletActionContext.getRequest().getContextPath()+"/admin/index");
		}
	}
	
	@Override
	public String toStage(){
		return "index";
	}
	



}
