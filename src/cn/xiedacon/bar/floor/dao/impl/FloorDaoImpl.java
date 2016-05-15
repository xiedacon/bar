package cn.xiedacon.bar.floor.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.xiedacon.bar.floor.dao.FloorDao;
import cn.xiedacon.bar.floor.domain.Floor;
import cn.xiedacon.bar.util.PageHibernateCallback;

public class FloorDaoImpl extends HibernateDaoSupport implements FloorDao {

	@Override
	public List<Floor> findByLimitAndPid(Integer begin, Integer limit,String pid) {
		String hql = "SELECT f FROM Floor f JOIN f.post p WHERE p.pid=? ORDER BY p.ldate DESC";
		List<Floor> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Floor>(hql,new Object[]{pid}, begin, limit));
		if(list==null){
			return new ArrayList<Floor>();
		}else{
			return list;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer findTotalCountByPid(String pid) {
		String hql = "SELECT COUNT(f) FROM Floor f JOIN f.post p WHERE p.pid=?";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql,pid);
		if(list==null){
			return 0;
		}else{
			return list.get(0).intValue();
		}
	}

	@Override
	public void createFloor(Floor floor) {
		this.getHibernateTemplate().save(floor);
	}

	@Override
	public Floor findByFid(Integer fid) {
		return this.getHibernateTemplate().get(Floor.class, fid);
	}

}
