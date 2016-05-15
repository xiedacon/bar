package cn.xiedacon.bar.user.dao;

import java.util.List;

import cn.xiedacon.bar.user.domain.User;

public interface UserDao {

	User findByUid(Integer uid);
	User findByUsername(String username);
	List<User> findByBeginAndLimt(int begin, int limit);
	List<User> findByPositionId(Integer id);
	void update(User adminUser);
	int findTotalCount();
	void save(User user);
}
