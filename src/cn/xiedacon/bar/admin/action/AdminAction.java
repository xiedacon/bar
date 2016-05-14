package cn.xiedacon.bar.admin.action;

public interface AdminAction {

	/**
	 * 跳转到后台页面
	 */
	void toBackStage();
	/**
	 * 跳转到前台页面
	 * @return
	 */
	String toStage();
	
}
