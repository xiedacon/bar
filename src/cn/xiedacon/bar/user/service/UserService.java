package cn.xiedacon.bar.user.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.xiedacon.bar.user.domain.User;
import cn.xiedacon.bar.util.PageBean;
@Transactional
public interface UserService {

	User findByUid(Integer uid);
	User findByUsername(String username);
	void regist(User user);
	PageBean<User> findAllByPage(Integer page);
	List<User> findAdminAll();
	void updateUser(User user);
}
