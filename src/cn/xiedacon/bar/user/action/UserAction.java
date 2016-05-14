package cn.xiedacon.bar.user.action;


public interface UserAction {

<<<<<<< HEAD
	/**
	 * 登陆
	 */
	void login();
	/**
	 * ajax校验用户名
	 */
	void verifyUsernameAjax();
	/**
	 * 注册
	 */
	void regist();
	/**
	 * 退出
	 */
=======
	void login();
	void verifyUsernameAjax();
	void regist();
>>>>>>> origin/master
	void exit();
	/**
	 * 查看所有会员
	 * @return
	 */
	String findAllUser();
}
