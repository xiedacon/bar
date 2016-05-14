package cn.xiedacon.bar.reply.action.impl;

import java.io.IOException;
import java.util.Date;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> origin/master

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import cn.xiedacon.bar.floor.domain.Floor;
import cn.xiedacon.bar.floor.service.FloorService;
import cn.xiedacon.bar.reply.action.ReplyAction;
import cn.xiedacon.bar.reply.domain.Reply;
import cn.xiedacon.bar.reply.service.ReplyService;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.user.service.UserService;
<<<<<<< HEAD
import cn.xiedacon.bar.util.FactoryUtils;
=======
>>>>>>> origin/master
import cn.xiedacon.bar.util.PageBean;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author xieda
 *
 */
public class ReplyActionImpl extends ActionSupport implements ReplyAction {

<<<<<<< HEAD
	//变量区
	
	private static final long serialVersionUID = 1L;
	
=======
>>>>>>> origin/master
	private ReplyService replyService;
	private FloorService floorService;
	private UserService userService;
	private Integer fid;
	private Integer page;
	private PageBean<Reply> pageBean;
	private String content;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setFloorService(FloorService floorService) {
		this.floorService = floorService;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public PageBean<Reply> getPageBean() {
		return pageBean;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

<<<<<<< HEAD
	//////////////////////////////////////
	
	//私有方法区
	
=======
	@Override
	public void findByFidAndPage() {
		pageBean = replyService.findByFidAndPage(fid, getPage());
		sendObjectByAjax(pageBean);
	}

>>>>>>> origin/master
	private void sendObjectByAjax(Object object) {
		JSONObject jsonObject = JSONObject.fromObject(object);
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		try {
			ServletActionContext.getResponse().getWriter().print(jsonObject);
		} catch (IOException e) {
		}
	}

	private Integer getPage() {
<<<<<<< HEAD
		return page==null?1:page;
	}
	
	private Integer getFid(){
		if(fid==null){
			throw new RuntimeException("请求参数异常");
		}
		
		return fid;
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
	
	private Floor getFloor(){
		Floor floor = floorService.findByFid(getFid());
		
		if(floor==null){
			throw new RuntimeException("请求参数异常");
		}
		
		return floor;
	}
	
	private String getContent() {
		if(content==null){
			throw new RuntimeException("请求参数异常");
		}
		
		return content;
	}
	////////////////////////////////////////
	
	//公共方法区
	
	@Override
	public void findByFidAndPage() {
		pageBean = replyService.findByFidAndPage(getFid(), getPage());
		sendObjectByAjax(pageBean);
=======
		if (page == null) {
			page = 1;
		}
		return page;
>>>>>>> origin/master
	}

	@Override
	public void createReply() {
<<<<<<< HEAD
		//准备相关数据
		Floor floor = getFloor();
		Date date = new Date();
		User owner = getUser();
		String content = getContent();
		
		//创建回复对象
		Reply reply = FactoryUtils.getReply(floor, owner, content, date);
		
		replyService.saveReply(reply);
	}


=======
		User owner = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(owner == null||owner.getUid()==null||fid == null||owner.getForbidden()){
			return;
		}
		owner = userService.findByUid(owner.getUid());
		Floor floor = floorService.findByFid(fid);
		if(floor == null){
			return;
		}
		Reply reply = new Reply();
		reply.setContent(content);
		Date date = new Date();
		reply.setDate(date);
		reply.setFloor(floor);
		reply.setOwner(owner);
		replyService.saveReply(reply);
	}

>>>>>>> origin/master
}
