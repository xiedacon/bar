package cn.xiedacon.bar.userLog.dao;

import java.util.List;

import cn.xiedacon.bar.userLog.domain.UserLog;

public interface UserLogDao {

	int findTotalCountByLastOperation(String operation);

	List<UserLog> findByLastOperationABeginALimt(String operation, int begin, int limit);

	List<UserLog> findByBeginAndLimt(int begin, int limit);

	void save(UserLog userLog);

	UserLog findByLastOperationAndId(String operation, Integer id);

	void update(UserLog userLog);

	int findTotalCount();

}
