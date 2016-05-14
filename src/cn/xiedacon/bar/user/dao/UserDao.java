package cn.xiedacon.bar.user.dao;

import java.util.List;

import cn.xiedacon.bar.user.domain.User;

public interface UserDao {

	User findByUid(Integer uid);
	User findByUsername(String username);
	void saveUser(User user);
	void updateUser(User user);
	int findTotalCountAll();
	List<User> findByBeginAndLimt(int begin, int limit);
	List<User> findByPosition(int i);
}
