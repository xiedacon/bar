package cn.xiedacon.bar.post.dao;

import java.util.List;

import cn.xiedacon.bar.post.domain.PostLog;

public interface AdminPostDao {

	int findTotalCountByLastOperation(String lastOperation);

	void savePostLog(PostLog postLog);

	void updatePostLog(PostLog postLog);

	List<PostLog> findPostLogByLastOperationABeginALimit(String lastOperation, int begin, int limit);

	int findTotalCount();

	List<PostLog> findPostLogByBeginAndLimit(int begin, int limit);

	PostLog findPostLogByLastOperationAndId(String lastOperation, Integer id);

}
