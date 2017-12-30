/**Created	by	chenshi  at	2017年12月30日 下午6:50:57*/
package com.quanhu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.quanhu.dao.UserDao;
import com.quanhu.entity.User;
import com.quanhu.service.UserService;

/**
 * @description:	UserServiceImpl.java
 * @packageName:	com.quanhu.service.impl
 * @projectName:	xunlianying-annotation
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
@Transactional
@Service(value="us")
public class UserServiceImpl implements UserService {
	
	@Resource(name="userDao")
	UserDao	userdao;
	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public User selectById(Long id) {
		return userdao.selectById(id);
	}

}
