package cn.xiedacon.bar.reply.domain;

import java.util.Date;

import cn.xiedacon.bar.floor.domain.Floor;
import cn.xiedacon.bar.user.domain.User;

/**
 * 回复实体类
 * 
CREATE TABLE `reply` (
  `rid` INT(11) NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(255) DEFAULT NULL,
  `date` DATETIME DEFAULT NULL,
  `uid` INT(11) DEFAULT NULL,
  `fid` INT(11) DEFAULT NULL,
  PRIMARY KEY (`rid`),
  KEY `FK_reply_user` (`uid`),
  KEY `FK_reply_floor` (`fid`),
  CONSTRAINT `FK_reply_floor` FOREIGN KEY (`fid`) REFERENCES `floor` (`fid`),
  CONSTRAINT `FK_reply_user` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8
 * @author xieda
 *
 */
public class Reply {

	private Integer rid;
	private String content;
	private Date date;
	private User owner;
	private Floor floor;
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public Floor getFloor() {
		return floor;
	}
	public void setFloor(Floor floor) {
		this.floor = floor;
	}
}
