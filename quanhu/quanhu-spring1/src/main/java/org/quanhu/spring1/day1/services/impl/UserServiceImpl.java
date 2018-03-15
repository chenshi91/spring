/**Created	by	chenshi  at	2017年12月5日 下午2:12:31*/
package org.quanhu.spring1.day1.services.impl;

import org.quanhu.spring1.day1.dao.UserDao;
import org.quanhu.spring1.day1.entity.User;
import org.quanhu.spring1.day1.services.UserService;

/**
 * @description:	UserServicesImpl.java
 * @packageName:	org.quanhu.spring1.day1.services.impl
 * @projectName:	quanhu-spring1
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class UserServiceImpl implements UserService {
	
	private	UserDao	userDao;
	
	public User selectById(Long id) {
		System.out.println("--------userService      selectById--------");
		return userDao.selectById(id);
	}



	public void regist(String userName, String passWord) {
		System.out.println("--------userService      regist--------");
		userDao.regist(userName, passWord);
	}



	public UserDao getUserDao() {
		return userDao;
	}



	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
