package cn.xiedacon.bar.status.domain;
/**
 * 状态实体类
 * 
 * CREATE TABLE `status` (
  `sid` INT(11) NOT NULL AUTO_INCREMENT,
  `sname` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8
 * @author xieda
 *
 */
public class Status {

	private Integer sid;
	private String sname;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
}
