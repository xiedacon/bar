package cn.xiedacon.bar.reply.action.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import cn.xiedacon.bar.floor.domain.Floor;
import cn.xiedacon.bar.floor.service.FloorService;
import cn.xiedacon.bar.reply.action.ReplyAction;
import cn.xiedacon.bar.reply.domain.Reply;
import cn.xiedacon.bar.reply.service.ReplyService;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.user.service.UserService;
import cn.xiedacon.bar.util.PageBean;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author xieda
 *
 */
public class ReplyActionImpl extends ActionSupport implements ReplyAction {

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

	@Override
	public void findByFidAndPage() {
		pageBean = replyService.findByFidAndPage(fid, getPage());
		sendObjectByAjax(pageBean);
	}

	private void sendObjectByAjax(Object object) {
		JSONObject jsonObject = JSONObject.fromObject(object);
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		try {
			ServletActionContext.getResponse().getWriter().print(jsonObject);
		} catch (IOException e) {
		}
	}

	private Integer getPage() {
		if (page == null) {
			page = 1;
		}
		return page;
	}

	@Override
	public void createReply() {
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

}
