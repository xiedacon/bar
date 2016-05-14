package cn.xiedacon.bar.user.service.impl;


import java.util.List;

import cn.xiedacon.bar.user.dao.UserDao;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.user.service.UserService;
import cn.xiedacon.bar.util.PageBean;
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public User findByUid(Integer uid){
		return userDao.findByUid(uid);
	}

	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public void regist(User user) {
		userDao.saveUser(user);
	}

	@Override
	public PageBean<User> findAllByPage(Integer page) {
		PageBean<User> pageBean = new PageBean<User>();
		int totalCount = userDao.findTotalCountAll();
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
	public List<User> findAdminAll() {
		return userDao.findByPosition(2);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
}
