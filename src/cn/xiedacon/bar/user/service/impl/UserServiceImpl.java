package cn.xiedacon.bar.user.service.impl;


import java.util.List;

import cn.xiedacon.bar.user.dao.UserDao;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.user.service.UserService;
import cn.xiedacon.bar.util.PageBean;
public class UserServiceImpl implements UserService {

	//变量区
	
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	////////////////////////
	
	//公共方法区
	
	@Override
	public User findByUid(Integer uid){
		return userDao.findByUid(uid);
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public PageBean<User> findByPage(Integer page) {
		PageBean<User> pageBean = new PageBean<User>();
		int totalCount = userDao.findTotalCount();
		int limit = 10;
		pageBean.setLimit(limit);
		pageBean.setPage(page);
		pageBean.setTotalCount(totalCount);
		int totalPage = totalCount/limit;
		totalPage += totalCount%limit==0?0:1;
		pageBean.setTotalPage(totalPage);
		int begin = (page-1)*limit;
		pageBean.setBeanList(userDao.findByBeginAndLimt(begin,limit));
		return pageBean;
	}

	@Override
	public List<User> findByPositionId(Integer id) {
		return userDao.findByPositionId(id);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}
}
