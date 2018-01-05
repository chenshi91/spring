/**Created	by	chenshi  at	2017年12月1日 上午10:54:10*/
package com.quanhu.base.service;

import java.io.Serializable;
import java.util.List;

import com.quanhu.base.entity.IdEntity;
import com.quanhu.base.exception.ServiceException;


/**
 * @description:	BaseService.java
 * @packageName:	com.quanhu.activie.base.service
 * @projectName:	common-base
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public abstract interface BaseService<T	extends IdEntity> extends Serializable {
	 void	insert(T	t)throws	ServiceException;
	 void	update(T	t)throws	ServiceException;
	 void	delete(Long	id)throws	ServiceException;
	 T		selectById(Long id)throws	ServiceException;
	 List<T>	selectByIds(Long[] ids)throws	ServiceException;
	 List<T>	selectAll()throws	ServiceException;
	 List<T>	listByPage(Byte pageNo,Byte pageSize)throws	ServiceException;
}
