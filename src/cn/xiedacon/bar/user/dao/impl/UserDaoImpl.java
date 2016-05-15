package cn.xiedacon.bar.user.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.xiedacon.bar.user.dao.UserDao;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.util.PageHibernateCallback;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@SuppressWarnings("unchecked")
	public User findByUid(Integer uid){
		String hql = "FROM User u WHERE u.uid = ?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, uid);
		if(list==null||list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}
	
	@SuppressWarnings("unchecked")
	public User findByUsername(String username){
		String hql = "FROM User u WHERE u.username = ?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, username);
		if(list==null||list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}

	@Override
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	@Override
	public void update(User user) {
		this.getHibernateTemplate().update(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int findTotalCount() {
		String hql = "SELECT COUNT(*) FROM User u WHERE u.forbidden=0";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list==null||list.isEmpty()){
			return 0;
		}else{
			return list.get(0).intValue();
		}
	}

	@Override
	public List<User> findByBeginAndLimt(int begin, int limit) {
		String hql = "FROM User u WHERE u.forbidden=0 ORDER BY u.registDate ASC";
		List<User> list = this.getHibernateTemplate().execute(new PageHibernateCallback<User>(hql, begin, limit));
		if(list==null){
			return new ArrayList<User>();
		}else{
			return list;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByPositionId(Integer id) {
		String hql = "FROM User u WHERE u.position.id =?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, id);
		if(list==null){
			return new ArrayList<User>();
		}else{
			return list;
		}
	}
}
