package cn.xiedacon.bar.level.domain;
/**
 * 等级实体类
 * 
CREATE TABLE `level` (
  `lid` INT(11) NOT NULL AUTO_INCREMENT,
  `lname` VARCHAR(255) DEFAULT NULL,
  `priviledges` INT(11) DEFAULT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8
 * @author xieda
 *
 */
public class Level {

	private Integer lid;
	private String lname;
	private Integer priviledges;
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Integer getPriviledges() {
		return priviledges;
	}
	public void setPriviledges(Integer priviledges) {
		this.priviledges = priviledges;
	}
}
