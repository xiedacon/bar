package cn.xiedacon.bar.position.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.xiedacon.bar.position.dao.PositionDao;
import cn.xiedacon.bar.position.domain.Position;

public class PositionDaoImpl extends HibernateDaoSupport implements PositionDao{

<<<<<<< HEAD
	@SuppressWarnings("unchecked")
=======
>>>>>>> origin/master
	public List<Position> findAll() {
		String hql = "FROM Position";
		List<Position> positionList = (List<Position>) this.getHibernateTemplate().find(hql);
		if(positionList==null){
			return new ArrayList<Position>();
		}else{
			return positionList;
		}
	}

	
}
