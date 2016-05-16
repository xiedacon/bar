package cn.xiedacon.bar.adminLog.service.impl;

import java.util.ArrayList;

import cn.xiedacon.bar.adminLog.dao.AdminLogDao;
import cn.xiedacon.bar.adminLog.domain.AdminLog;
import cn.xiedacon.bar.adminLog.service.AdminLogService;
import cn.xiedacon.bar.user.dao.UserDao;
import cn.xiedacon.bar.util.PageBean;

public class AdminLogServiceImpl implements AdminLogService {

	//变量区
	private UserDao userDao;
	private AdminLogDao adminLogDao;
	
	public void setAdminLogDao(AdminLogDao adminLogDao) {
		this.adminLogDao = adminLogDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	////////////////////////////////////////////////
	
	//公共方法区
	
	@Override
	public void remove(AdminLog adminLog) {
		adminLogDao.save(adminLog);
		adminLogDao.removeAdmin(adminLog.getAdminUser());
	}

	@Override
	public void save(AdminLog adminLog) {
		adminLogDao.save(adminLog);
		userDao.update(adminLog.getAdminUser());
	}
	
	@Override
	public PageBean<AdminLog> findByPage(Integer page) {
		PageBean<AdminLog> pageBean = new PageBean<AdminLog>();
		int totalCount = adminLogDao.findTotalCount();
		int limit = 10;
		pageBean.setLimit(limit);
		pageBean.setPage(page);
		pageBean.setTotalCount(totalCount);
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
		pageBean.setBeanList(adminLogDao.findByBeginAndLimt(begin, limit));
		return pageBean;
	}
}
