package cn.xiedacon.bar.post.action.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import cn.xiedacon.bar.floor.domain.Floor;
import cn.xiedacon.bar.floor.service.FloorService;
import cn.xiedacon.bar.post.domain.Post;
import cn.xiedacon.bar.post.service.PostService;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.user.service.UserService;
import cn.xiedacon.bar.util.CommonUtils;
import cn.xiedacon.bar.util.FactoryUtils;
import cn.xiedacon.bar.util.PageBean;

import com.opensymphony.xwork2.ActionSupport;

public class PostActionImpl extends ActionSupport implements cn.xiedacon.bar.post.action.PostAction {

	// 变量区

	private static final long serialVersionUID = 1L;
	
	private PostService postService;
	private FloorService floorService;
	private UserService userService;
	private PageBean<Post> pageBean;
	private Post post;
	private Integer page;
	private String title;
	private String editorValue;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setEditorValue(String editorValue) {
		this.editorValue = editorValue;
	}

	public Post getPost() {
		return post;
	}

	public void setFloorService(FloorService floorService) {
		this.floorService = floorService;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public PageBean<Post> getPageBean() {
		return pageBean;
	}

	// /////////////////////////////////////////////

	// 私有方法区

	private Integer getPage() {
		return page == null ? 1 : page;
	}

	private String getPid() {
		if (post == null || post.getPid() == null) {
			throw new RuntimeException("请求参数有误");
		}

		return post.getPid();
	}

	private String getTitle() {
		if (title == null || title.trim().isEmpty()) {
			throw new RuntimeException("请求参数有误");
		}

		return title;
	}

	private String getEditorValue() {
		if (editorValue == null || editorValue.trim().isEmpty()) {
			throw new RuntimeException("请求参数有误");
		}

		return editorValue;
	}
	
	private User getUser(){
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");

		if (user == null || user.getForbidden() || user.getUid() == null) {
			throw new RuntimeException("无权限请求！！！");
		}

		user = userService.findByUid(user.getUid());

		if (user == null) {
			throw new RuntimeException("无权限请求！！！");
		}

		return user;
	}
	
	private void print(Object json){
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		try {
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (IOException e) {
		}
	}

	// //////////////////////////////////////////////

	// 公共方法区

	@Override
	public String findByPage() {
		pageBean = postService.findByPage(getPage());
		return "findByPage";
	}

	@Override
	public String boutique() {
		pageBean = postService.findByStatusAndPage(3,getPage());
		return "boutique";
	}

	@Override
	public String findByPidAndPage() {
		post = postService.findByPid(getPid());

		if (post == null) {
			// 查出的post不存在，估计有人捣乱，跳转到msg视图
			throw new RuntimeException("查询的id为" + post.getPid() + "帖子不存在");
		}

		PageBean<Floor> pageBean = floorService.findByPostAndPage(getPid(), getPage());
		post.setPageBean(pageBean);
		return "findByPidAndPage";
	}

	@Override
	public String createPost() {
		//准备相关数据
		String pid = CommonUtils.uuid();
		Date date = new Date();
		User user = getUser();
		user.setPostNum(user.getPostNum() == null ? 1 : user.getPostNum() + 1);
		String title = getTitle();
		String content = getEditorValue();
		
		//创建帖子
		post = FactoryUtils.getPost(pid, user, date, title, content);
		
		// 保存帖子
		postService.createPost(post);
		
		// 创建1楼
		Floor firstFloor = FactoryUtils.getFloor(post, user, date, content);
		
		// 保存1楼
		floorService.createFloor(firstFloor);
		return findByPidAndPage();
	}

	@Override
	public void findDeletePosts() {
		User user = getUser();
		List<Post> postList = postService.findByStatusAndOwner(2,user);
		JSONObject json = JSONObject.fromObject(postList);
		print(json);
	}

}
