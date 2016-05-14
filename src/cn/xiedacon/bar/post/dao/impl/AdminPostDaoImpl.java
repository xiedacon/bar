package cn.xiedacon.bar.post.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.xiedacon.bar.post.dao.AdminPostDao;
import cn.xiedacon.bar.post.domain.PostLog;
import cn.xiedacon.bar.util.PageHibernateCallback;

public class AdminPostDaoImpl extends HibernateDaoSupport implements AdminPostDao {

	@Override
	public int findTotalCountByLastOperation(String operation) {
		String hql = "SELECT COUNT(*) FROM PostLog p WHERE p.lastOperation=?";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql, operation);
		if(list == null||list.size()==0){
			return 0;
		}else{
			return list.get(0).intValue();
		}
	}

	@Override
	public List<PostLog> findByLastOperationABeginALimit(String operation, int begin, int limit) {
		String hql = "FROM PostLog p WHERE p.lastOperation=? ORDER BY p.lastTime DESC";
		List<PostLog> list = this.getHibernateTemplate().execute(new PageHibernateCallback<PostLog>(hql, operation, begin, limit));
		if(list==null){
			return new ArrayList<PostLog>();
		}else{
			return list;
		}
	}

	@Override
	public void savePostLog(PostLog postLog) {
		this.getHibernateTemplate().save(postLog);
	}

	@Override
	public PostLog findByIdAndLastOperation(Integer id, String operation) {
		String hql = "FROM PostLog p WHERE p.id=? AND p.lastOperation=?";
		List<PostLog> list = (List<PostLog>) this.getHibernateTemplate().find(hql, id,operation);
		if(list==null||list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}

	@Override
	public void updatePostLog(PostLog postLog) {
		this.getHibernateTemplate().update(postLog);
	}

	@Override
	public int findTotalCountAll() {
		String hql = "SELECT COUNT(*) FROM PostLog p";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list == null||list.size()==0){
			return 0;
		}else{
			return list.get(0).intValue();
		}
	}

	@Override
	public List<PostLog> findByBeginAndLimit(int begin, int limit) {
		String hql = "FROM PostLog p ORDER BY p.lastTime DESC";
		List<PostLog> list = this.getHibernateTemplate().execute(new PageHibernateCallback<PostLog>(hql, begin, limit));
		if(list==null){
			return new ArrayList<PostLog>();
		}else{
			return list;
		}
	}

}