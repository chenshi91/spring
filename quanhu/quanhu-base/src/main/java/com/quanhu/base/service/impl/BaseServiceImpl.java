/**Created	by	chenshi  at	2017年12月1日 上午10:54:10*/
package com.quanhu.base.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.quanhu.base.dao.BaseDao;
import com.quanhu.base.service.BaseService;

/**
 * @description:	BaseServiceImpl.java
 * @packageName:	com.quanhu.activie.base.service.impl
 * @projectName:	common-base
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public abstract class BaseServiceImpl<T>	implements	BaseService<T> {
	
	protected Logger logger = Logger.getLogger(BaseServiceImpl.class);
	
	private static final long serialVersionUID = -6649329735350511119L;

	public abstract	BaseDao<T>	getDao();
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void	insert(T	t)throws	Exception{
		try {
			getDao().insert(t);
		} catch (Exception e) {
			System.out.println("baseService逻辑异常!");
			e.printStackTrace();
		}
	};
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void	update(T	t)throws	Exception{
		try {
			getDao().update(t);
		} catch (Exception e) {
			System.out.println("baseService逻辑异常!");
			e.printStackTrace();
		}
	};
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void	delete(Long	id)throws	Exception{
		try {
			getDao().delete(id);
		} catch (Exception e) {
			System.out.println("baseService逻辑异常!");
			e.printStackTrace();
		}
	};
	
	@Transactional(readOnly=true)
	public T		selectById(Long id){
		T	t=null;
		try {
			t = getDao().selectById(id);
		} catch (Exception e) {
			System.out.println("baseService逻辑异常!");
			e.printStackTrace();
		}
		return	t;
	};
	
	@Transactional(readOnly=true)
	public List<T>	selectByIds(Long[] ids){
		List<T> list=null;
		try {
			 list= getDao().selectByIds(ids);
		} catch (Exception e) {
			System.out.println("baseService逻辑异常!");
			e.printStackTrace();
		}
		return	list;
	};
	
	
}
