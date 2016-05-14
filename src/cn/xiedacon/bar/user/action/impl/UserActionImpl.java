package cn.xiedacon.bar.user.action.impl;

import java.io.IOException;
<<<<<<< HEAD
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import cn.xiedacon.bar.level.domain.Level;
=======

import org.apache.struts2.ServletActionContext;

>>>>>>> origin/master
import cn.xiedacon.bar.user.action.UserAction;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.user.service.UserService;
import cn.xiedacon.bar.util.PageBean;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
<<<<<<< HEAD

/**
 * 用户action，无前端页面，全ajax
 * 
 * @author xieda
 * 
 */
public class UserActionImpl extends ActionSupport implements ModelDriven<User>, UserAction {

	// 变量区

	private static final long serialVersionUID = 1L;
=======
/**
 * 用户action，无前端页面，全ajax
 * @author xieda
 *
 */
public class UserActionImpl extends ActionSupport implements ModelDriven<User>,UserAction {

>>>>>>> origin/master
	private UserService userService;
	private User user = new User();
	private String repassword;
	private PageBean<User> pageBean;
	private Integer page;
<<<<<<< HEAD

=======
>>>>>>> origin/master
	public void setPage(Integer page) {
		this.page = page;
	}

	public PageBean<User> getPageBean() {
		return pageBean;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
<<<<<<< HEAD

	@Override
	public User getModel() {
		return user;
	}

	// //////////////////////////////////////////

	// 私有方法区

	/**
	 * 校验用户名功能
	 * @return
	 */
	private boolean verifyUsername() {
		String username = user.getUsername();
		return required(username, "用户名不能为空") && length(username, 5, 10, "用户名长度应在5~10之间");
	}

=======
	
	/**
	 * 登陆功能
	 */
	public void login(){
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		if(verifyUsername()&&verifyPassword()){
			User existUser = userService.findByUsername(user.getUsername());
			if(existUser==null){
				print("用户名错误");
			}else if(existUser.getPassword().equals(user.getPassword())){
				ServletActionContext.getRequest().getSession().invalidate();
				existUser.setPassword("");
				ServletActionContext.getRequest().getSession().setAttribute("user", existUser);
			}else{
				print("密码错误");
			}
		}else{
			//校验失败
		}
	}
	
	/**
	 * 注册功能
	 */
	public void regist(){
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		if(verifyUsername()&&verifyPassword()&&verifyRepassword()&&verifyName()&&verifyEmail()&&verifyUsernameExist()){
			//补全信息
			
			userService.regist(user);
			
			//激活
			
		}else{
			//校验失败
		}
	}
	
	/**
	 * 校验用户名功能
	 */
	private boolean verifyUsername(){
		String username = user.getUsername();
		return required(username, "用户名不能为空")
				&&length(username,5,10,"用户名长度应在5~10之间");
	}
	
>>>>>>> origin/master
	/**
	 * 校验密码功能
	 */
	private boolean verifyPassword() {
		String password = user.getPassword();
<<<<<<< HEAD
		return required(password, "密码不能为空") && length(password, 5, 10, "密码长度应在5~10之间");
	}

=======
		return required(password, "密码不能为空")
				&&length(password,5,10,"密码长度应在5~10之间");
	}
	
>>>>>>> origin/master
	/**
	 * 校验二次密码
	 */
	private boolean verifyRepassword() {
		String password = user.getPassword();
<<<<<<< HEAD
		return required(repassword, "二次密码不能为空") && than(password, repassword, "两次输入密码不一致");
=======
		return required(repassword, "二次密码不能为空")
				&&than(password,repassword,"两次输入密码不一致");
>>>>>>> origin/master
	}

	/**
	 * 校验昵称
	 */
	private boolean verifyName() {
		String name = user.getName();
<<<<<<< HEAD
		return required(name, "昵称不能为空") && length(name, 0, 10, "昵称长度不能超过10");
	}

=======
		return required(name, "昵称不能为空")
				&&length(name,0,10,"昵称长度不能超过10");
	}
	
>>>>>>> origin/master
	/**
	 * 校验邮箱
	 */
	private boolean verifyEmail() {
		String email = user.getEmail();
<<<<<<< HEAD
		return required(email, "邮箱不能为空") && email(email, "邮箱格式错误");
	}

	// 邮箱格式校验
	private String regex = "\\b(^['_A-Za-z0-9-]+(\\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";

