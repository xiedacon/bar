package cn.xiedacon.bar.user.dao;

import java.util.List;

import cn.xiedacon.bar.user.domain.AdminLog;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.user.domain.UserLog;

public interface AdminUserDao {

	void saveUserLog(UserLog userLog);

	int findTotalCountByLastOperation(String operation);

	List<UserLog> findByLastOperationABeginALimt(String operation, int begin, int limit);

	UserLog findUserLogByLastOperationAndId(String operation, Integer id);

	void updateUserLog(UserLog userLog);

	int findTotalCountAll();

	List<UserLog> findByBeginAndLimt(int begin, int limit);

	void removeAdmin(User user);

	void saveAdminLog(AdminLog adminLog);

	List<AdminLog> findAdminLogByBeginAndLimt(int begin, int limit);

	int findAdminLogTotalCount();

}
