package cn.xiedacon.bar.floor.service;

import org.springframework.transaction.annotation.Transactional;

import cn.xiedacon.bar.floor.domain.Floor;
import cn.xiedacon.bar.util.PageBean;
@Transactional
public interface FloorService {

	PageBean<Floor> findByPostAndPage(String pid, Integer page);

	void createFloor(Floor floor);

	Floor findByFid(Integer fid);

}
