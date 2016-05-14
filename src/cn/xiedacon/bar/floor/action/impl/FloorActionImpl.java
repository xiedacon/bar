package cn.xiedacon.bar.floor.action.impl;

import java.util.Date;

import org.apache.struts2.ServletActionContext;

import cn.xiedacon.bar.floor.domain.Floor;
import cn.xiedacon.bar.floor.service.FloorService;
import cn.xiedacon.bar.post.domain.Post;
import cn.xiedacon.bar.post.service.PostService;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.user.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class FloorActionImpl extends ActionSupport implements cn.xiedacon.bar.floor.action.FloorAction {

	// 变量区

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
		return (User) ServletActionContext.getRequest().getSession().getAttribute("user");
	}

	// //////////////////////////////////////////////////////

	// 公共方法区

	@Override
	public String createFloor() {
		User owner = getUser();

		if (owner == null || owner.getUid() == null || owner.getForbidden() || post == null || post.getPid() == null) {
			// 请求参数有误
			// 用户未登录或被封禁
			return "index";
		}

		post = postService.findByPid(post.getPid());

		if (post == null) {
			// 帖子不存在
			return "index";
		}

		owner = userService.findByUid(owner.getUid());

		if (owner == null) {
			// 用户不存在
			return "index";
		}

		// 创建楼层对象
		Floor floor = new Floor();

		// 准备相关参数
		Date date = new Date();
		int floorNum = post.getNum() + 1;
		owner.setFloorNum(owner.getFloorNum() == null ? 1 : owner.getFloorNum() + 1);
		post.setLastUser(owner);
		post.setNum(floorNum);

		// 设置数据
		floor.setContent(editorValue);
		floor.setDate(date);
		floor.setFloorNum(floorNum);
		floor.setOwner(owner);
		floor.setPost(post);

		//保存楼层
		floorService.createFloor(floor);

		return "createFloor";
	}

}
