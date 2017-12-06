/**Created	by	chenshi  at	2017年12月5日 下午2:08:22*/
package org.quanhu.spring1.day1.dao;

import org.quanhu.spring1.day1.entity.User;

/**
 * @description:	UserDao.java
 * @packageName:	org.quanhu.spring1.day1
 * @projectName:	quanhu-spring1
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public interface UserDao {
	User	selectById(Long id);
	
	void	regist(String userName,String passWord);
}
