package cn.xiedacon.bar.user.service.impl;

<<<<<<< HEAD
import java.util.ArrayList;

=======
>>>>>>> origin/master
import org.springframework.transaction.annotation.Transactional;

import cn.xiedacon.bar.user.dao.AdminUserDao;
import cn.xiedacon.bar.user.dao.UserDao;
import cn.xiedacon.bar.user.domain.AdminLog;
<<<<<<< HEAD
import cn.xiedacon.bar.user.domain.UserLog;
import cn.xiedacon.bar.user.service.AdminUserService;
import cn.xiedacon.bar.util.PageBean;

@Transactional
public class AdminUserServiceImpl implements AdminUserService {

	// 变量区
	private AdminUserDao adminUserDao;
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	// ////////////////////////////////////////////

	// 公共方法区

=======
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.user.domain.UserLog;
import cn.xiedacon.bar.user.service.AdminUserService;
import cn.xiedacon.bar.util.PageBean;
@Transactional
public class AdminUserServiceImpl implements AdminUserService {

	private AdminUserDao adminUserDao;
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}
>>>>>>> origin/master
	@Override
	public void saveUserLog(UserLog userLog) {
		adminUserDao.saveUserLog(userLog);
	}
<<<<<<< HEAD

	@Override
	public UserLog findUserLogByLastOperationAndId(String operation, Integer id) {
		return adminUserDao.findUserLogByLastOperationAndId(operation, id);
	}

=======
	@Override
	public PageBean<UserLog> findLogByLastOperationAndPage(String operation, Integer page) {
		PageBean<UserLog> pageBean = new PageBean<UserLog>();
		int totalCount = adminUserDao.findTotalCountByLastOperation(operation);
		int limit = 10;
		pageBean.setLimit(limit);
		pageBean.setPage(page);
		pageBean.setTotalCount(totalCount);
		int totalPage = totalCount/limit;
		totalPage += totalCount%limit==0?0:1;
		pageBean.setTotalPage(totalPage);
		int begin = (page-1)*limit;
		pageBean.setBeanList(adminUserDao.findByLastOperationABeginALimt(operation,begin,limit));
		return pageBean;
	}
	@Override
	public UserLog findUserLogByLastOperationAndId(String operation, Integer id) {
		return adminUserDao.findUserLogByLastOperationAndId(operation,id);
	}
>>>>>>> origin/master
	@Override
	public void updateUserLog(UserLog userLog) {
		adminUserDao.updateUserLog(userLog);
	}
<<<<<<< HEAD

=======
>>>>>>> origin/master
	@Override
	public PageBean<UserLog> findUserLogAll(Integer page) {
		PageBean<UserLog> pageBean = new PageBean<UserLog>();
		int totalCount = adminUserDao.findTotalCountAll();
		int limit = 10;
		pageBean.setLimit(limit);
		pageBean.setPage(page);
		pageBean.setTotalCount(totalCount);
<<<<<<< HEAD
		int totalPage = totalCount / limit;

		// 总计为0就没有查询的必要了
		if (totalCount == 0) {
			pageBean.setTotalCount(totalCount);
			pageBean.setTotalPage(0);
			pageBean.setBeanList(new ArrayList<UserLog>());
			return pageBean;
		}

		totalPage += totalCount % limit == 0 ? 0 : 1;
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * limit;
		pageBean.setBeanList(adminUserDao.findByBeginAndLimt(begin, limit));
		return pageBean;
	}

=======
		int totalPage = totalCount/limit;
		totalPage += totalCount%limit==0?0:1;
		pageBean.setTotalPage(totalPage);
		int begin = (page-1)*limit;
		pageBean.setBeanList(adminUserDao.findByBeginAndLimt(begin,limit));
		return pageBean;
	}
>>>>>>> origin/master
	@Override
	public void removeAdmin(AdminLog adminLog) {
		adminUserDao.saveAdminLog(adminLog);
		adminUserDao.removeAdmin(adminLog.getAdminUser());
	}
<<<<<<< HEAD

=======
>>>>>>> origin/master
	@Override
	public void saveAdminLog(AdminLog adminLog) {
		adminUserDao.saveAdminLog(adminLog);
		userDao.saveUser(adminLog.getAdminUser());
	}
<<<<<<< HEAD

=======
>>>>>>> origin/master
	@Override
	public PageBean<AdminLog> findAdminLogByPage(Integer page) {
		PageBean<AdminLog> pageBean = new PageBean<AdminLog>();
		int totalCount = adminUserDao.findAdminLogTotalCount();
		int limit = 10;
		pageBean.setLimit(limit);
		pageBean.setPage(page);
		pageBean.setTotalCount(totalCount);
<<<<<<< HEAD
		int totalPage = totalCount / limit;

		// 总计为0就没有查询的必要了
		if (totalCount == 0) {
			pageBean.setTotalCount(totalCount);
			pageBean.setTotalPage(0);
			pageBean.setBeanList(new ArrayList<AdminLog>());
			return pageBean;
		}

		totalPage += totalCount % limit == 0 ? 0 : 1;
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * limit;
		pageBean.setBeanList(adminUserDao.findAdminLogByBeginAndLimt(begin, limit));
		return pageBean;
	}

	@Override
	public PageBean<UserLog> findUserLogByLastOperationAndPage(String operation, Integer page) {
		PageBean<UserLog> pageBean = new PageBean<UserLog>();
		int totalCount = adminUserDao.findTotalCountByLastOperation(operation);
		int limit = 10;
		pageBean.setLimit(limit);
		pageBean.setPage(page);
		pageBean.setTotalCount(totalCount);
		int totalPage = totalCount / limit;

		// 总计为0就没有查询的必要了
		if (totalCount == 0) {
			pageBean.setTotalCount(totalCount);
			pageBean.setTotalPage(0);
			pageBean.setBeanList(new ArrayList<UserLog>());
			return pageBean;
		}

		totalPage += totalCount % limit == 0 ? 0 : 1;
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * limit;
		pageBean.setBeanList(adminUserDao.findByLastOperationABeginALimt(operation, begin, limit));
=======
		int totalPage = totalCount/limit;
		totalPage += totalCount%limit==0?0:1;
		pageBean.setTotalPage(totalPage);
		int begin = (page-1)*limit;
		pageBean.setBeanList(adminUserDao.findAdminLogByBeginAndLimt(begin,limit));
>>>>>>> origin/master
		return pageBean;
	}

}
