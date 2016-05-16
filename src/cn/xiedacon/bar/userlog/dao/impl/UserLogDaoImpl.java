package cn.xiedacon.bar.userLog.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.xiedacon.bar.userLog.dao.UserLogDao;
import cn.xiedacon.bar.userLog.domain.UserLog;
import cn.xiedacon.bar.util.PageHibernateCallback;

public class UserLogDaoImpl extends HibernateDaoSupport implements UserLogDao {

	@Override
	public void save(UserLog userLog) {
		this.getHibernateTemplate().save(userLog);
	}

	@SuppressWarnings("unchecked")
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
		String hql = "FROM UserLog u WHERE u.lastOperation=? ORDER BY u.lastTime DESC";
		List<UserLog> list = this.getHibernateTemplate().execute(new PageHibernateCallback<UserLog>(hql, operation, begin, limit));
		if(list==null){
			return new ArrayList<UserLog>();
		}else{
			return list;
		}
	}

	@Override
	public UserLog findByLastOperationAndId(String operation, Integer id) {
		UserLog userLog = this.getHibernateTemplate().get(UserLog.class, id);
		if(userLog == null || !operation.equals(userLog.getLastOperation())){
			return null;
		}else{
			return userLog;
		}
	}

	@Override
	public void update(UserLog userLog) {
		this.getHibernateTemplate().update(userLog);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int findTotalCount() {
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
		String hql = "FROM UserLog u ORDER BY u.lastTime DESC";
		List<UserLog> list = this.getHibernateTemplate().execute(new PageHibernateCallback<UserLog>(hql, begin, limit));
		if(list==null){
			return new ArrayList<UserLog>();
		}else{
			return list;
		}
	}

}
