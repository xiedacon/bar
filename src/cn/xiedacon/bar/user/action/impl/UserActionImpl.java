package cn.xiedacon.bar.user.action.impl;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import cn.xiedacon.bar.user.action.UserAction;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.user.service.UserService;
import cn.xiedacon.bar.util.PageBean;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 用户action，无前端页面，全ajax
 * @author xieda
 *
 */
public class UserActionImpl extends ActionSupport implements ModelDriven<User>,UserAction {

	private UserService userService;
	private User user = new User();
	private String repassword;
	private PageBean<User> pageBean;
	private Integer page;
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
	
	/**
	 * 校验密码功能
	 */
	private boolean verifyPassword() {
		String password = user.getPassword();
		return required(password, "密码不能为空")
				&&length(password,5,10,"密码长度应在5~10之间");
	}
	
	/**
	 * 校验二次密码
	 */
	private boolean verifyRepassword() {
		String password = user.getPassword();
		return required(repassword, "二次密码不能为空")
				&&than(password,repassword,"两次输入密码不一致");
	}

	/**
	 * 校验昵称
	 */
	private boolean verifyName() {
		String name = user.getName();
		return required(name, "昵称不能为空")
				&&length(name,0,10,"昵称长度不能超过10");
	}
	
	/**
	 * 校验邮箱
	 */
	private boolean verifyEmail() {
		String email = user.getEmail();
		return required(email, "邮箱不能为空")
				&&email(email,"邮箱格式错误");
	}
	
	//邮箱格式校验
	private String regex = "\\b(^['_A-Za-z0-9-]+(\\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
	private boolean email(String email, String result) {
		if(email.matches(regex)){
			return true;
		}else{
			print(result);
			return false;
		}
	}

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
			print(result);
			return false;
		}
	}
	private void print(String msg){
		try {
			ServletActionContext.getResponse().getWriter().print(msg);
		} catch (IOException e) {
		}
	}

	@Override
	public User getModel() {
		return user;
	}

	@Override
	public void verifyUsernameAjax() {
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

	@Override
	public void exit() {
		ServletActionContext.getRequest().getSession().invalidate();
	}
	
	@Override
	public String findAllUser() {
		pageBean = userService.findAllByPage(getPage());
		return "userList";
	}
	
	private Integer getPage(){
		if(page==null){
			return 1;
		}else{
			return page;
		}
	}

}
