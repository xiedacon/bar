package cn.xiedacon.bar.postLog.service;

import cn.xiedacon.bar.postLog.domain.PostLog;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.util.PageBean;

public interface PostLogService {

	PageBean<PostLog> findAppealLogByAppealProcessAndAppealUser(boolean appealProcess, User appealUser);

	PageBean<PostLog> findAppealLogByAppealProcessAndPage(boolean appealProcess, Integer page);

	PageBean<PostLog> findByLastOperationAndPage(String lastOperation, Integer page);

	PageBean<PostLog> findByPage(Integer page);

	PostLog findByLastOperationAndId(String lastOperation, Integer id);

	void update(PostLog postLog);

	void save(PostLog postLog);

	PageBean<PostLog> findByFirstOperatorAndInterval(User user, Integer interval);

	PageBean<PostLog> findByLastOperatorAndInterval(User user, Integer interval);

	PageBean<PostLog> findByLastOperationAFirstOperatorAInterval(String string, User user, Integer interval);

	PageBean<PostLog> findByLastOperationALastOperatorAInterval(String lastOperation, User lastOperator, Integer interval);



}
