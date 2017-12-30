/**Created	by	chenshi  at	2017年12月30日 下午6:49:52*/
package com.quanhu.service;

import com.quanhu.annotations.UserAnnotation;
import com.quanhu.base.constant.CommonConstant;
import com.quanhu.entity.User;

/**
 * @description:	UserService.java
 * @packageName:	com.quanhu.service
 * @projectName:	xunlianying-annotation
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public interface UserService {
	
	@UserAnnotation(comment = CommonConstant.VIEW_PERMISSION, userRole = { CommonConstant.DEVELOP_ROLE,CommonConstant.MANAGER_ROLE })
	User	selectById(Long id);
}
