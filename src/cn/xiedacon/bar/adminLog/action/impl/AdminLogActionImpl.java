package cn.xiedacon.bar.adminLog.action.impl;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.xiedacon.bar.adminLog.action.AdminLogAction;
import cn.xiedacon.bar.adminLog.service.AdminLogService;
import cn.xiedacon.bar.position.PositionManager;
import cn.xiedacon.bar.position.domain.Position;
import cn.xiedacon.bar.user.domain.AdminLog;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.user.service.UserService;
import cn.xiedacon.bar.util.FactoryUtils;
import cn.xiedacon.bar.util.PageBean;

import com.opensymphony.xwork2.ActionSupport;

public class AdminLogActionImpl extends ActionSupport implements AdminLogAction {

	// 变量区

	private static final long serialVersionUID = 1L;
	private PositionManager positionManager;
	private List<Position> positionList;
	private Integer id;
	private String username;
	private Integer uid;
	private List<User> userList;
	private UserService userService;
	private AdminLogService adminLogService;
	private PageBean<AdminLog> pageBean;
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}

	public PageBean<AdminLog> getPageBean() {
		return pageBean;
	}

	public void setAdminLogService(AdminLogService adminLogService) {
		this.adminLogService = adminLogService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Position> getPositionList() {
		return positionList;
	}

	public void setPositionManager(PositionManager positionManager) {
		this.positionManager = positionManager;
	}

	// /////////////////////////////////////

	// 私有方法区

	private User getAdmin() {
		User admin = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if (admin == null || !admin.isAdmin() || admin.getUid() == null) {
			throw new RuntimeException("无权限请求！！！");
		} else {
			return userService.findByUid(admin.getUid());
		}
	}

	private Integer getUid() {
		if (uid == null) {
			throw new RuntimeException("请求参数错误");
		}

		return uid;
	}

	private User getUser() {
		User user = userService.findByUid(getUid());

		if (user == null) {
			throw new RuntimeException("请求参数错误");
		}

		return user;
	}

	private User getUserByUsername() {
		User user = userService.findByUsername(getUsername());
		if (user == null) {
			throw new RuntimeException("请求参数错误");
		}

		return user;
	}

	private String getUsername() {
		if (username == null) {
			throw new RuntimeException("请求参数错误");
		}

		return username;
	}

	private Position getPosition() {
		Position position = positionManager.get(getId());
		if (position == null) {
			throw new RuntimeException("请求参数错误");
		}

		return position;
	}

	private Integer getId() {
		if (id == null) {
			throw new RuntimeException("请求参数错误");
		}

		return id;
	}

	private Integer getPage() {
		return page == null ? 1 : page;
	}

	// //////////////////////////////////////

	// 公共方法区

	@Override
	public String findAdminAll() {
		positionList = positionManager.getPositionList();
		userList = userService.findByPositionId(2);
		return "adminManage";
	}

	@Override
	public String addAdmin() {
		// 准备相关参数
		User user = getUserByUsername();
		User admin = getAdmin();
		Position position = getPosition();
		Date time = new Date();
		user.setPosition(position);
		user.setIsAdmin(true);
		String operation = "添加小吧";

		// 获取吧务操作记录对象
		AdminLog adminLog = FactoryUtils.getAdminLog(user, admin, time, operation);

		// 保存
		adminLogService.save(adminLog);
		return findAdminAll();
	}

	@Override
	public String removeAdmin() {
		// 准备相关参数
		User user = getUser();
		User admin = getAdmin();
		Date time = new Date();
		String operation = "移除小吧";

		// 获取吧务操作记录对象
		AdminLog adminLog = FactoryUtils.getAdminLog(user, admin, time, operation);

		adminLogService.remove(adminLog);
		return findAdminAll();
	}

	@Override
	public String findAdminLog() {
		pageBean = adminLogService.findByPage(getPage());
		return "adminLog";
	}

}
