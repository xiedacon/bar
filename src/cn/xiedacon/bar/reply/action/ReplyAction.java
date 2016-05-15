package cn.xiedacon.bar.reply.action;

public interface ReplyAction {

	/**
	 * 按楼层分页查找回复
	 */
	void findByFidAndPage();
	/**
	 * 创建回复
	 */
	void createReply();
}
