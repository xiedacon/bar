package cn.xiedacon.bar.post.action.impl;

import java.util.Date;

import org.apache.struts2.ServletActionContext;

import cn.xiedacon.bar.post.action.AdminPostAction;
import cn.xiedacon.bar.post.domain.Post;
import cn.xiedacon.bar.post.domain.PostLog;
import cn.xiedacon.bar.post.domain.PostOperationLog;
import cn.xiedacon.bar.post.service.AdminPostService;
import cn.xiedacon.bar.post.service.PostService;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.user.service.UserService;
import cn.xiedacon.bar.util.PageBean;

import com.opensymphony.xwork2.ActionSupport;

public class AdminPostActionImpl extends ActionSupport implements AdminPostAction {

	// 变量区

	private AdminPostService adminPostService;
	private PostService postService;
	private UserService userService;
	private PageBean<PostLog> pageBean;
	private Integer id;
	private String username;
	private Integer interval;
	private String pid;
	private Integer page;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setInterval(Integer interval) {
		this.interval = interval;
	}

	public PageBean<PostLog> getPageBean() {
		return pageBean;
	}

	public void setAdminPostService(AdminPostService adminPostService) {
		this.adminPostService = adminPostService;
	}

	// //////////////////////////////////////////////////////

	// 私有方法区

	private Integer getPage() {
		return page == null ? 1 : page;
	}

	private User getAdmin() {
		User admin = (User) ServletActionContext.getRequest().getSession().getAttribute("user");

		if (admin == null || !admin.isAdmin() || admin.getUid() == null) {
			throw new RuntimeException("无权限请求！！！");
		}

		admin = userService.findByUid(admin.getUid());

		if (admin == null) {
			throw new RuntimeException("无权限请求！！！");
		}

		return admin;
	}

	private Integer getId() {
		if (id == null) {
			throw new RuntimeException("请求参数异常");
		}

		return id;

	}

	private String getUsername() {
		if (username == null) {
			throw new RuntimeException("请求参数异常");
		}

		return username;

	}

	private User getUser() {
		User user = userService.findByUsername(getUsername());
		if (user == null) {
			throw new RuntimeException("请求参数异常");
		}

		return user;

	}

	private String getPid() {
		if (pid == null) {
			throw new RuntimeException("请求参数异常");
		}

		return pid;

	}

	private Post getPost() {
		Post post = postService.findByPid(getPid());
		
		if (post == null) {
			throw new RuntimeException("请求参数异常");
		}

		return post;

	}

	// //////////////////////////////////////////////

	// 公共方法区

	@Override
	public String findUnRecoverDeleteLog() {
		pageBean = adminPostService.findPostLogByLastOperationAndPage("delete", getPage());
		return "deletePost";
	}

	@Override
	public String findAllLog() {
		pageBean = adminPostService.findPostLogByPage(getPage());
		return "postLog";
	}

	@Override
	public String recoverPost() {
		PostLog postLog = adminPostService.findPostLogByLastOperationAndId("delete", getId());

		if (postLog == null) {
			throw new RuntimeException("请求参数异常");
		}

		// 创建帖子单次操作记录对象
		PostOperationLog operationLog = new PostOperationLog();

		// 准备相关参数
		Date time = new Date();
		User admin = getAdmin();

		// 设置参数
		operationLog.setOperation("recover");
		operationLog.setOperator(admin);
		operationLog.setPostLog(postLog);
		operationLog.setTime(time);

		postLog.setLastOperation(operationLog.getOperation());
		postLog.setLastOperator(operationLog.getOperator());
		postLog.setLastTime(operationLog.getTime());
		postLog.addPostOperationLog(operationLog);

		postLog.getPost().setStatus(1);

		adminPostService.updatePostOperationLog(postLog);
		return findUnRecoverDeleteLog();
	}

	@Override
	public String findUnprocessAppealLogByUsername() {
		pageBean = adminPostService.findAppealLogByAppealProcessAndAppealUser(false, getUser());
		return "postAppeal";
	}

	@Override
	public String findProcessedAppealLogByUsername() {
		pageBean = adminPostService.findAppealLogByAppealProcessAndAppealUser(true, getUser());
		return "postAppeal";
	}

	@Override
	public String findUnprocessAppealLogAll() {
		pageBean = adminPostService.findAppealLogByAppealProcessAndPage(false, getPage());
		return "postAppeal";
	}

	@Override
	public String findProcessedAppealLogAll() {
		pageBean = adminPostService.findAppealLogByAppealProcessAndPage(true, getPage());
		return "postAppeal";
	}

	@Override
	public String findLogByFirstOperatorAndInterval() {
		pageBean = adminPostService.findPostLogByFirstOperatorAndInterval(getUser(), interval);
		return "postLog";
	}

	@Override
	public String findLogByLastOperatorAndInterval() {
		pageBean = adminPostService.findPostLogByLastOperatorAndInterval(getUser(), interval);
		return "postLog";
	}

	@Override
	public String findUnRecoverDeleteLogByFirstOperatorAInterval() {
		pageBean = adminPostService.findPostLogByLastOperationAFirstOperatorAInterval("delete", getUser(), interval);
		return "postAppeal";
	}

	@Override
	public String findUnRecoverDeleteLogByLastOperatorAInterval() {
		pageBean = adminPostService.findPostLogByLastOperationALastOperatorAInterval("delete", getUser(), interval);
		return "postAppeal";
	}

	@Override
	public String deletePost() {
		// 创建帖子操作记录对象
		PostLog postLog = new PostLog();

		// 准备相关参数
		Post post = getPost();
		post.setStatus(2);
		User user = getAdmin();
		user.setDeletePostNum(user.getDeletePostNum() == null ? 1 : user.getDeletePostNum() + 1);
		Date date = new Date();

		PostOperationLog postOperationLog = new PostOperationLog();
		postOperationLog.setOperation("delete");
		postOperationLog.setOperator(user);
		postOperationLog.setPostLog(postLog);
		postOperationLog.setTime(date);

		// 设置数据
		postLog.setFirstOperation(postOperationLog.getOperation());
		postLog.setFirstOperator(postOperationLog.getOperator());
		postLog.setFirstTime(postOperationLog.getTime());
		postLog.setLastOperation(postOperationLog.getOperation());
		postLog.setLastOperator(postOperationLog.getOperator());
		postLog.setLastTime(postOperationLog.getTime());
		postLog.setPost(post);
		postLog.addPostOperationLog(postOperationLog);

		// 保存记录
		adminPostService.savePostLog(postLog);

		return "index";
	}
}
