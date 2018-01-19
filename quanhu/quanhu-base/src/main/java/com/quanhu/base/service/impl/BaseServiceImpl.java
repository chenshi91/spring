/**Created	by	chenshi  at	2017年12月1日 上午10:54:10*/
package com.quanhu.base.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.quanhu.base.dao.BaseDao;
import com.quanhu.base.entity.IdEntity;
import com.quanhu.base.exception.ServiceException;
import com.quanhu.base.service.BaseService;

/**
 * @description:	BaseServiceImpl.java
 * @packageName:	com.quanhu.activie.base.service.impl
 * @projectName:	common-base
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public abstract class BaseServiceImpl<T	extends IdEntity>	implements	BaseService<T> {
	
	protected Logger logger = Logger.getLogger(BaseServiceImpl.class);
	
	private static final long serialVersionUID = -6649329735350511119L;

	public abstract	BaseDao<T>	getDao();
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public void	insert(T	t){
		if(t==null){
			throw	new	ServiceException("insert对象不能为空");
		}
		getDao().insert(t);
	};
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public void	update(T	t){
		if(t==null){
			throw	new	ServiceException("update对象不能为空");
		}else if (t.getId()==null) {
			throw	new	ServiceException("update id不能为空");
		}
		getDao().update(t);
	};
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public void	delete(Long	id){
		if(id==null){
			throw	new	ServiceException("delete id不能为空");
		}
		getDao().delete(id);
	};
	
	@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
	public T		selectById(Long id){
		if(id==null){
			throw	new	ServiceException("selectById id不能为空");
		}
		return	getDao().selectById(id);
	};
	
	@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
	public List<T>	selectByIds(Long[] ids){
		if(ids==null){
			throw	new	ServiceException("selectByIds ids不能为空");
		}
		return	getDao().selectByIds(ids);
	};
	
	@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
	public List<T>	selectAll(){
		return	getDao().selectAll();
	};
	
	@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
	public List<T>	listByPage(Byte pageNo,Byte pageSize){
		if(pageNo==null||pageSize==null||pageNo<1||pageSize<1){
			throw	new	ServiceException("pageNo或pageSize输入不符合规范");
		}
		return	getDao().listByPage((pageNo-1)*pageSize,pageSize);
	};
	
	
}
