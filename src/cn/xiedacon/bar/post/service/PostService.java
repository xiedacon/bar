package cn.xiedacon.bar.post.service;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.xiedacon.bar.post.domain.Post;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.util.PageBean;
@Transactional
public interface PostService {

	PageBean<Post> findByPage(Integer page);
	PageBean<Post> findByStatusAndPage(Integer status,Integer page);
	Post findByPid(String pid);
	void createPost(Post post);
	List<Post> findDeletePostsByOwner(User owner);
	List<Post> findPostsByStatusAndOwner(Integer status, User user);
}
