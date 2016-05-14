package cn.xiedacon.bar.position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import cn.xiedacon.bar.position.dao.PositionDao;
import cn.xiedacon.bar.position.domain.Position;

public class PositionManager {

	private HashMap<Integer, Position> positionMap;
	private PositionDao positionDao;
	public void setPositionDao(PositionDao positionDao) {
		this.positionDao = positionDao;
		if(positionMap==null){
			reloadPositionMap();
		}
	}
	public void setPositionMap(HashMap<Integer, Position> positionMap) {
		this.positionMap = positionMap;
	}
	
	public Position get(Object id) {
		return positionMap.get(id);
	}
	
	public PositionManager reloadPositionMap(){
		if(positionDao == null){
			throw new RuntimeException("positionDao不能为空");
		}
		List<Position> positionList = positionDao.findAll();
		positionMap = new HashMap<Integer, Position>();
		for(Position position:positionList){
			positionMap.put(position.getId(), position);
		}
		return this;
	}
	
	public List<Position> getPositionList(){
		return new ArrayList<Position>(positionMap.values());
	}
}
