/**Created	by	chenshi  at	2017年12月27日 下午2:45:14*/
package com.quanhu.service;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.quanhu.dao.UserDao;
import com.quanhu.entity.User;

/**
 * @description:	UserServiceImpl.java
 * @packageName:	com.quanhu.service
 * @projectName:	quanhu-spring4
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class UserServiceImpl implements UserService ,ApplicationContextAware{
	/**dao修改成功返回值为1*/
	private static final int DAO_SUCCESS = 1;
	/**将工厂当作成员变量,注入到service里面,实现ApplicationContextAware接口*/
	ApplicationContext	ac;
	
	@Override
	public void setApplicationContext(ApplicationContext ac) throws BeansException {
		this.ac=ac;
	}
	
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
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Boolean login(String userName, String passWord) {
		/**拿到的是代理加工处理后的对象,不再是原始对象*/
		UserService us=(UserService) ac.getBean("userService");
		return	us.selectByUsernameAndPassword(userName, passWord)!=null?true:false;
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
	public List<User> selectPage(Byte pageNo, Byte pageSize) {
		return userDao.listByPage(pageNo, pageSize);
	}

	/* 
	 * @see com.quanhu.service.UserService#delete(java.lang.Long)
	 */
	@Override
	public Boolean deleteUser(Long id) {
		return DAO_SUCCESS==userDao.delete(id)?true:false;
	}

	/* 
	 * @see com.quanhu.service.UserService#update(com.quanhu.entity.User)
	 */
	@Override
	public Boolean updateUser(User user) {
		return DAO_SUCCESS==userDao.update(user)?true:false;
	}

	/* 
	 * @see com.quanhu.service.UserService#selectByUsernameAndPassword(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=true)
	public User selectByUsernameAndPassword(String userName, String passWord) {
		return userDao.selectByUsernameAndPassword(userName, passWord);
	}

	

}
