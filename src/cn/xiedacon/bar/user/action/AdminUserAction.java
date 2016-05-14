package cn.xiedacon.bar.user.action;

public interface AdminUserAction {


	/**
	 * 封禁会员
	 * @return
	 */
	String forbiddenUser();
	/**
	 * 将会员加入黑名单
	 * @return
	 */
	String addToBlackList();
	/**
	 * 按用户名搜索会员
	 * @return
	 */
	String findUserByUsername();
	/**
	 * 查看未恢复封禁记录
	 * @return
	 */
	String findUnrecoverForbiddenLog();
	/**
	 * 解除封禁
	 * @return
	 */
	String removeForbiddenLog();
	/**
	 * 按用户名搜索未恢复封禁记录
	 * @return
	 */
	String findUnrecoverForbiddenLogByUsername();
	/**
	 * 查看未恢复黑名单记录
	 * @return
	 */
	String findUnrecoverBlackListLog();
	/**
	 * 移除黑名单
	 * @return
	 */
	String removeBlackListLog();
	/**
	 * 按用户名搜索未恢复黑名单记录
	 * @return
	 */
	String findUnrecoverBlackListLogByUsername();
	/**
	 * 处理用户申诉
	 * @return
	 */
	String processAppeal();
	/**
	 * 查看未处理申诉记录
	 * @return
	 */
	String findUnprocessAppealLog();
	/**
	 * 查看已处理申诉记录
	 * @return
	 */
	String findProcessedAppealLog();
	/**
	 * 按用户名搜索未处理申诉记录
	 * @return
	 */
	String findUnprocessAppealLogByUsername();
	/**
	 * 按用户名搜索已处理申诉记录
	 * @return
	 */
	String findProcessedAppealLogByUsername();
	/**
	 * 按用户名搜索全部记录
	 * @return
	 */
	String findAllLogByUsername();
	/**
	 * 查看所有记录
	 * @return
	 */
	String findAllLog();
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
