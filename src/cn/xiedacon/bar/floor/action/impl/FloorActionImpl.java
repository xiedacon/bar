package cn.xiedacon.bar.floor.action.impl;

import java.util.Date;

import org.apache.struts2.ServletActionContext;

import cn.xiedacon.bar.floor.domain.Floor;
import cn.xiedacon.bar.floor.service.FloorService;
import cn.xiedacon.bar.post.domain.Post;
import cn.xiedacon.bar.post.service.PostService;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.user.service.UserService;
import cn.xiedacon.bar.util.FactoryUtils;

import com.opensymphony.xwork2.ActionSupport;

public class FloorActionImpl extends ActionSupport implements cn.xiedacon.bar.floor.action.FloorAction {

	// 变量区

	private static final long serialVersionUID = 1L;

	private Post post;
	private String editorValue;
	private PostService postService;
	private FloorService floorService;
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Post getPost() {
		return post;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public void setEditorValue(String editorValue) {
		this.editorValue = editorValue;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public void setFloorService(FloorService floorService) {
		this.floorService = floorService;
	}

	// //////////////////////////////////////////////////////

	// 私有方法区

	private User getUser() {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if (user == null || user.getForbidden() || user.getUid() == null) {
			throw new RuntimeException("没有相关权限");
		}

		user = userService.findByUid(user.getUid());

		if (user == null) {
			throw new RuntimeException("没有相关权限");
		}

		return user;
	}

	private String getEditorValue() {
		if (editorValue == null) {
			throw new RuntimeException("请求参数错误");
		}

		return editorValue;
	}

	private Post getExistPost() {
		if (post == null || post.getPid() == null) {
			throw new RuntimeException("请求参数错误");
		}

		post = postService.findByPid(post.getPid());

		if (post == null || post.getStatus() == 2) {// 以后可放到配置文件中!!!
			throw new RuntimeException("请求参数错误");
		}

		return post;
	}

	// //////////////////////////////////////////////////////

	// 公共方法区

	@Override
	public String createFloor() {
		User owner = getUser();
		post = getExistPost();

		// 准备相关参数
		Date date = new Date();
		Integer floorNum = post.getNum() + 1;
		String content = getEditorValue();
		owner.setFloorNum(owner.getFloorNum() == null ? 1 : owner.getFloorNum() + 1);
		post.setLastUser(owner);
		post.setNum(floorNum);

		// 创建楼层对象
		Floor floor = FactoryUtils.getFloor(post, owner, date, content, floorNum);

		// 保存楼层
		floorService.createFloor(floor);

		return "createFloor";
	}

}
