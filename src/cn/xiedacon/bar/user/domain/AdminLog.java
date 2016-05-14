package cn.xiedacon.bar.user.domain;

import java.util.Date;

/**
 * 吧务管理记录实体类
 * 
 * CREATE TABLE `adminlog` (
  `id` INT(11) NOT NULL,
  `adminUser` INT(11) DEFAULT NULL,
  `operation` VARCHAR(255) DEFAULT NULL,
  `operator` INT(11) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_adminlog_TO_user` (`adminUser`),
  KEY `FK_adminlog_operator_TO_user` (`operator`),
  CONSTRAINT `FK_adminlog_operator_TO_user` FOREIGN KEY (`operator`) REFERENCES `user` (`uid`),
  CONSTRAINT `FK_adminlog_TO_user` FOREIGN KEY (`adminUser`) REFERENCES `user` (`uid`)
) ENGINE=INNODB DEFAULT CHARSET=utf8
 * @author xieda
 *
 */
public class AdminLog {

	private Integer id;
	private User adminUser;
	private String operation;
	private User operator;
	private Date time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getAdminUser() {
		return adminUser;
	}
	public void setAdminUser(User adminUser) {
		this.adminUser = adminUser;
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
