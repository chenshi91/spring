/**Created	by	chenshi  at	2017年12月27日 下午2:45:14*/
package com.quanhu.service;

import java.util.List;

import com.quanhu.dao.UserDao;
import com.quanhu.entity.User;

/**
 * @description:	UserServiceImpl.java
 * @packageName:	com.quanhu.service
 * @projectName:	quanhu-spring4
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class UserServiceImpl implements UserService {
	
	UserDao	userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/* 
	 * @see com.quanhu.service.UserService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public Boolean login(String userName, String passWord) {
		return	selectByUsernameAndPassword(userName, passWord)!=null?true:false;
	}

	/* 
	 * @see com.quanhu.service.UserService#regist(com.quanhu.entity.User)
	 */
	@Override
	public Boolean regist(User user) {

		return userDao.insert(user)!=null?true:false;
	}

	/* 
	 * @see com.quanhu.service.UserService#listByPage(java.lang.Byte, java.lang.Byte)
	 */
	@Override
	public List<User> listByPage(Byte pageNo, Byte pageSize) {

		return userDao.listByPage(pageNo, pageSize);
	}

	/* 
	 * @see com.quanhu.service.UserService#delete(java.lang.Long)
	 */
	@Override
	public Boolean delete(Long id) {

		return 1==userDao.delete(id)?true:false;
	}

	/* 
	 * @see com.quanhu.service.UserService#update(com.quanhu.entity.User)
	 */
	@Override
	public Boolean update(User user) {

		return 1==userDao.update(user)?true:false;
	}

	/* 
	 * @see com.quanhu.service.UserService#selectByUsernameAndPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public User selectByUsernameAndPassword(String userName, String passWord) {

		return userDao.selectByUsernameAndPassword(userName, passWord);
	}

}
