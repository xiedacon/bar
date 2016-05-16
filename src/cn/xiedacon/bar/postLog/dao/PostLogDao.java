package cn.xiedacon.bar.postLog.dao;

import java.util.List;

import cn.xiedacon.bar.postLog.domain.PostLog;


public interface PostLogDao {

	int findTotalCountByLastOperation(String lastOperation);

	int findTotalCount();

	List<PostLog> findByBeginAndLimit(int begin, int limit);

	void update(PostLog postLog);

	void save(PostLog postLog);

	List<PostLog> findByLastOperationABeginALimit(String lastOperation, int begin, int limit);

	PostLog findByLastOperationAndId(String lastOperation, Integer id);

}
