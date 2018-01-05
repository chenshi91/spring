/**Created	by	chenshi  at	2017年12月1日 上午10:54:10*/
package com.quanhu.base.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.quanhu.base.annotations.RedisAnnotation;
import com.quanhu.base.dao.BaseDao;
import com.quanhu.base.entity.IdEntity;
import com.quanhu.base.exception.DaoException;
import com.quanhu.base.exception.ServiceException;
import com.quanhu.base.exception.SystemException;
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
		try {
			getDao().insert(t);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw	new	DaoException("dao层:insert()出现异常");
		} catch (ServiceException e) {
			e.printStackTrace();
			throw	new	ServiceException("service层:insert()出现异常");
		} catch (Exception e) {
			e.printStackTrace();
			throw	new	SystemException("系统出现异常");
		}
	};
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public void	update(T	t){
		if(t==null){
			throw	new	ServiceException("update对象不能为空");
		}else if (t.getId()==null) {
			throw	new	ServiceException("update id不能为空");
		}
		try {
			getDao().update(t);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw	new	DaoException("dao层:update()出现异常");
		} catch (ServiceException e) {
			e.printStackTrace();
			throw	new	ServiceException("service层:update()出现异常");
		} catch (Exception e) {
			e.printStackTrace();
			throw	new	SystemException("系统出现异常");
		}
	};
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public void	delete(Long	id){
		if(id==null){
			throw	new	ServiceException("delete id不能为空");
		}
		try {
			getDao().delete(id);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw	new	DaoException("dao层:delete()出现异常");
		} catch (ServiceException e) {
			e.printStackTrace();
			throw	new	ServiceException("service层:delete()出现异常");
		} catch (Exception e) {
			e.printStackTrace();
			throw	new	SystemException("系统出现异常");
		}
	};
	
	@RedisAnnotation(effectiveTime = "24*60*60")
	@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
	public T		selectById(Long id){
		if(id==null){
			throw	new	ServiceException("selectById id不能为空");
		}
		T	t=null;
		try {
			t = getDao().selectById(id);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw	new	DaoException("dao层:selectById()出现异常");
		} catch (ServiceException e) {
			e.printStackTrace();
			throw	new	ServiceException("service层:selectById()出现异常");
		} catch (Exception e) {
			e.printStackTrace();
			throw	new	SystemException("系统出现异常");
		}
		return	t;
	};
	
	@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
	public List<T>	selectByIds(Long[] ids){
		if(ids==null){
			throw	new	ServiceException("selectByIds ids不能为空");
		}
		List<T> list=null;
		try {
			 list= getDao().selectByIds(ids);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw	new	DaoException("dao层:selectByIds()出现异常");
		} catch (ServiceException e) {
			e.printStackTrace();
			throw	new	ServiceException("service层:selectByIds()出现异常");
		} catch (Exception e) {
			e.printStackTrace();
			throw	new	SystemException("系统出现异常");
		}
		return	list;
	};
	
	@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
	public List<T>	selectAll(){
		List<T> list=null;
		try {
			 list= getDao().selectAll();
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw	new	DaoException("dao层:selectAll()出现异常");
		} catch (ServiceException e) {
			e.printStackTrace();
			throw	new	ServiceException("service层:selectAll()出现异常");
		} catch (Exception e) {
			e.printStackTrace();
			throw	new	SystemException("系统出现异常");
		}
		return	list;
	};
	
	@RedisAnnotation(effectiveTime = "24*60*60")
	@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
	public List<T>	listByPage(Byte pageNo,Byte pageSize){
		List<T> list=null;
		try {
			if(pageNo==null||pageSize==null||pageNo<1||pageSize<1){
				throw	new	ServiceException("pageNo或pageSize输入不符合规范");
			}
			list= getDao().listByPage((pageNo-1)*pageSize,pageSize);
		}catch (DataAccessException e) {
			e.printStackTrace();
			throw	new	DaoException("dao层:listByPage()出现异常");
		}catch (ServiceException e) {
			e.printStackTrace();
			throw	new	ServiceException("service层:listByPage()出现异常");
		}catch (Exception e) {
			e.printStackTrace();
			throw	new	SystemException("系统出现异常");
		}
		return	list;
	};
	
	
}
