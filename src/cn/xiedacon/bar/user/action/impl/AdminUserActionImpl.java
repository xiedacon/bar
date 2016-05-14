package cn.xiedacon.bar.user.action.impl;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.xiedacon.bar.position.PositionManager;
import cn.xiedacon.bar.position.domain.Position;
import cn.xiedacon.bar.user.action.AdminUserAction;
import cn.xiedacon.bar.user.domain.AdminLog;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.user.domain.UserLog;
import cn.xiedacon.bar.user.domain.UserOperationLog;
import cn.xiedacon.bar.user.service.AdminUserService;
import cn.xiedacon.bar.user.service.UserService;
import cn.xiedacon.bar.util.PageBean;

public class AdminUserActionImpl extends ActionSupport implements AdminUserAction {

	private PageBean<UserLog> pageBean;
	private UserService userService;
	private AdminUserService adminUserService;
	private Integer uid;
	private Integer id;
	private List<User> userList;
	private String username;
	private PositionManager positionManager;
	private List<Position> positionList;
	private PageBean<AdminLog> adminLogPageBean;
	public PageBean<AdminLog> getAdminLogPageBean() {
		return adminLogPageBean;
	}

	public List<Position> getPositionList() {
		return positionList;
	}

	public void setPositionManager(PositionManager positionManager) {
		this.positionManager = positionManager;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PageBean<UserLog> getPageBean() {
		return pageBean;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	private Integer page;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

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

	@Override
	public String forbiddenUser() {
		if(uid==null){
			System.out.println("参数异常");
			return NONE;
		}
		UserLog userLog = new UserLog();
		
		User admin = getAdmin();
		User user = userService.findByUid(uid);
		user.setForbidden(true);
		if(admin.getUid().equals(user.getUid())){
			System.out.println("...");
			return NONE;
		}
		Date date = new Date();
		UserOperationLog userOperationLog = new UserOperationLog();
		userOperationLog.setOperation("forbidden");
		userOperationLog.setOperator(admin);
		userOperationLog.setTime(date);
		userOperationLog.setUserLog(userLog);
		
		userLog.setFirstOperation("forbidden");
		userLog.setFirstOperator(admin);
		userLog.setFirstTime(date);
		userLog.setLastOperation("forbidden");
		userLog.setLastOperator(admin);
		userLog.setLastTime(date);
		userLog.setUser(user);
		userLog.addUserOperationLog(userOperationLog);
		
		adminUserService.saveUserLog(userLog);
		return "userList";
	}

	@Override
	public String addToBlackList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findUserByUsername() {
		// TODO Auto-generated method stub
		return "userList";
	}

	@Override
	public String findUnrecoverForbiddenLog() {
		pageBean  = adminUserService.findLogByLastOperationAndPage("forbidden",getPage());
		return "forbiddenList";
	}

	@Override
	public String removeForbiddenLog() {
		if(id==null){
			System.out.println("参数异常");
			return NONE;
		}
		UserLog userLog = adminUserService.findUserLogByLastOperationAndId("forbidden", id);
		if(userLog==null){
			return NONE;
		}
		
		Date time = new Date();
		User user = userLog.getUser();
		user.setForbidden(false);
		UserOperationLog userOperationLog = new UserOperationLog();
		userOperationLog.setOperation("removeForbidden");
		userOperationLog.setOperator(getAdmin());
		userOperationLog.setTime(time);
		userOperationLog.setUserLog(userLog);
		
		userLog.setLastOperation(userOperationLog.getOperation());
		userLog.setLastOperator(userOperationLog.getOperator());
		userLog.setLastTime(userOperationLog.getTime());
		userLog.addUserOperationLog(userOperationLog);
		
		adminUserService.updateUserLog(userLog);
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
		pageBean = adminUserService.findUserLogAll(getPage());
		return "userLog";
	}

	@Override
	public String findAdminAll() {
		positionList = positionManager.getPositionList();
		userList = userService.findAdminAll();
		return "adminManage";
	}

	@Override
	public String addAdmin() {
		if(id==null||username==null){
			System.out.println("参数异常");
			return NONE;
		}
		User user = userService.findByUsername(username);
		if(user==null){
			System.out.println("参数异常");
			return NONE;
		}
		
		Position position = positionManager.get(id);
		if(position==null){
			System.out.println("参数异常");
			return NONE;
		}
		user.setPosition(position);
		user.setIsAdmin(true);
		
		Date time = new Date();
		
		AdminLog adminLog = new AdminLog();
		adminLog.setAdminUser(user);
		adminLog.setOperation("添加小吧");
		adminLog.setOperator(getAdmin());
		adminLog.setTime(time);
		
		adminUserService.saveAdminLog(adminLog);
		return findAdminAll();
	}

	@Override
	public String removeAdmin() {
		if(uid==null){
			System.out.println("参数异常");
			return NONE;
		}
		User user = userService.findByUid(uid);
		if(user==null){
			System.out.println("参数异常");
			return NONE;
		}
		
		Date time = new Date();
		
		AdminLog adminLog = new AdminLog();
		adminLog.setAdminUser(user);
		adminLog.setOperation("移除小吧");
		adminLog.setOperator(getAdmin());
		adminLog.setTime(time);
		
		adminUserService.removeAdmin(adminLog);
		return findAdminAll();
	}

	@Override
	public String findAdminLog() {
		adminLogPageBean = adminUserService.findAdminLogByPage(getPage());
		return "adminLog";
	}

}
