package cn.xiedacon.bar.reply.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.xiedacon.bar.reply.dao.ReplyDao;
import cn.xiedacon.bar.reply.domain.Reply;
import cn.xiedacon.bar.util.PageHibernateCallback;

public class ReplyDaoImpl extends HibernateDaoSupport implements ReplyDao {

	@Override
	public Integer findTotalCountByFid(Integer fid) {
		String hql = "SELECT COUNT(r) FROM Reply r JOIN r.floor f WHERE f.fid=?";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql, fid);
		if (list == null) {
			return 0;
		} else {
			return list.get(0).intValue();
		}
	}

	@Override
	public List<Reply> findByLimitAndFid(Integer begin, Integer limit, Integer fid) {
		String hql = "SELECT r FROM Reply r JOIN r.floor f WHERE f.fid=?";
		List<Reply> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Reply>(hql, new Object[] { fid }, begin, limit));
		if (list == null) {
			return new ArrayList<Reply>();
		} else {
			return list;
		}
	}

	@Override
	public void saveReply(Reply reply) {
		this.getHibernateTemplate().save(reply);
	}

}
