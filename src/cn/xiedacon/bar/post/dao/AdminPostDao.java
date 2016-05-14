package cn.xiedacon.bar.post.dao;

import java.util.List;
import java.util.Map;

import cn.xiedacon.bar.post.domain.PostLog;

public interface AdminPostDao {

	int findTotalCountByLastOperation(String string);

	List<PostLog> findByLastOperationABeginALimit(String string, int begin, int limit);

	void savePostLog(PostLog postLog);

	PostLog findByIdAndLastOperation(Integer id, String string);

	void updatePostLog(PostLog postLog);

	int findTotalCountAll();

	List<PostLog> findByBeginAndLimit(int begin, int limit);

}
