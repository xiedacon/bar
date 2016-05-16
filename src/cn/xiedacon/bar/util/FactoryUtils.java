package cn.xiedacon.bar.util;

import java.util.Date;

import cn.xiedacon.bar.adminLog.domain.AdminLog;
import cn.xiedacon.bar.floor.domain.Floor;
import cn.xiedacon.bar.post.domain.Post;
import cn.xiedacon.bar.postLog.domain.PostLog;
import cn.xiedacon.bar.postLog.domain.PostOperationLog;
import cn.xiedacon.bar.reply.domain.Reply;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.userLog.domain.UserLog;
import cn.xiedacon.bar.userLog.domain.UserOperationLog;

public class FactoryUtils {

	/**
	 * 获取用户操作记录对象
	 * 
	 * @param user
	 * @param admin
	 * @param time
	 * @param operation
	 * @return
	 */
	public static UserLog getUserLog(User user, User admin, Date time, String operation) {
		// 创建帖子操作记录对象
		UserLog userLog = new UserLog();

		// 准备相关参数
		UserOperationLog userOperationLog = getUserOperationLog(userLog, user, admin, time, operation);

		// 设置参数
		userLog.setFirstOperation(userOperationLog.getOperation());
		userLog.setFirstOperator(userOperationLog.getOperator());
		userLog.setFirstTime(userOperationLog.getTime());
		userLog.setLastOperation(userOperationLog.getOperation());
		userLog.setLastOperator(userOperationLog.getOperator());
		userLog.setLastTime(userOperationLog.getTime());
		userLog.setUser(user);
		userLog.addUserOperationLog(userOperationLog);

		return userLog;
	}

	/**
	 * 更新用户操作记录对象
	 * 
	 * @param userLog
	 * @param user
	 * @param admin
	 * @param time
	 * @param operation
	 * @return
	 */
	public static UserLog updateUserLog(UserLog userLog, User user, User admin, Date time, String operation) {
		// 准备相关参数
		UserOperationLog userOperationLog = getUserOperationLog(userLog, user, admin, time, operation);

		// 设置参数
		userLog.setLastOperation(userOperationLog.getOperation());
		userLog.setLastOperator(userOperationLog.getOperator());
		userLog.setLastTime(userOperationLog.getTime());
		userLog.addUserOperationLog(userOperationLog);

		return userLog;
	}

	/**
	 * 获取吧务操作记录对象
	 * 
	 * @param user
	 * @param admin
	 * @param time
	 * @param operation
	 * @return
	 */
	public static AdminLog getAdminLog(User user, User admin, Date time, String operation) {
		// 创建吧务操作记录对象
		AdminLog adminLog = new AdminLog();

		// 设置参数
		adminLog.setAdminUser(user);
		adminLog.setOperation(operation);
		adminLog.setOperator(admin);
		adminLog.setTime(time);

		return adminLog;
	}

	private static UserOperationLog getUserOperationLog(UserLog userLog, User user, User admin, Date time, String operation) {
		UserOperationLog userOperationLog = new UserOperationLog();

		userOperationLog.setOperation(operation);
		userOperationLog.setOperator(admin);
		userOperationLog.setTime(time);
		userOperationLog.setUserLog(userLog);

		return userOperationLog;
	}

	/**
	 * 获取回复对象
	 * 
	 * @param floor
	 * @param owner
	 * @param content
	 * @param date
	 * @return
	 */
	public static Reply getReply(Floor floor, User owner, String content, Date date) {
		Reply reply = new Reply();

		reply.setContent(content);
		reply.setDate(date);
		reply.setFloor(floor);
		reply.setOwner(owner);

		return reply;
	}

	/**
	 * 获取帖子操作记录对象
	 * 
	 * @param user
	 * @param admin
	 * @param time
	 * @param operation
	 * @return
	 */
	public static PostLog getPostLog(Post post, User admin, Date time, String operation) {
		PostLog postLog = new PostLog();

		PostOperationLog postOperationLog = getPostOperationLog(postLog, admin, time, operation);

		postLog.setFirstOperation(postOperationLog.getOperation());
		postLog.setFirstOperator(postOperationLog.getOperator());
		postLog.setFirstTime(postOperationLog.getTime());
		postLog.setLastOperation(postOperationLog.getOperation());
		postLog.setLastOperator(postOperationLog.getOperator());
		postLog.setLastTime(postOperationLog.getTime());
		postLog.setPost(post);
		postLog.addPostOperationLog(postOperationLog);

		return postLog;
	}

	private static PostOperationLog getPostOperationLog(PostLog postLog, User admin, Date time, String operation) {
		PostOperationLog postOperationLog = new PostOperationLog();

		postOperationLog.setOperation(operation);
		postOperationLog.setOperator(admin);
		postOperationLog.setPostLog(postLog);
		postOperationLog.setTime(time);

		return postOperationLog;
	}

	/**
	 * 更新帖子操作记录对象
	 * 
	 * @param postLog
	 * @param admin
	 * @param time
	 * @param operation
	 * @return
	 */
	public static PostLog updatePostLog(PostLog postLog, User admin, Date time, String operation, Post post) {
		PostOperationLog postOperationLog = getPostOperationLog(postLog, admin, time, operation);

		postLog.setLastOperation(postOperationLog.getOperation());
		postLog.setLastOperator(postOperationLog.getOperator());
		postLog.setLastTime(postOperationLog.getTime());
		postLog.addPostOperationLog(postOperationLog);
		postLog.setPost(post);

		return postLog;
	}
	
	/**
	 * 创建帖子对象
	 * @param pid
	 * @param user
	 * @param date
	 * @param title
	 * @param content
	 * @param num
	 * @param status
	 * @return
	 */
	public static Post getPost(String pid,User owner,Date date,String title,String content,Integer num,Integer status){
		Post post = new Post();
		
		post.setPid(pid);
		post.setContent(content);
		post.setOwner(owner);
		post.setLastUser(owner);
		post.setLdate(date);
		post.setNum(num);
		post.setTitle(title);
		post.setStatus(status);
		
		return post;
	}
	
	/**
	 * 创建帖子对象
	 * @param pid
	 * @param user
	 * @param date
	 * @param title
	 * @param content
	 * @return
	 */
	public static Post getPost(String pid,User owner,Date date,String title,String content){
		return getPost(pid, owner, date, title, content, 1, 1);
	}
	
	/**
	 * 创建楼层对象
	 * @param post
	 * @param user
	 * @param date
	 * @param content
	 * @param num
	 * @return
	 */
	public static Floor getFloor(Post post,User owner,Date date,String content,Integer floorNum){
		Floor floor = new Floor();
		
		floor.setContent(content);
		floor.setDate(date);
		floor.setFloorNum(floorNum);
		floor.setOwner(owner);
		floor.setPost(post);
		
		return floor;
	}
	
	/**
	 * 创建楼层对象
	 * @param post
	 * @param user
	 * @param date
	 * @param content
	 * @return
	 */
	public static Floor getFloor(Post post,User owner,Date date,String content){
		return getFloor(post, owner, date, content, 1);
	}
	
}
