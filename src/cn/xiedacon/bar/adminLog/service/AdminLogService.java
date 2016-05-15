package cn.xiedacon.bar.adminLog.service;

import cn.xiedacon.bar.user.domain.AdminLog;
import cn.xiedacon.bar.util.PageBean;

public interface AdminLogService {

	void remove(AdminLog adminLog);

	void save(AdminLog adminLog);

	PageBean<AdminLog> findByPage(Integer page);
	

}
