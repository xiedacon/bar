package cn.xiedacon.bar.userlog.service;


import cn.xiedacon.bar.userlog.domain.UserLog;
import cn.xiedacon.bar.util.PageBean;

public interface UserLogService {

	void save(UserLog userLog);

	PageBean<UserLog> findByLastOperationAndPage(String operation, Integer page);

	UserLog findByLastOperationAndId(String operation, Integer id);

	void update(UserLog userLog);

	PageBean<UserLog> findByPage(Integer page);


}
