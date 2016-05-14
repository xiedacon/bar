package cn.xiedacon.bar.position.domain;
/**
 * 职位实体类
 * 
CREATE TABLE `position` (
  `position_id` INT(11) NOT NULL,
  `position_name` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`position_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8
 * @author xieda
 *
 */
public class Position {

	private Integer id;
	private String name;
	
	public Position() {
		super();
	}
	public Position(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
