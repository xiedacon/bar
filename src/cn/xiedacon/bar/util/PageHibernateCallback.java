package cn.xiedacon.bar.util;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

public class PageHibernateCallback<T> implements HibernateCallback<List<T>> {

	private String hql;
	private Object[] params;
	private Integer begin;
	private Integer limit;
	public PageHibernateCallback(String hql, Integer begin, Integer limit) {
		this.hql = hql;
		this.params = new Object[]{};
		this.begin = begin;
		this.limit = limit;
	}
	public PageHibernateCallback(String hql, Object[] params, Integer begin, Integer limit) {
		this.hql = hql;
		this.params = params;
		this.begin = begin;
		this.limit = limit;
	}
	public PageHibernateCallback(String hql, Object param, Integer begin, Integer limit) {
		this.hql = hql;
		this.params = new Object[]{param};
		this.begin = begin;
		this.limit = limit;
	}
	@Override
	public List<T> doInHibernate(Session session) throws HibernateException {
		//使用hql获得query
		Query query = session.createQuery(hql);
		for(int i = 0;i<params.length;i++){
			//设置所有参数
			query.setParameter(i, params[i]);
		}
		//需要限制数目
		query.setFirstResult(begin);
		query.setMaxResults(limit);
		return query.list();
	}

}
