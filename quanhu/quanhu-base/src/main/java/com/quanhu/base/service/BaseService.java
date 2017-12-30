/**Created	by	chenshi  at	2017年12月1日 上午10:54:10*/
package com.quanhu.base.service;

import java.io.Serializable;
import java.util.List;


/**
 * @description:	BaseService.java
 * @packageName:	com.quanhu.activie.base.service
 * @projectName:	common-base
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public abstract interface BaseService<T> extends Serializable {
	 void	insert(T	t)throws	Exception;
	 void	update(T	t)throws	Exception;
	 void	delete(Long	id)throws	Exception;
	 T		selectById(Long id);
	 List<T>	selectByIds(Long[] ids);
	 List<T>	selectAll();
	 List<T>	listByPage(Byte pageNo,Byte pageSize);
}
