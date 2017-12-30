/**Created	by	chenshi  at	2017年12月1日 上午10:54:10*/
package com.quanhu.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @description:	BaseDao.java
 * @packageName:	com.quanhu.activie.base.dao
 * @projectName:	common-base
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public abstract interface BaseDao<T	>{
	 Byte	insert(T	t)throws	Exception;
	 Byte	update(T	t)throws	Exception;
	 Byte	delete(Long	id)throws	Exception;
	 T		selectById(Long id);
	 List<T>	selectByIds(Long[] ids);
	 List<T>	selectAll();
	 List<T>	listByPage(@Param("pageNo")int pageNo,@Param("pageSize")int pageSize);
}
