package cn.xiedacon.bar.post.service.impl;


import org.springframework.transaction.annotation.Transactional;

import cn.xiedacon.bar.post.dao.AdminPostDao;
import cn.xiedacon.bar.post.domain.PostLog;
import cn.xiedacon.bar.post.domain.PostOperationLog;
import cn.xiedacon.bar.post.service.AdminPostService;
import cn.xiedacon.bar.user.dao.UserDao;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.util.PageBean;

@Transactional
public class AdminPostServiceImpl implements AdminPostService {

	private AdminPostDao adminPostDao;

	public void setAdminPostDao(AdminPostDao adminPostDao) {
		this.adminPostDao = adminPostDao;
	}

	@Override
	public PageBean<PostLog> findUnRecoverDeleteLogByPage(Integer page) {
		PageBean<PostLog> pageBean = new PageBean<PostLog>();
		int limit = 10;
		pageBean.setLimit(limit);
		pageBean.setPage(page);
		int totalCount = adminPostDao.findTotalCountByLastOperation("delete");
		pageBean.setTotalCount(totalCount);
		int totalPage = totalCount/limit;
		totalPage += totalCount%limit==0?0:1;
		pageBean.setTotalPage(totalPage);
		int begin = (page-1)*limit;
		pageBean.setBeanList(adminPostDao.findByLastOperationABeginALimit("delete", begin, limit));
		return pageBean;
	}

	@Override
	public PageBean<PostLog> findAllLogByPage(Integer page) {
		PageBean<PostLog> pageBean = new PageBean<PostLog>();
		int limit = 10;
		pageBean.setLimit(limit);
		pageBean.setPage(page);
		int totalCount = adminPostDao.findTotalCountAll();
		pageBean.setTotalCount(totalCount);
		int totalPage = totalCount/limit;
		totalPage += totalCount%limit==0?0:1;
		pageBean.setTotalPage(totalPage);
		int begin = (page-1)*limit;
		pageBean.setBeanList(adminPostDao.findByBeginAndLimit(begin, limit));
		return pageBean;
	}

	@Override
	public PostLog findUnRecoverDeleteLogById(Integer id) {
		return adminPostDao.findByIdAndLastOperation(id,"delete");
	}

	@Override
	public void updatePostOperationLog(PostLog postLog) {
		adminPostDao.updatePostLog(postLog);
	}

	@Override
	public PageBean<PostLog> findUnprocessAppealLogByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<PostLog> findProcessedAppealLogByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<PostLog> findUnprocessAppealLogAllByPage(Integer page) {
		PageBean<PostLog> pageBean = new PageBean<PostLog>();
		int totalCount = adminPostDao.findTotalCountByLastOperation("appeal");
		int limit = 10;
		pageBean.setLimit(limit);
		pageBean.setPage(page);
		pageBean.setTotalCount(totalCount);
		int totalPage = totalCount/limit;
		totalPage += totalCount%limit==0?0:1;
		pageBean.setTotalPage(totalPage);
		int begin = (page-1)*limit;
		pageBean.setBeanList(adminPostDao.findByLastOperationABeginALimit("appeal", begin, limit));
		return pageBean;
	}

	@Override
	public PageBean<PostLog> findProcessedAppealLogAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<PostLog> findLogByFirstOperatorAndInterval(String username, Integer interval) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<PostLog> findLogByLastOperatorAndInterval(String username, Integer interval) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<PostLog> findUnRecoverDeleteLogByFirstOperatorAInterval(String username, Integer interval) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<PostLog> findUnRecoverDeleteLogByLastOperatorAInterval(String username, Integer interval) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void savePostLog(PostLog postLog) {
		adminPostDao.savePostLog(postLog);
	}

}
