package cn.xiedacon.bar.position.dao;

import java.util.List;

import cn.xiedacon.bar.position.domain.Position;

public interface PositionDao {

	List<Position> findAll();
}
