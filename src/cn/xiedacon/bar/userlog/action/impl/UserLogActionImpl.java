package cn.xiedacon.bar.userLog.action.impl;

import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.user.service.UserService;
import cn.xiedacon.bar.userLog.action.UserLogAction;
import cn.xiedacon.bar.userLog.domain.UserLog;
import cn.xiedacon.bar.userLog.service.UserLogService;
import cn.xiedacon.bar.util.FactoryUtils;
import cn.xiedacon.bar.util.PageBean;

public class UserLogActionImpl extends ActionSupport implements UserLogAction {

	//变量区
	
	private static final long serialVersionUID = 1L;
	
	private PageBean<UserLog> pageBean;
	private UserService userService;
	private UserLogService userLogService;
	private Integer uid;
	private Integer id;
	private Integer page;

	public void setId(Integer id) {
		this.id = id;
	}

	public PageBean<UserLog> getPageBean() {
		return pageBean;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public void setUserLogService(UserLogService userLogService) {
		this.userLogService = userLogService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	////////////////////////////////////////////////////
	
	//私有方法区
	
	private Integer getPage() {
		if(page==null){
			return 1;
		}else{
			return page;
		}
	}
	
	private User getAdmin(){
		User admin = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(admin==null||!admin.isAdmin()||admin.getUid()==null){
			throw new RuntimeException("无权限请求！！！");
		}else{
			return userService.findByUid(admin.getUid());
		}
	}

	private Integer getUid(){
		if(uid==null){
			throw new RuntimeException("请求参数错误");
		}
		
		return uid;
	}
	
	private User getUser(){
		User user = userService.findByUid(getUid());
		
		if(user==null){
			throw new RuntimeException("请求参数错误");
		}
		
		return user;
	}
	
	private Integer getId() {
		if(id==null){
			throw new RuntimeException("请求参数错误");
		}
		
		return id;
	}
	
	//////////////////////////////////////////////////////
	
	//公共方法区
	
	@Override
	public String forbiddenUser() {
		//准备相关参数
		User admin = getAdmin();
		User user = getUser();
		if(admin.getUid().equals(user.getUid())){
			throw new RuntimeException("不能封禁自己");
		}
		
		Date date = new Date();
		String operation = "forbidden";
		user.setForbidden(true);
		
		//获取用户记录对象
		UserLog userLog = FactoryUtils.getUserLog(user, admin, date, operation);
		
		//保存
		userLogService.save(userLog);
		return "userList";
	}

	@Override
	public String addToBlackList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findUnrecoverForbiddenLog() {
		pageBean  = userLogService.findByLastOperationAndPage("forbidden",getPage());
		return "forbiddenList";
	}

	@Override
	public String removeForbiddenLog() {
		//获取用户操作记录实体类
		UserLog userLog = userLogService.findByLastOperationAndId("forbidden", getId());
		if(userLog==null){
			throw new RuntimeException("请求参数错误");
		}
		
		//准备相关参数
		User user = userLog.getUser();
		Date time = new Date();
		User admin = getAdmin();
		String operation = "removeForbidden";
		user.setForbidden(false);
		
		//更新用户记录对象
		userLog = FactoryUtils.updateUserLog(userLog, user, admin, time, operation);
		
		userLogService.update(userLog);
		return "userList";
	}



	@Override
	public String findUnrecoverForbiddenLogByUsername() {
		// TODO Auto-generated method stub
		return "forbiddenList";
	}

	@Override
	public String findUnrecoverBlackListLog() {
		// TODO Auto-generated method stub
		return "blackList";
	}

	@Override
	public String removeBlackListLog() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findUnrecoverBlackListLogByUsername() {
		// TODO Auto-generated method stub
		return "blackList";
	}

	@Override
	public String processAppeal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findUnprocessAppealLog() {
		// TODO Auto-generated method stub
		return "userAppeal";
	}

	@Override
	public String findProcessedAppealLog() {
		// TODO Auto-generated method stub
		return "userAppeal";
	}

	@Override
	public String findUnprocessAppealLogByUsername() {
		// TODO Auto-generated method stub
		return "userAppeal";
	}

	@Override
	public String findProcessedAppealLogByUsername() {
		// TODO Auto-generated method stub
		return "userAppeal";
	}

	@Override
	public String findAllLogByUsername() {
		// TODO Auto-generated method stub
		return "userLog";
	}

	@Override
	public String findAllLog() {
		pageBean = userLogService.findByPage(getPage());
		return "userLog";
	}

}
