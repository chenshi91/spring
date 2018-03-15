/**Created	by	chenshi  at	2017年12月5日 下午2:10:42*/
package org.quanhu.spring1.day1.services;

import org.quanhu.spring1.day1.entity.User;

/**
 * @description:	UserServixe.java
 * @packageName:	org.quanhu.spring1.day1.services
 * @projectName:	quanhu-spring1
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public interface UserService {
	
	User	selectById(Long id);
	
	void	regist(String userName,String passWord);
}
