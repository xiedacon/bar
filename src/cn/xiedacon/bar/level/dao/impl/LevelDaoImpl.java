package cn.xiedacon.bar.level.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.xiedacon.bar.level.dao.LevelDao;
import cn.xiedacon.bar.level.domain.Level;

public class LevelDaoImpl extends HibernateDaoSupport implements LevelDao{

<<<<<<< HEAD
	@SuppressWarnings("unchecked")
=======
>>>>>>> origin/master
	@Override
	public List<Level> findAll() {
		String hql = "FROM Level";
		List<Level> levelList = (List<Level>) this.getHibernateTemplate().find(hql);
		if(levelList==null){
			return new ArrayList<Level>();
		}else{
			return levelList;
		}
	}

	
}
