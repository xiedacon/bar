package cn.xiedacon.bar.post.service.impl;


import java.util.ArrayList;
import java.util.List;

import cn.xiedacon.bar.post.dao.PostDao;
import cn.xiedacon.bar.post.domain.Post;
import cn.xiedacon.bar.post.service.PostService;
import cn.xiedacon.bar.user.dao.UserDao;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.util.PageBean;

/**
 * 帖子Service层
 * @author xieda
 *
 */
public class PostServiceImpl implements PostService {

	private PostDao postDao;
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	
	@Override
	public PageBean<Post> findByPage(Integer page){
		PageBean<Post> pageBean = new PageBean<Post>();
		int limit = 10;
		pageBean.setLimit(limit);
		pageBean.setPage(page);
		int totalCount = postDao.findTotalCount();
		
		//总计为0就没有查询的必要了
		if(totalCount == 0){
			pageBean.setTotalCount(totalCount);
			pageBean.setTotalPage(0);
			pageBean.setBeanList(new ArrayList<Post>());
			return pageBean;
		}
		
		pageBean.setTotalCount(totalCount);
		int totalPage = totalCount/limit + (totalCount%limit==0?0:1);
		pageBean.setTotalPage(totalPage);
		int begin = (page-1)*limit;
		List<Post> beans = postDao.findByLimit(begin, limit);
		pageBean.setBeanList(beans);
		return pageBean;
	}

	@Override
	public PageBean<Post> boutique(Integer page) {
		PageBean<Post> pageBean = new PageBean<Post>();
		int limit = 10;
		pageBean.setLimit(limit);
		pageBean.setPage(page);
		int totalCount = postDao.findTotalCountByStatus(3);
		
		//总计为0就没有查询的必要了
		if(totalCount == 0){
			pageBean.setTotalCount(totalCount);
			pageBean.setTotalPage(0);
			pageBean.setBeanList(new ArrayList<Post>());
			return pageBean;
		}
		
		pageBean.setTotalCount(totalCount);
		int totalPage = totalCount/limit + (totalCount%limit==0?0:1);
		pageBean.setTotalPage(totalPage);
		int begin = (page-1)*limit;
		List<Post> beans = postDao.findByLimitAndStatus(begin, limit,3);
		pageBean.setBeanList(beans);
		return pageBean;
	}

	@Override
	public Post findByPid(String pid) {
		return postDao.findByPid(pid);
	}

	@Override
	public void createPost(Post post) {
		postDao.createPost(post);
	}

	@Override
	public List<Post> findDeletePostsByOwner(User owner) {
		return postDao.findByOuidAndStatus(owner.getUid(),2);
	}

}
