package cn.xiedacon.bar.post.service.impl;

<<<<<<< HEAD
=======

>>>>>>> origin/master
import java.util.ArrayList;
import java.util.List;

import cn.xiedacon.bar.post.dao.PostDao;
import cn.xiedacon.bar.post.domain.Post;
import cn.xiedacon.bar.post.service.PostService;
<<<<<<< HEAD
=======
import cn.xiedacon.bar.user.dao.UserDao;
>>>>>>> origin/master
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.util.PageBean;

/**
 * 帖子Service层
<<<<<<< HEAD
 * 
 * @author xieda
 * 
 */
public class PostServiceImpl implements PostService {

	// 变量区

	private PostDao postDao;
=======
 * @author xieda
 *
 */
public class PostServiceImpl implements PostService {

	private PostDao postDao;
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
>>>>>>> origin/master

	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
<<<<<<< HEAD

	// //////////////////////////////////////////////////

	// 公共方法区

	@Override
	public PageBean<Post> findByPage(Integer page) {
=======
	
	@Override
	public PageBean<Post> findByPage(Integer page){
>>>>>>> origin/master
		PageBean<Post> pageBean = new PageBean<Post>();
		int limit = 10;
		pageBean.setLimit(limit);
		pageBean.setPage(page);
		int totalCount = postDao.findTotalCount();
<<<<<<< HEAD

		// 总计为0就没有查询的必要了
		if (totalCount == 0) {
=======
		
		//总计为0就没有查询的必要了
		if(totalCount == 0){
>>>>>>> origin/master
			pageBean.setTotalCount(totalCount);
			pageBean.setTotalPage(0);
			pageBean.setBeanList(new ArrayList<Post>());
			return pageBean;
		}
<<<<<<< HEAD

		pageBean.setTotalCount(totalCount);
		int totalPage = totalCount / limit + (totalCount % limit == 0 ? 0 : 1);
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * limit;
		List<Post> beans = postDao.findByBeginAndLimit(begin, limit);
=======
		
		pageBean.setTotalCount(totalCount);
		int totalPage = totalCount/limit + (totalCount%limit==0?0:1);
		pageBean.setTotalPage(totalPage);
		int begin = (page-1)*limit;
		List<Post> beans = postDao.findByLimit(begin, limit);
>>>>>>> origin/master
		pageBean.setBeanList(beans);
		return pageBean;
	}

	@Override
<<<<<<< HEAD
	public Post findByPid(String pid) {
		return postDao.findByPid(pid);
	}

	@Override
	public void createPost(Post post) {
		postDao.createPost(post);
	}

	@Override
	public List<Post> findDeletePostsByOwner(User owner) {
		return postDao.findByOuidAndStatus(owner.getUid(), 2);
	}

	@Override
	public PageBean<Post> findByStatusAndPage(Integer status, Integer page) {
=======
	public PageBean<Post> boutique(Integer page) {
>>>>>>> origin/master
		PageBean<Post> pageBean = new PageBean<Post>();
		int limit = 10;
		pageBean.setLimit(limit);
		pageBean.setPage(page);
<<<<<<< HEAD
		int totalCount = postDao.findTotalCountByStatus(status);

		// 总计为0就没有查询的必要了
		if (totalCount == 0) {
=======
		int totalCount = postDao.findTotalCountByStatus(3);
		
		//总计为0就没有查询的必要了
		if(totalCount == 0){
>>>>>>> origin/master
			pageBean.setTotalCount(totalCount);
			pageBean.setTotalPage(0);
			pageBean.setBeanList(new ArrayList<Post>());
			return pageBean;
		}
<<<<<<< HEAD

		pageBean.setTotalCount(totalCount);
		int totalPage = totalCount / limit + (totalCount % limit == 0 ? 0 : 1);
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * limit;
		List<Post> beans = postDao.findByStatusABeginALimit(status, begin, limit);
=======
		
		pageBean.setTotalCount(totalCount);
		int totalPage = totalCount/limit + (totalCount%limit==0?0:1);
		pageBean.setTotalPage(totalPage);
		int begin = (page-1)*limit;
		List<Post> beans = postDao.findByLimitAndStatus(begin, limit,3);
>>>>>>> origin/master
		pageBean.setBeanList(beans);
		return pageBean;
	}

	@Override
<<<<<<< HEAD
	public List<Post> findByStatusAndOwner(Integer status, User user) {
		// TODO Auto-generated method stub
		return null;
=======
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
>>>>>>> origin/master
	}

}
