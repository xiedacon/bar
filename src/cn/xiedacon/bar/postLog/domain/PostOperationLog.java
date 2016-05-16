package cn.xiedacon.bar.postLog.domain;

import java.util.Date;

import cn.xiedacon.bar.user.domain.User;

/**
 * 帖子单次操作记录实体类
 * 
 * CREATE TABLE `postoperationlog` (
  `id` INT(11) NOT NULL,
  `postlogId` INT(11) DEFAULT NULL,
  `operation` VARCHAR(255) DEFAULT NULL,
  `operator` INT(11) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_postoperationlog_postlogId_TO_postlog` (`postlogId`),
  KEY `FK_postoperationlog_TO_user` (`operator`),
  CONSTRAINT `FK_postoperationlog_TO_user` FOREIGN KEY (`operator`) REFERENCES `user` (`uid`),
  CONSTRAINT `FK_postoperationlog_postlogId_TO_postlog` FOREIGN KEY (`postlogId`) REFERENCES `postlog` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8
 * @author xieda
 *
 */
public class PostOperationLog {

	private Integer id;
	private PostLog postLog;
	private String operation;
	private User operator;
	private Date time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public PostLog getPostLog() {
		return postLog;
	}
	public void setPostLog(PostLog postLog) {
		this.postLog = postLog;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public User getOperator() {
		return operator;
	}
	public void setOperator(User operator) {
		this.operator = operator;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
