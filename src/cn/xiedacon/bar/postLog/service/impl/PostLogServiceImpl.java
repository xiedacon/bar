package cn.xiedacon.bar.postLog.service.impl;


import java.util.ArrayList;


import org.springframework.transaction.annotation.Transactional;

import cn.xiedacon.bar.postLog.dao.PostLogDao;
import cn.xiedacon.bar.postLog.domain.PostLog;
import cn.xiedacon.bar.postLog.service.PostLogService;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.util.PageBean;

@Transactional
public class PostLogServiceImpl implements PostLogService {

	//变量区
	private PostLogDao postLogDao;

	public void setPostLogDao(PostLogDao postLogDao) {
		this.postLogDao = postLogDao;
	}

	///////////////////////////////////////////
	
	//公共方法区
	
	@Override
	public PageBean<PostLog> findByPage(Integer page) {
		PageBean<PostLog> pageBean = new PageBean<PostLog>();
		int limit = 10;
		pageBean.setLimit(limit);
		pageBean.setPage(page);
		int totalCount = postLogDao.findTotalCount();
		
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
		pageBean.setBeanList(postLogDao.findByBeginAndLimit(begin, limit));
		return pageBean;
	}

	@Override
	public void update(PostLog postLog) {
		postLogDao.update(postLog);
	}

	@Override
	public void save(PostLog postLog) {
		postLogDao.save(postLog);
	}

	@Override
	public PageBean<PostLog> findByLastOperationAndPage(String lastOperation, Integer page) {
		PageBean<PostLog> pageBean = new PageBean<PostLog>();
		int limit = 10;
		pageBean.setLimit(limit);
		pageBean.setPage(page);
		int totalCount = postLogDao.findTotalCountByLastOperation(lastOperation);
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
		pageBean.setBeanList(postLogDao.findByLastOperationABeginALimit(lastOperation, begin, limit));
		return pageBean;
	}

	@Override
	public PostLog findByLastOperationAndId(String lastOperation, Integer id) {
		return postLogDao.findByLastOperationAndId(lastOperation,id);
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
	public PageBean<PostLog> findByLastOperatorAndInterval(User user, Integer interval) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<PostLog> findByFirstOperatorAndInterval(User user, Integer interval) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<PostLog> findByLastOperationAFirstOperatorAInterval(String lastOperation, User user, Integer interval) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<PostLog> findByLastOperationALastOperatorAInterval(String lastOperation, User user, Integer interval) {
		// TODO Auto-generated method stub
		return null;
	}

}
