package cn.xiedacon.bar.floor.dao;

import java.util.List;

import cn.xiedacon.bar.floor.domain.Floor;

public interface FloorDao {

	Integer findTotalCountByPid(String pid);
	List<Floor> findByLimitAndPid(Integer begin, Integer limit, String pid);
	void createFloor(Floor floor);
	Floor findByFid(Integer fid);

}
