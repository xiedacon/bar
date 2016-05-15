package cn.xiedacon.bar.post.service.impl;


import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import cn.xiedacon.bar.post.dao.AdminPostDao;
import cn.xiedacon.bar.post.domain.PostLog;
import cn.xiedacon.bar.post.service.AdminPostService;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.util.PageBean;

@Transactional
public class AdminPostServiceImpl implements AdminPostService {

	//变量区
	private AdminPostDao adminPostDao;

	public void setAdminPostDao(AdminPostDao adminPostDao) {
		this.adminPostDao = adminPostDao;
	}

	///////////////////////////////////////////
	
	//公共方法区
	
	@Override
	public PageBean<PostLog> findPostLogByPage(Integer page) {
		PageBean<PostLog> pageBean = new PageBean<PostLog>();
		int limit = 10;
		pageBean.setLimit(limit);
		pageBean.setPage(page);
		int totalCount = adminPostDao.findTotalCount();
		
		//总计为0就没有查询的必要了
		if(totalCount == 0){
			pageBean.setTotalCount(totalCount);
			pageBean.setTotalPage(0);
			pageBean.setBeanList(new ArrayList<PostLog>());
			return pageBean;
		}
		
		pageBean.setTotalCount(totalCount);
		int totalPage = totalCount/limit;
		totalPage += totalCount%limit==0?0:1;
		pageBean.setTotalPage(totalPage);
		int begin = (page-1)*limit;
		pageBean.setBeanList(adminPostDao.findPostLogByBeginAndLimit(begin, limit));
		return pageBean;
	}

	@Override
	public void updatePostOperationLog(PostLog postLog) {
		adminPostDao.updatePostLog(postLog);
	}

	@Override
	public void savePostLog(PostLog postLog) {
		adminPostDao.savePostLog(postLog);
	}

	@Override
	public PageBean<PostLog> findPostLogByLastOperationAndPage(String lastOperation, Integer page) {
		PageBean<PostLog> pageBean = new PageBean<PostLog>();
		int limit = 10;
		pageBean.setLimit(limit);
		pageBean.setPage(page);
		int totalCount = adminPostDao.findTotalCountByLastOperation(lastOperation);
		pageBean.setTotalCount(totalCount);
		int totalPage = totalCount/limit;
		
		//总计为0就没有查询的必要了
		if(totalCount == 0){
			pageBean.setTotalCount(totalCount);
			pageBean.setTotalPage(0);
			pageBean.setBeanList(new ArrayList<PostLog>());
			return pageBean;
		}
		
		totalPage += totalCount%limit==0?0:1;
		pageBean.setTotalPage(totalPage);
		int begin = (page-1)*limit;
		pageBean.setBeanList(adminPostDao.findPostLogByLastOperationABeginALimit(lastOperation, begin, limit));
		return pageBean;
	}

	@Override
	public PostLog findPostLogByLastOperationAndId(String lastOperation, Integer id) {
		return adminPostDao.findPostLogByLastOperationAndId(lastOperation,id);
	}

	@Override
	public PageBean<PostLog> findAppealLogByAppealProcessAndAppealUser(boolean appealProcess, User appealUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<PostLog> findAppealLogByAppealProcessAndPage(boolean appealProcess, Integer page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<PostLog> findPostLogByLastOperatorAndInterval(User user, Integer interval) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<PostLog> findPostLogByFirstOperatorAndInterval(User user, Integer interval) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<PostLog> findPostLogByLastOperationAFirstOperatorAInterval(String lastOperation, User user, Integer interval) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<PostLog> findPostLogByLastOperationALastOperatorAInterval(String lastOperation, User user, Integer interval) {
		// TODO Auto-generated method stub
		return null;
	}

}
