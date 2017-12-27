/**Created	by	chenshi  at	2017年12月27日 下午2:27:47*/
package com.quanhu.service;

import java.util.List;

import com.quanhu.entity.User;

/**
 * @description:	UserService.java
 * @packageName:	com.quanhu.service
 * @projectName:	quanhu-spring4
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public interface UserService {
	
	Boolean	login(String userName,String passWord);
	Boolean	regist(User	user);
	List<User>	listByPage(Byte pageNo,Byte pageSize);
	Boolean	delete(Long id);
	Boolean	update(User user);
	User	selectByUsernameAndPassword(String userName,String passWord);
}
