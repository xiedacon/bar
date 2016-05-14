package cn.xiedacon.bar.user.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * 用户操作记录实体类
 * 
 * CREATE TABLE `userlog` (
  `uid` INT(11) DEFAULT NULL,
  `firstOperation` VARCHAR(255) DEFAULT NULL,
  `firstOperator` INT(11) DEFAULT NULL,
  `firstTime` DATETIME DEFAULT NULL,
  `lastOperation` VARCHAR(255) DEFAULT NULL,
  `lastOperator` INT(11) DEFAULT NULL,
  `lastTime` DATE DEFAULT NULL,
  `id` INT(11) NOT NULL,
  `appealTime` DATETIME DEFAULT NULL,
  `appealContent` TEXT,
  `appealProcess` TINYINT(1) DEFAULT NULL,
  `forbiddenTime` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_userlog_uid_TO_user` (`uid`),
  KEY `FK_userlog_firstOperator_TO_user` (`firstOperator`),
  KEY `FK_userlog_lastOperator_TO_user` (`lastOperator`),
  CONSTRAINT `FK_userlog_lastOperator_TO_user` FOREIGN KEY (`lastOperator`) REFERENCES `user` (`uid`),
  CONSTRAINT `FK_userlog_firstOperator_TO_user` FOREIGN KEY (`firstOperator`) REFERENCES `user` (`uid`),
  CONSTRAINT `FK_userlog_uid_TO_user` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=INNODB DEFAULT CHARSET=utf8

 * @author xieda
 *
 */
public class UserLog {

	private Integer id;
	private User user;
	private String firstOperation;
	private User firstOperator;
	private Date firstTime;
	private String lastOperation;
	private User lastOperator;
	private Date lastTime;
	private Set<UserOperationLog> userOperationLogs; 
	public Set<UserOperationLog> getUserOperationLogs() {
		return userOperationLogs;
	}
	public void setUserOperationLogs(Set<UserOperationLog> userOperationLogs) {
		this.userOperationLogs = userOperationLogs;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstOperation() {
		return firstOperation;
	}
	public void setFirstOperation(String firstOperation) {
		this.firstOperation = firstOperation;
	}
	public User getFirstOperator() {
		return firstOperator;
	}
	public void setFirstOperator(User firstOperator) {
		this.firstOperator = firstOperator;
	}
	public Date getFirstTime() {
		return firstTime;
	}
	public void setFirstTime(Date firstTime) {
		this.firstTime = firstTime;
	}
	public String getLastOperation() {
		return lastOperation;
	}
	public void setLastOperation(String lastOperation) {
		this.lastOperation = lastOperation;
	}
	public User getLastOperator() {
		return lastOperator;
	}
	public void setLastOperator(User lastOperator) {
		this.lastOperator = lastOperator;
	}
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	public void addUserOperationLog(UserOperationLog userOperationLog){
		if(userOperationLogs==null){
			userOperationLogs = new HashSet<UserOperationLog>();
		}
		userOperationLogs.add(userOperationLog);
	}
}
