package cn.xiedacon.bar.reply.dao;

import java.util.List;

import cn.xiedacon.bar.reply.domain.Reply;

public interface ReplyDao {

	Integer findTotalCountByFid(Integer fid);
	List<Reply> findByLimitAndFid(Integer begin, Integer limit, Integer fid);
	void saveReply(Reply reply);

}
