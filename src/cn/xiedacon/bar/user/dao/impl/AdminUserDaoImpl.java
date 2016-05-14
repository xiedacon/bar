package cn.xiedacon.bar.user.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.xiedacon.bar.user.dao.AdminUserDao;
import cn.xiedacon.bar.user.domain.AdminLog;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.user.domain.UserLog;
import cn.xiedacon.bar.util.PageHibernateCallback;

public class AdminUserDaoImpl extends HibernateDaoSupport implements AdminUserDao {

	@Override
	public void saveUserLog(UserLog userLog) {
		this.getHibernateTemplate().save(userLog);
	}

	@Override
	public int findTotalCountByLastOperation(String operation) {
		String hql = "SELECT COUNT(*) FROM UserLog u WHERE u.lastOperation=?";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql, operation);
		if(list==null || list.isEmpty()){
			return 0;
		}else{
			return list.get(0).intValue();
		}
	}

	@Override
	public List<UserLog> findByLastOperationABeginALimt(String operation, int begin, int limit) {
		String hql = "FROM UserLog u WHERE u.lastOperation=?";
		List<UserLog> list = this.getHibernateTemplate().execute(new PageHibernateCallback<UserLog>(hql, operation, begin, limit));
		if(list==null){
			return new ArrayList<UserLog>();
		}else{
			return list;
		}
	}

	@Override
	public UserLog findUserLogByLastOperationAndId(String operation, Integer id) {
		UserLog userLog = this.getHibernateTemplate().get(UserLog.class, id);
		if(userLog == null || !operation.equals(userLog.getLastOperation())){
			return null;
		}else{
			return userLog;
		}
	}

	@Override
	public void updateUserLog(UserLog userLog) {
		this.getHibernateTemplate().update(userLog);
	}

	@Override
	public int findTotalCountAll() {
		String hql = "SELECT COUNT(*) FROM UserLog u";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list==null || list.isEmpty()){
			return 0;
		}else{
			return list.get(0).intValue();
		}
	}

	@Override
	public List<UserLog> findByBeginAndLimt(int begin, int limit) {
		String hql = "FROM UserLog u";
		List<UserLog> list = this.getHibernateTemplate().execute(new PageHibernateCallback<UserLog>(hql, begin, limit));
		if(list==null){
			return new ArrayList<UserLog>();
		}else{
			return list;
		}
	}

	@Override
	public void removeAdmin(User user) {
		String sql = "UPDATE user SET position = NULL,isAdmin=0 WHERE uid="+user.getUid().toString();
		this.getSessionFactory().getCurrentSession().createSQLQuery(sql).executeUpdate();
	}

	@Override
	public void saveAdminLog(AdminLog adminLog) {
		this.getHibernateTemplate().save(adminLog);
	}

	@Override
	public List<AdminLog> findAdminLogByBeginAndLimt(int begin, int limit) {
		String hql = "FROM AdminLog a";
		List<AdminLog> list = this.getHibernateTemplate().execute(new PageHibernateCallback<AdminLog>(hql, begin, limit));
		if(list==null){
			return new ArrayList<AdminLog>();
		}else{
			return list;
		}
	}

	@Override
	public int findAdminLogTotalCount() {
		String hql = "SELECT COUNT(*) FROM AdminLog a";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list==null || list.isEmpty()){
			return 0;
		}else{
			return list.get(0).intValue();
		}
	}

}
