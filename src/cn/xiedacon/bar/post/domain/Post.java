package cn.xiedacon.bar.post.domain;

import java.util.Date;

import cn.xiedacon.bar.floor.domain.Floor;
import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.util.PageBean;

/**
 * 帖子实体类
 * 
CREATE TABLE `post` (
  `pid` VARCHAR(255) NOT NULL AUTO_INCREMENT,
  `ouid` INT(11) DEFAULT NULL,
  `title` VARCHAR(255) DEFAULT NULL,
  `status` INT(11) DEFAULT NULL,
  `ldate` DATETIME DEFAULT NULL,
  `content` VARCHAR(255) DEFAULT NULL,
  `num` INT(11) DEFAULT NULL,
  `luid` INT(11) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `FK_post_status` (`sid`),
  KEY `FK_post_ouser` (`ouid`),
  KEY `FK_post_luser` (`luid`),
  CONSTRAINT `FK_post_luser` FOREIGN KEY (`luid`) REFERENCES `user` (`uid`),
  CONSTRAINT `FK_post_ouser` FOREIGN KEY (`ouid`) REFERENCES `user` (`uid`),
  CONSTRAINT `FK_post_status` FOREIGN KEY (`sid`) REFERENCES `status` (`sid`)
) ENGINE=INNODB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8
 * @author xieda
 *
 *
 */
/**
 * @author xieda
 *
 */
public class Post {

	private String pid;
	private String title;
	private String content;
	private Integer num;
	private User owner;
	private User lastUser;
	private Date ldate;
	private Integer status;
	private PageBean<Floor> pageBean;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Date getLdate() {
		return ldate;
	}
	public void setLdate(Date ldate) {
		this.ldate = ldate;
	}
	public void setLastUser(User lastUser) {
		this.lastUser = lastUser;
	}
	public User getLastUser() {
		return lastUser;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public PageBean<Floor> getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean<Floor> pageBean) {
		this.pageBean = pageBean;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
}
