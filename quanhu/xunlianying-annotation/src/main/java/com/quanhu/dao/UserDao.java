/**Created	by	chenshi  at	2017年12月30日 下午6:46:45*/
package com.quanhu.dao;

import org.springframework.stereotype.Repository;

import com.quanhu.base.dao.BaseDao;
import com.quanhu.entity.User;

/**
 * @description:	UserDao.java
 * @packageName:	com.quanhu.dao
 * @projectName:	xunlianying-annotation
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
@Repository(value="userDao")
public interface UserDao extends	BaseDao<User>{

}
