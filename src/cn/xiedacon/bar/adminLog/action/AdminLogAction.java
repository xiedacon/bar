package cn.xiedacon.bar.adminLog.action;

public interface AdminLogAction {

	/**
	 * 查看所有吧务
	 * @return
	 */
	String findAdminAll();
	/**
	 * 添加吧务
	 * @return
	 */
	String addAdmin();
	/**
	 * 移除吧务
	 * @return
	 */
	String removeAdmin();
	/**
	 * 查看所有吧务管理记录
	 * @return
	 */
	String findAdminLog();

}
