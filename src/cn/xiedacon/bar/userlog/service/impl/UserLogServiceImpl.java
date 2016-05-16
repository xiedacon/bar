package cn.xiedacon.bar.userLog.service.impl;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import cn.xiedacon.bar.userLog.dao.UserLogDao;
import cn.xiedacon.bar.userLog.domain.UserLog;
import cn.xiedacon.bar.userLog.service.UserLogService;
import cn.xiedacon.bar.util.PageBean;

@Transactional
public class UserLogServiceImpl implements UserLogService {

	// 变量区
	private UserLogDao userLogDao;

	public void setUserLogDao(UserLogDao userLogDao) {
		this.userLogDao = userLogDao;
	}

	// ////////////////////////////////////////////

	// 公共方法区

	@Override
	public void save(UserLog userLog) {
		userLogDao.save(userLog);
	}

	@Override
	public UserLog findByLastOperationAndId(String operation, Integer id) {
		return userLogDao.findByLastOperationAndId(operation, id);
	}

	@Override
	public void update(UserLog userLog) {
		userLogDao.update(userLog);
	}

	@Override
	public PageBean<UserLog> findByPage(Integer page) {
		PageBean<UserLog> pageBean = new PageBean<UserLog>();
		int totalCount = userLogDao.findTotalCount();
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
		pageBean.setBeanList(userLogDao.findByBeginAndLimt(begin, limit));
		return pageBean;
	}

	@Override
	public PageBean<UserLog> findByLastOperationAndPage(String operation, Integer page) {
		PageBean<UserLog> pageBean = new PageBean<UserLog>();
		int totalCount = userLogDao.findTotalCountByLastOperation(operation);
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
		pageBean.setBeanList(userLogDao.findByLastOperationABeginALimt(operation, begin, limit));
		return pageBean;
	}

}
