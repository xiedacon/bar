package cn.xiedacon.bar.user.service;

import java.util.List;

import cn.xiedacon.bar.user.domain.AdminLog;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.user.domain.UserLog;
import cn.xiedacon.bar.util.PageBean;

public interface AdminUserService {

	void saveUserLog(UserLog userLog);

	PageBean<UserLog> findLogByLastOperationAndPage(String operation, Integer page);

	UserLog findUserLogByLastOperationAndId(String operation, Integer id);

	void updateUserLog(UserLog userLog);

	PageBean<UserLog> findUserLogAll(Integer page);

	void removeAdmin(AdminLog adminLog);

	void saveAdminLog(AdminLog adminLog);

	PageBean<AdminLog> findAdminLogByPage(Integer page);


}
