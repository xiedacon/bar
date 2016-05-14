package cn.xiedacon.bar.floor.service.impl;

import java.util.ArrayList;
import java.util.List;


import cn.xiedacon.bar.floor.dao.FloorDao;
import cn.xiedacon.bar.floor.domain.Floor;
import cn.xiedacon.bar.floor.service.FloorService;
import cn.xiedacon.bar.util.PageBean;
public class FloorServiceImpl implements FloorService {

	private FloorDao floorDao;

	public void setFloorDao(FloorDao floorDao) {
		this.floorDao = floorDao;
	}

	@Override
	public PageBean<Floor> findByPostAndPage(String pid, Integer page) {
		PageBean<Floor> pageBean = new PageBean<Floor>();
		int limit = 10;
		pageBean.setLimit(limit);
		pageBean.setPage(page);
		int totalCount = floorDao.findTotalCountByPid(pid);
		
		//总计为0就没有查询的必要了
		if(totalCount == 0){
			pageBean.setTotalCount(totalCount);
			pageBean.setTotalPage(0);
			pageBean.setBeanList(new ArrayList<Floor>());
			return pageBean;
		}
		
		pageBean.setTotalCount(totalCount);
		int totalPage = totalCount / limit + (totalCount % limit == 0 ? 0 : 1);
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * limit;
		List<Floor> beans = floorDao.findByLimitAndPid(begin, limit, pid);
		pageBean.setBeanList(beans);
		return pageBean;
	}

	@Override
	public void createFloor(Floor floor) {
		floorDao.createFloor(floor);
	}

	@Override
	public Floor findByFid(Integer fid) {
		return floorDao.findByFid(fid);
	}

}
