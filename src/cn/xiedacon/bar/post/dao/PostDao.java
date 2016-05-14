package cn.xiedacon.bar.post.dao;

import java.util.List;

import cn.xiedacon.bar.post.domain.Post;

public interface PostDao {

	List<Post> findByLimit(Integer begin,Integer limit);
	Integer findTotalCount();
	Integer findTotalCountByStatus(Integer sid);
	List<Post> findByLimitAndStatus(Integer begin,Integer limit,Integer sid);
	Post findByPid(String pid);
	void createPost(Post post);
	List<Post> findByOuidAndStatus(Integer uid, Integer status);
}
