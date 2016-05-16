package cn.xiedacon.bar.postLog.action;


public interface PostLogAction {

	/**
	 * 查看删除且未恢复记录
	 * 返回值：PageBean<PostLog>
	 * @return
	 */
	String findUnRecoverDeleteLog();
	
	/**
	 * 查看所有记录
	 * 返回值：PageBean<PostLog>
	 * @return
	 */
	String findAllLog();
	
	/**
	 * 恢复帖子
	 */
	String recoverPost();
	
	/**
	 * 搜索未处理申诉记录（申诉用户）
	 * 返回值：PageBean<PostAppealLog>
	 * @return
	 */
	String findUnprocessAppealLogByUsername();
	
	/**
	 * 搜索已处理申诉记录（申诉用户）
	 * 返回值：PageBean<PostAppealLog>
	 * @return
	 */
	String findProcessedAppealLogByUsername();
	
	/**
	 * 查看未处理申诉记录
	 * 返回值：PageBean<PostAppealLog>
	 * @return
	 */
	String findUnprocessAppealLogAll();
	
	/**
	 * 查看已处理申诉记录
	 * 返回值：PageBean<PostAppealLog>
	 * @return
	 */
	String findProcessedAppealLogAll();
	
	/**
	 * 开始处理
	 * @return
	 */
	//processAppeal();
	
	/**
	 * 按发帖人搜索所有（操作时间）
	 * 返回值：PageBean<PostLog>
	 * @return
	 */
	String findLogByFirstOperatorAndInterval();
	
	/**
	 * 按操作人搜索所有（操作时间）
	 * 返回值：PageBean<PostLog>
	 * @return
	 */
	String findLogByLastOperatorAndInterval();
	
	/**
	 * 按发帖人搜索删除且未处理帖子（操作时间）
	 * 返回值：PageBean<PostLog>
	 * @return
	 */
	String findUnRecoverDeleteLogByFirstOperatorAInterval();
	
	/**
	 * 按操作人搜索删除且未处理帖子（操作时间）
	 * 返回值：PageBean<PostLog>
	 * @return
	 */
	String findUnRecoverDeleteLogByLastOperatorAInterval();

	/**
	 * 删除帖子
	 * @return
	 */
	String deletePost();

}
