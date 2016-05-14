package cn.xiedacon.bar.level;

import java.util.HashMap;
import java.util.List;

import cn.xiedacon.bar.level.dao.LevelDao;
import cn.xiedacon.bar.level.domain.Level;
<<<<<<< HEAD
=======
import cn.xiedacon.bar.position.domain.Position;
>>>>>>> origin/master

public class LevelManager {

	private HashMap<Integer, Level> levelMap;
	private LevelDao levelDao;
	public void setLevelDao(LevelDao levelDao) {
		this.levelDao = levelDao;
		if(levelMap==null){
			reloadLevelMap();
		}
	}
	public LevelManager reloadLevelMap() {
		if(levelDao == null){
			throw new RuntimeException("positionDao不能为空");
		}
		List<Level> levelList = levelDao.findAll();
		levelMap = new HashMap<Integer, Level>();
		for(Level level:levelList){
			levelMap.put(level.getLid(), level);
		}
		return this;
		
	}
	public HashMap<Integer, Level> getLevelMap() {
		return levelMap;
	}
	public void setLevelMap(HashMap<Integer, Level> levelMap) {
		this.levelMap = levelMap;
	}
	
	public Level get(Object lid) {
		return levelMap.get(lid);
	}
	
	

}
