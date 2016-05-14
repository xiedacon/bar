package cn.xiedacon.bar.floor.domain;

import java.util.Date;
<<<<<<< HEAD

import cn.xiedacon.bar.post.domain.Post;
=======
import java.util.Set;

import cn.xiedacon.bar.post.domain.Post;
import cn.xiedacon.bar.reply.domain.Reply;
>>>>>>> origin/master
import cn.xiedacon.bar.user.domain.User;

/**
 * 楼层实体类
 * 
CREATE TABLE `floor` (
  `fid` INT(11) NOT NULL AUTO_INCREMENT,
  `uid` INT(11) DEFAULT NULL,
  `content` VARCHAR(255) DEFAULT NULL,
  `date` DATETIME DEFAULT NULL,
  `pid` VARCHAR(255) DEFAULT NULL,
  `floorNum` INT(11) DEFAULT NULL,
  PRIMARY KEY (`fid`),
  KEY `FK_floor_user` (`uid`),
  KEY `FK_floor_post` (`pid`),
  CONSTRAINT `FK_floor_post` FOREIGN KEY (`pid`) REFERENCES `post` (`pid`),
  CONSTRAINT `FK_floor_user` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=INNODB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8
 * @author xieda
 *
 */
public class Floor {

	private Integer fid;
	private User owner;
	private String content;
	private Date date;
	private Integer floorNum;
	private Post post;
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getFloorNum() {
		return floorNum;
	}
	public void setFloorNum(Integer floorNum) {
		this.floorNum = floorNum;
	}
}