	private boolean email(String email, String result) {
		if (email.matches(regex)) {
			return true;
		} else {
=======
		return required(email, "邮箱不能为空")
				&&email(email,"邮箱格式错误");
	}
	
	//邮箱格式校验
	private String regex = "\\b(^['_A-Za-z0-9-]+(\\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
	private boolean email(String email, String result) {
		if(email.matches(regex)){
			return true;
		}else{
>>>>>>> origin/master
			print(result);
			return false;
		}
	}

<<<<<<< HEAD
	// 非空检验
	private boolean required(String verifyValue, String result) {
		if (verifyValue == null || verifyValue.trim().isEmpty()) {
			print(result);
			return false;
		} else {
			return true;
		}
	}

	// 长度校验
	private boolean length(String verifyValue, int min, int max, String result) {
		int length = verifyValue.length();
		if (length < min || length > max) {
			print(result);
			return false;
		} else {
			return true;
		}
	}

	// 相同性校验
	private boolean than(String password, String repassword, String result) {
		if (password.equals(repassword)) {
			return true;
		} else {
=======
	//非空检验
	private boolean required(String verifyValue,String result){
		if(verifyValue==null||verifyValue.trim().isEmpty()){
			print(result);
			return false;
		}else{
			return true;
		}
	}
	
	//长度校验
	private boolean length(String verifyValue,int min,int max,String result){
		int length = verifyValue.length();
		if(length<min||length>max){
			print(result);
			return false;
		}else{
			return true;
		}
	}
	
	//相同性校验
	private boolean than(String password, String repassword, String result) {
		if(password.equals(repassword)){
			return true;
		}else{
>>>>>>> origin/master
			print(result);
			return false;
		}
	}
<<<<<<< HEAD

	private void print(String msg) {
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
=======
	private void print(String msg){
>>>>>>> origin/master
		try {
			ServletActionContext.getResponse().getWriter().print(msg);
		} catch (IOException e) {
		}
	}

<<<<<<< HEAD
	private boolean verifyUsernameExist() {
		User existUser = userService.findByUsername(user.getUsername());
		if (existUser == null) {
			return true;
		} else {
			print("用户名已被注册");
			return false;
		}
	}

	private Integer getPage() {
		return page==null?1:page;
	}

	// //////////////////////////////////////////////

	// 公共方法区

	@Override
	public void login() {
		if (verifyUsername() && verifyPassword()) {
			User existUser = userService.findByUsername(user.getUsername());
			if (existUser == null) {
				print("用户名错误");
			} else if (existUser.getPassword().equals(user.getPassword())) {
				existUser.setPassword("");
				
				ServletActionContext.getRequest().getSession().invalidate();
				ServletActionContext.getRequest().getSession().setAttribute("user", existUser);
			} else {
				print("密码错误");
			}
		} else {
			// 校验失败
		}
	}

	@Override
	public void regist() {
		if (verifyUsername() && verifyPassword() && verifyRepassword() && verifyName() && verifyEmail() && verifyUsernameExist()) {
			// 补全信息
			Level level = new Level();
			level.setLid(1);
			user.setRegistDate(new Date());
			user.setLevel(level);
			user.setBoutiqueNum(0);
			user.setDeletePostNum(0);
			user.setFloorNum(0);
			user.setForbidden(false);
			user.setIcon("icons/default.png");
			user.setIsAdmin(false);
			user.setPostNum(0);
			
			userService.regist(user);

			// 激活

		} else {
			// 校验失败
		}
=======
	@Override
	public User getModel() {
		return user;
>>>>>>> origin/master
	}

	@Override
	public void verifyUsernameAjax() {
<<<<<<< HEAD
		verifyUsernameExist();
	}
=======
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		verifyUsernameExist();
	}
	
	private boolean verifyUsernameExist() {
		User existUser = userService.findByUsername(user.getUsername());
		if(existUser==null){
			return true;
		}else{
			print("用户名已被注册");
			return false;
		}
	}
>>>>>>> origin/master

	@Override
	public void exit() {
		ServletActionContext.getRequest().getSession().invalidate();
	}
<<<<<<< HEAD

=======
	
>>>>>>> origin/master
	@Override
	public String findAllUser() {
		pageBean = userService.findAllByPage(getPage());
		return "userList";
	}
<<<<<<< HEAD
=======
	
	private Integer getPage(){
		if(page==null){
			return 1;
		}else{
			return page;
		}
	}
>>>>>>> origin/master

}
