package cn.xiedacon.bar.adminLog.dao;

import java.util.List;

import cn.xiedacon.bar.user.domain.AdminLog;
import cn.xiedacon.bar.user.domain.User;

public interface AdminLogDao {

	void removeAdmin(User user);
	
	void save(AdminLog adminLog);

	int findTotalCount();

	List<AdminLog> findByBeginAndLimt(int begin, int limit);
}
