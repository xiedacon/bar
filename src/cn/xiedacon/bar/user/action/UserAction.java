package cn.xiedacon.bar.user.action;


public interface UserAction {

	void login();
	void verifyUsernameAjax();
	void regist();
	void exit();
	/**
	 * 查看所有会员
	 * @return
	 */
	String findAllUser();
}
