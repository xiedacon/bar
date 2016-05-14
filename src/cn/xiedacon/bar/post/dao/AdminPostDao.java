package cn.xiedacon.bar.post.dao;

import java.util.List;
<<<<<<< HEAD
=======
import java.util.Map;
>>>>>>> origin/master

import cn.xiedacon.bar.post.domain.PostLog;

public interface AdminPostDao {

<<<<<<< HEAD
	int findTotalCountByLastOperation(String lastOperation);

	void savePostLog(PostLog postLog);

	void updatePostLog(PostLog postLog);

	List<PostLog> findPostLogByLastOperationABeginALimit(String lastOperation, int begin, int limit);

	int findTotalCount();

	List<PostLog> findPostLogByBeginAndLimit(int begin, int limit);

	PostLog findPostLogByLastOperationAndId(String lastOperation, Integer id);
=======
	int findTotalCountByLastOperation(String string);

	List<PostLog> findByLastOperationABeginALimit(String string, int begin, int limit);

	void savePostLog(PostLog postLog);

	PostLog findByIdAndLastOperation(Integer id, String string);

	void updatePostLog(PostLog postLog);

	int findTotalCountAll();

	List<PostLog> findByBeginAndLimit(int begin, int limit);
>>>>>>> origin/master

}
