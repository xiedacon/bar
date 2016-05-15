package cn.xiedacon.bar.post.dao;

import java.util.List;

import cn.xiedacon.bar.post.domain.Post;

public interface PostDao {

	Integer findTotalCount();
	Integer findTotalCountByStatus(Integer sid);
	Post findByPid(String pid);
	void createPost(Post post);
	List<Post> findByOuidAndStatus(Integer uid, Integer status);
	List<Post> findByStatusABeginALimit(Integer status, int begin, int limit);
	List<Post> findByBeginAndLimit(int begin, int limit);
}
