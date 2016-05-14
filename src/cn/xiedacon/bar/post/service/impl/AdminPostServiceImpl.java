package cn.xiedacon.bar.post.service.impl;


<<<<<<< HEAD
import java.util.ArrayList;

=======
>>>>>>> origin/master
import org.springframework.transaction.annotation.Transactional;

import cn.xiedacon.bar.post.dao.AdminPostDao;
import cn.xiedacon.bar.post.domain.PostLog;
<<<<<<< HEAD
import cn.xiedacon.bar.post.service.AdminPostService;
=======
import cn.xiedacon.bar.post.domain.PostOperationLog;
import cn.xiedacon.bar.post.service.AdminPostService;
import cn.xiedacon.bar.user.dao.UserDao;
>>>>>>> origin/master
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.util.PageBean;

@Transactional
public class AdminPostServiceImpl implements AdminPostService {

<<<<<<< HEAD
	//变量区
=======
>>>>>>> origin/master
	private AdminPostDao adminPostDao;

	public void setAdminPostDao(AdminPostDao adminPostDao) {
		this.adminPostDao = adminPostDao;
	}

<<<<<<< HEAD
	///////////////////////////////////////////
	
	//公共方法区
	
	@Override
	public PageBean<PostLog> findPostLogByPage(Integer page) {
=======
	@Override
	public PageBean<PostLog> findUnRecoverDeleteLogByPage(Integer page) {
>>>>>>> origin/master
		PageBean<PostLog> pageBean = new PageBean<PostLog>();
		int limit = 10;
		pageBean.setLimit(limit);
		pageBean.setPage(page);
<<<<<<< HEAD
		int totalCount = adminPostDao.findTotalCount();
		
		//总计为0就没有查询的必要了
		if(totalCount == 0){
			pageBean.setTotalCount(totalCount);
			pageBean.setTotalPage(0);
			pageBean.setBeanList(new ArrayList<PostLog>());
			return pageBean;
		}
		
=======
		int totalCount = adminPostDao.findTotalCountByLastOperation("delete");
>>>>>>> origin/master
		pageBean.setTotalCount(totalCount);
		int totalPage = totalCount/limit;
		totalPage += totalCount%limit==0?0:1;
		pageBean.setTotalPage(totalPage);
		int begin = (page-1)*limit;
<<<<<<< HEAD
		pageBean.setBeanList(adminPostDao.findPostLogByBeginAndLimit(begin, limit));
=======
		pageBean.setBeanList(adminPostDao.findByLastOperationABeginALimit("delete", begin, limit));
>>>>>>> origin/master
		return pageBean;
	}

	@Override
<<<<<<< HEAD
=======
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
>>>>>>> origin/master
	public void updatePostOperationLog(PostLog postLog) {
		adminPostDao.updatePostLog(postLog);
	}

	@Override
<<<<<<< HEAD
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
=======
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
>>>>>>> origin/master
		return pageBean;
	}

	@Override
<<<<<<< HEAD
	public PostLog findPostLogByLastOperationAndId(String lastOperation, Integer id) {
		return adminPostDao.findPostLogByLastOperationAndId(lastOperation,id);
	}

	@Override
	public PageBean<PostLog> findAppealLogByAppealProcessAndAppealUser(boolean appealProcess, User appealUser) {
=======
	public PageBean<PostLog> findProcessedAppealLogAll() {
>>>>>>> origin/master
		// TODO Auto-generated method stub
		return null;
	}

	@Override
<<<<<<< HEAD
	public PageBean<PostLog> findAppealLogByAppealProcessAndPage(boolean appealProcess, Integer page) {
=======
	public PageBean<PostLog> findLogByFirstOperatorAndInterval(String username, Integer interval) {
>>>>>>> origin/master
		// TODO Auto-generated method stub
		return null;
	}

	@Override
<<<<<<< HEAD
	public PageBean<PostLog> findPostLogByLastOperatorAndInterval(User user, Integer interval) {
=======
	public PageBean<PostLog> findLogByLastOperatorAndInterval(String username, Integer interval) {
>>>>>>> origin/master
		// TODO Auto-generated method stub
		return null;
	}

	@Override
<<<<<<< HEAD
	public PageBean<PostLog> findPostLogByFirstOperatorAndInterval(User user, Integer interval) {
=======
	public PageBean<PostLog> findUnRecoverDeleteLogByFirstOperatorAInterval(String username, Integer interval) {
>>>>>>> origin/master
		// TODO Auto-generated method stub
		return null;
	}

	@Override
<<<<<<< HEAD
	public PageBean<PostLog> findPostLogByLastOperationAFirstOperatorAInterval(String lastOperation, User user, Integer interval) {
=======
	public PageBean<PostLog> findUnRecoverDeleteLogByLastOperatorAInterval(String username, Integer interval) {
>>>>>>> origin/master
		// TODO Auto-generated method stub
		return null;
	}

	@Override
<<<<<<< HEAD
	public PageBean<PostLog> findPostLogByLastOperationALastOperatorAInterval(String lastOperation, User user, Integer interval) {
		// TODO Auto-generated method stub
		return null;
=======
	public void savePostLog(PostLog postLog) {
		adminPostDao.savePostLog(postLog);
>>>>>>> origin/master
	}

}
