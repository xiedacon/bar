package cn.xiedacon.bar.reply.service;

import org.springframework.transaction.annotation.Transactional;

import cn.xiedacon.bar.reply.domain.Reply;
import cn.xiedacon.bar.util.PageBean;
@Transactional
public interface ReplyService {

	PageBean<Reply> findByFidAndPage(Integer fid, Integer page);

	void saveReply(Reply reply);

}
