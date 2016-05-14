package cn.xiedacon.bar.user.service;

<<<<<<< HEAD

import cn.xiedacon.bar.user.domain.AdminLog;
=======
import java.util.List;

import cn.xiedacon.bar.user.domain.AdminLog;
import cn.xiedacon.bar.user.domain.User;
>>>>>>> origin/master
import cn.xiedacon.bar.user.domain.UserLog;
import cn.xiedacon.bar.util.PageBean;

public interface AdminUserService {

	void saveUserLog(UserLog userLog);

<<<<<<< HEAD
=======
	PageBean<UserLog> findLogByLastOperationAndPage(String operation, Integer page);

>>>>>>> origin/master
	UserLog findUserLogByLastOperationAndId(String operation, Integer id);

	void updateUserLog(UserLog userLog);

	PageBean<UserLog> findUserLogAll(Integer page);

	void removeAdmin(AdminLog adminLog);

	void saveAdminLog(AdminLog adminLog);

	PageBean<AdminLog> findAdminLogByPage(Integer page);

<<<<<<< HEAD
	PageBean<UserLog> findUserLogByLastOperationAndPage(String operation, Integer page);

=======
>>>>>>> origin/master

}
