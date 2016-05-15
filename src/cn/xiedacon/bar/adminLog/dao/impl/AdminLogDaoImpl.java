package cn.xiedacon.bar.adminLog.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.xiedacon.bar.adminLog.dao.AdminLogDao;
import cn.xiedacon.bar.user.domain.AdminLog;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.util.PageHibernateCallback;

public class AdminLogDaoImpl extends HibernateDaoSupport implements AdminLogDao {

	@Override
	public void removeAdmin(User user) {
		String sql = "UPDATE user SET position = NULL,isAdmin=0 WHERE uid="+user.getUid().toString();
		this.getSessionFactory().getCurrentSession().createSQLQuery(sql).executeUpdate();
	}

	@Override
	public void save(AdminLog adminLog) {
		this.getHibernateTemplate().save(adminLog);
	}

	@Override
	public List<AdminLog> findByBeginAndLimt(int begin, int limit) {
		String hql = "FROM AdminLog a ORDER BY a.time DESC";
		List<AdminLog> list = this.getHibernateTemplate().execute(new PageHibernateCallback<AdminLog>(hql, begin, limit));
		if(list==null){
			return new ArrayList<AdminLog>();
		}else{
			return list;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public int findTotalCount() {
		String hql = "SELECT COUNT(*) FROM AdminLog a";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list==null || list.isEmpty()){
			return 0;
		}else{
			return list.get(0).intValue();
		}
	}

}
