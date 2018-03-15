/**Created	by	chenshi  at	2017年12月5日 下午2:15:30*/
package org.quanhu.spring1.day1.dao;

import org.quanhu.spring1.day1.entity.User;

/**
 * @description:	UserDaoImpl.java
 * @packageName:	org.quanhu.spring1.day1.dao
 * @projectName:	quanhu-spring1
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class UserDaoImpl implements UserDao {

	
	public User selectById(Long id) {
		System.out.println("--------userDao      selectById--------");
		return new	User(id, "admin", "admin");
	}

	public void regist(String userName, String passWord) {
		System.out.println("--------userDao      regist--------");
	}

}
