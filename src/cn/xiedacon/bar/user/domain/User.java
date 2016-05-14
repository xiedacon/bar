package cn.xiedacon.bar.user.domain;

import java.util.Date;

import cn.xiedacon.bar.level.domain.Level;
import cn.xiedacon.bar.position.domain.Position;

/**
 * 用户实体类
 * 
CREATE TABLE `user` (
  `uid` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) DEFAULT NULL,
  `password` VARCHAR(255) DEFAULT NULL,
  `name` VARCHAR(255) DEFAULT NULL,
  `icon` VARCHAR(255) DEFAULT NULL,
  `email` VARCHAR(255) DEFAULT NULL,
  `lid` INT(11) DEFAULT '1',
  `delete_post_num` INT(11) DEFAULT '0',
  `post_num` INT(11) DEFAULT '0',
  `floor_num` INT(11) DEFAULT '0',
  `regist_date` DATE DEFAULT NULL,
  `boutique_num` INT(11) DEFAULT '0',
  `isAdmin` TINYINT(1) DEFAULT '0',
  `position` INT(11) DEFAULT NULL,
  `forbidden` TINYINT(1) DEFAULT '0',
  PRIMARY KEY (`uid`),
  KEY `FK466avr74q3d31dsmycukgwphc` (`lid`),
  KEY `FKlyjpeifd600hifrxw2avv3vvv` (`position`),
  CONSTRAINT `FK466avr74q3d31dsmycukgwphc` FOREIGN KEY (`lid`) REFERENCES `level` (`lid`),
  CONSTRAINT `FKlyjpeifd600hifrxw2avv3vvv` FOREIGN KEY (`position`) REFERENCES `position` (`position_id`),
  CONSTRAINT `FK_user_level` FOREIGN KEY (`lid`) REFERENCES `level` (`lid`)
) ENGINE=INNODB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8

 * @author xieda
 *
 */
public class User {

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", name=" + name + ", icon=" + icon + ", email=" + email + ", level=" + level + ", deletePostNum=" + deletePostNum + ", postNum=" + postNum + ", floorNum=" + floorNum + ", boutiqueNum=" + boutiqueNum + ", registDate=" + registDate + ", isAdmin=" + isAdmin + ", position=" + position + "]";
	}
	private Integer uid;
	private String username;
	private String password;
	private String name;
	private String icon;
	private String email;
	private Level level;
	private Integer deletePostNum;
	private Integer postNum;
	private Integer floorNum;
	private Integer boutiqueNum;
	private Date registDate;
	private Boolean isAdmin;
	private Position position;
	private Boolean forbidden;
	public Boolean getForbidden() {
		return forbidden;
	}
	public void setForbidden(Boolean forbidden) {
		this.forbidden = forbidden;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Boolean isAdmin() {
		return isAdmin;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Integer getDeletePostNum() {
		return deletePostNum;
	}
	public void setDeletePostNum(Integer deletePostNum) {
		this.deletePostNum = deletePostNum;
	}
	public Integer getPostNum() {
		return postNum;
	}
	public void setPostNum(Integer postNum) {
		this.postNum = postNum;
	}
	public Integer getFloorNum() {
		return floorNum;
	}
	public void setFloorNum(Integer floorNum) {
		this.floorNum = floorNum;
	}
	public Integer getBoutiqueNum() {
		return boutiqueNum;
	}
	public void setBoutiqueNum(Integer boutiqueNum) {
		this.boutiqueNum = boutiqueNum;
	}
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	public Integer getUid() {
		return uid;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
