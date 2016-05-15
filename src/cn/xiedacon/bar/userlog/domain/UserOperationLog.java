package cn.xiedacon.bar.userlog.domain;

import java.util.Date;

import cn.xiedacon.bar.user.domain.User;

/**
 * 用户单次操作记录实体类
 * 
 * CREATE TABLE `useroperationlog` (
  `id` INT(11) NOT NULL,
  `operator` INT(11) DEFAULT NULL,
  `operation` VARCHAR(255) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `userlogId` INT(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_useroperationlog_userLogId_TO_userlog` (`userlogId`),
  KEY `FK_useroperationlog_TO_user` (`operator`),
  CONSTRAINT `FK_useroperationlog_TO_user` FOREIGN KEY (`operator`) REFERENCES `user` (`uid`),
  CONSTRAINT `FK_useroperationlog_userLogId_TO_userlog` FOREIGN KEY (`userLogId`) REFERENCES `userlog` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8
 * @author xieda
 *
 */
public class UserOperationLog {

	private Integer id;
	private User operator;
	private String operation;
	private Date time;
	private UserLog userLog;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getOperator() {
		return operator;
	}
	public void setOperator(User operator) {
		this.operator = operator;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public UserLog getUserLog() {
		return userLog;
	}
	public void setUserLog(UserLog userLog) {
		this.userLog = userLog;
	}
}
