package cn.xiedacon.bar.post.service;

import cn.xiedacon.bar.post.domain.PostLog;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.util.PageBean;

public interface AdminPostService {

	void updatePostOperationLog(PostLog postLog);

	void savePostLog(PostLog postLog);

	PageBean<PostLog> findPostLogByLastOperationAndPage(String lastOperation, Integer page);

	PageBean<PostLog> findPostLogByPage(Integer page);

	PostLog findPostLogByLastOperationAndId(String lastOperation, Integer id);

	PageBean<PostLog> findAppealLogByAppealProcessAndAppealUser(boolean appealProcess, User appealUser);

	PageBean<PostLog> findAppealLogByAppealProcessAndPage(boolean appealProcess, Integer page);

	PageBean<PostLog> findPostLogByLastOperatorAndInterval(User user, Integer interval);

	PageBean<PostLog> findPostLogByFirstOperatorAndInterval(User user, Integer interval);

	PageBean<PostLog> findPostLogByLastOperationAFirstOperatorAInterval(String lastOperation, User user, Integer interval);

	PageBean<PostLog> findPostLogByLastOperationALastOperatorAInterval(String lastOperation, User user, Integer interval);



}
