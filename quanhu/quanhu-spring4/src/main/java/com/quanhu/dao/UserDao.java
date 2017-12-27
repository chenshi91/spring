/**Created	by	chenshi  at	2017年12月26日 下午5:01:17*/
package com.quanhu.dao;

import java.util.List;

import com.quanhu.entity.User;

/**
 * @description:	UserDao.java
 * @packageName:	com.quanhu.dao
 * @projectName:	quanhu-spring4
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public interface UserDao {
	Byte	insert(User user);
	Byte	delete(Long id);
	Byte	update(User user);
	User	selectByUsernameAndPassword(String userName,String passWord);
	List<User>	listByPage(Byte pageNo,Byte pageSize);
}
