package cn.xiedacon.bar.reply.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.xiedacon.bar.reply.dao.ReplyDao;
import cn.xiedacon.bar.reply.domain.Reply;
import cn.xiedacon.bar.reply.service.ReplyService;
import cn.xiedacon.bar.util.PageBean;

public class ReplyServiceImpl implements ReplyService {

	private ReplyDao replyDao;

	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	@Override
	public PageBean<Reply> findByFidAndPage(Integer fid, Integer page) {
		PageBean<Reply> pageBean = new PageBean<Reply>();
		int limit = 10;
		pageBean.setLimit(limit);
		pageBean.setPage(page);
		int totalCount = replyDao.findTotalCountByFid(fid);
		
		//总计为0就没有查询的必要了
		if(totalCount == 0){
			pageBean.setTotalCount(totalCount);
			pageBean.setTotalPage(0);
			pageBean.setBeanList(new ArrayList<Reply>());
			return pageBean;
		}
		
		pageBean.setTotalCount(totalCount);
		int totalPage = totalCount / limit + (totalCount % limit == 0 ? 0 : 1);
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * limit;
		List<Reply> beans = replyDao.findByLimitAndFid(begin, limit, fid);
		pageBean.setBeanList(beans);
		return pageBean;
	}

	@Override
	public void saveReply(Reply reply) {
		replyDao.saveReply(reply);
	}

}
