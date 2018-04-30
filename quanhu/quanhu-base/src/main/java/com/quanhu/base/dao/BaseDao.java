/**Created	by	chenshi  at	2017年12月1日 上午10:54:10*/
package com.quanhu.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

/**
 * @description:	BaseDao.java
 * @packageName:	com.quanhu.activie.base.dao
 * @projectName:	common-base
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public abstract interface BaseDao<T	>{
	 int	insert(T	t)throws	DataAccessException;
	 int	update(T	t)throws	DataAccessException;
	 int	delete(Long	id)throws	DataAccessException;
	 T		selectById(Long id)throws	DataAccessException;;
	 List<T>	selectByIds(Long[] ids)throws	DataAccessException;;
	 List<T>	selectAll()throws	DataAccessException;;
	 List<T>	listByPage(@Param("pageNo")int pageNo,@Param("pageSize")int pageSize)throws	DataAccessException;;
}
