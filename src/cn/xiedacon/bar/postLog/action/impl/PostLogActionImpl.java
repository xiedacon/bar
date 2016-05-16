package cn.xiedacon.bar.postLog.action.impl;

import java.util.Date;

import org.apache.struts2.ServletActionContext;

import cn.xiedacon.bar.post.domain.Post;
import cn.xiedacon.bar.post.service.PostService;
import cn.xiedacon.bar.postLog.action.PostLogAction;
import cn.xiedacon.bar.postLog.domain.PostLog;
import cn.xiedacon.bar.postLog.service.PostLogService;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.user.service.UserService;
import cn.xiedacon.bar.util.FactoryUtils;
import cn.xiedacon.bar.util.PageBean;

import com.opensymphony.xwork2.ActionSupport;

public class PostLogActionImpl extends ActionSupport implements PostLogAction {

	// 变量区

	private static final long serialVersionUID = 1L;
	
	private PostLogService postLogService;
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

	public void setPostLogService(PostLogService postLogService) {
		this.postLogService = postLogService;
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
		pageBean = postLogService.findByLastOperationAndPage("delete", getPage());
		return "deletePost";
	}

	@Override
	public String findAllLog() {
		pageBean = postLogService.findByPage(getPage());
		return "postLog";
	}

	@Override
	public String recoverPost() {
		PostLog postLog = postLogService.findByLastOperationAndId("delete", getId());

		if (postLog == null) {
			throw new RuntimeException("请求参数异常");
		}
		// 准备相关参数
		Date time = new Date();
		User admin = getAdmin();
		String operation = "recover";
		Post post = postLog.getPost();
		post.setStatus(1);

		postLog = FactoryUtils.updatePostLog(postLog, admin, time, operation, post);

		postLogService.update(postLog);
		return findUnRecoverDeleteLog();
	}

	@Override
	public String findUnprocessAppealLogByUsername() {
		pageBean = postLogService.findAppealLogByAppealProcessAndAppealUser(false, getUser());
		return "postAppeal";
	}

	@Override
	public String findProcessedAppealLogByUsername() {
		pageBean = postLogService.findAppealLogByAppealProcessAndAppealUser(true, getUser());
		return "postAppeal";
	}

	@Override
	public String findUnprocessAppealLogAll() {
		pageBean = postLogService.findAppealLogByAppealProcessAndPage(false, getPage());
		return "postAppeal";
	}

	@Override
	public String findProcessedAppealLogAll() {
		pageBean = postLogService.findAppealLogByAppealProcessAndPage(true, getPage());
		return "postAppeal";
	}

	@Override
	public String findLogByFirstOperatorAndInterval() {
		pageBean = postLogService.findByFirstOperatorAndInterval(getUser(), interval);
		return "postLog";
	}

	@Override
	public String findLogByLastOperatorAndInterval() {
		pageBean = postLogService.findByLastOperatorAndInterval(getUser(), interval);
		return "postLog";
	}

	@Override
	public String findUnRecoverDeleteLogByFirstOperatorAInterval() {
		pageBean = postLogService.findByLastOperationAFirstOperatorAInterval("delete", getUser(), interval);
		return "postAppeal";
	}

	@Override
	public String findUnRecoverDeleteLogByLastOperatorAInterval() {
		pageBean = postLogService.findByLastOperationALastOperatorAInterval("delete", getUser(), interval);
		return "postAppeal";
	}

	@Override
	public String deletePost() {
		// 准备相关参数
		Post post = getPost();
		User admin = getAdmin();
		Date time = new Date();
		String operation = "delete";
		post.setStatus(2);
		admin.setDeletePostNum(admin.getDeletePostNum() == null ? 1 : admin.getDeletePostNum() + 1);

		// 创建帖子操作记录对象
		PostLog postLog = FactoryUtils.getPostLog(post, admin, time, operation);

		// 保存记录
		postLogService.save(postLog);
		return "index";
	}
}
