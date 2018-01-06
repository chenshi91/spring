/**Created	by	chenshi  at	2017年12月1日 上午10:54:10*/
package com.quanhu.base.resource;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quanhu.base.entity.IdEntity;
import com.quanhu.base.exception.ControllerException;
import com.quanhu.base.exception.DaoException;
import com.quanhu.base.exception.ServiceException;
import com.quanhu.base.exception.SystemException;
import com.quanhu.base.service.BaseService;

/**
 * @description:	BaseResource.java
 * @packageName:	com.quanhu.activie.base.resource
 * @projectName:	common-base
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
@SuppressWarnings("serial")
public abstract class BaseController<T	extends IdEntity> implements Serializable {
	public	abstract	BaseService<T>	getService();
	
	@RequestMapping(value="base/insert",method=RequestMethod.POST)
	@ResponseBody
	public	Map<String,Byte>	insert(T t){
		try {
			getService().insert(t);
			HashMap<String, Byte> hashMap = new HashMap<String,Byte>(1);
			hashMap.put("code", (byte)200);
			return hashMap;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw	new	DaoException("dao层:insert()出现异常");
		} catch (ServiceException e) {
			e.printStackTrace();
			throw	new	ServiceException("service层:insert()出现异常");
		} catch (ControllerException e) {
			e.printStackTrace();
			throw	new	ServiceException("controller层:insert()出现异常");
		} catch (Exception e) {
			e.printStackTrace();
			throw	new	SystemException("系统出现异常");
		}
	}
	
	@RequestMapping(value="base/update",method=RequestMethod.POST)
	@ResponseBody
	public	Map<String,Byte>	update(T t,Model	model,String jspUrl){
		try {
			getService().update(t);
			HashMap<String, Byte> hashMap = new HashMap<String,Byte>(1);
			hashMap.put("code", (byte)200);
			return hashMap;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw	new	DaoException("dao层:update()出现异常");
		} catch (ServiceException e) {
			e.printStackTrace();
			throw	new	ServiceException("service层:update()出现异常");
		} catch (ControllerException e) {
			e.printStackTrace();
			throw	new	ServiceException("controller层:update()出现异常");
		} catch (Exception e) {
			e.printStackTrace();
			throw	new	SystemException("系统出现异常");
		}
	}
	
	@RequestMapping(value="base/delete",method=RequestMethod.PUT)
	@ResponseBody
	public	Map<String,Byte>	delete(Long	id){
		try {
			getService().delete(id);
			HashMap<String, Byte> hashMap = new HashMap<String,Byte>(1);
			hashMap.put("code", (byte)200);
			return hashMap;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw	new	DaoException("dao层:delete()出现异常");
		} catch (ServiceException e) {
			e.printStackTrace();
			throw	new	ServiceException("service层:delete()出现异常");
		} catch (ControllerException e) {
			e.printStackTrace();
			throw	new	ServiceException("controller层:delete()出现异常");
		} catch (Exception e) {
			e.printStackTrace();
			throw	new	SystemException("系统出现异常");
		}
	}
	
	@RequestMapping(value="base/selectById",method=RequestMethod.GET)
	public	String	selectById(Long	id,Model	model,String jspUrl){
		T t=null;
		try {
			t = getService().selectById(id);
			model.addAttribute("entity", t);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw	new	DaoException("dao层:selectById()出现异常");
		} catch (ServiceException e) {
			e.printStackTrace();
			throw	new	ServiceException("service层:selectById()出现异常");
		} catch (ControllerException e) {
			e.printStackTrace();
			throw	new	ServiceException("controller层:selectById()出现异常");
		} catch (Exception e) {
			e.printStackTrace();
			throw	new	SystemException("系统出现异常");
		}
		return	jspUrl;
	}
	
	@RequestMapping(value="base/selectByIds",method=RequestMethod.GET)
	public	String	selectByIds(Long[]	ids,Model	model,String jspUrl){
		List<T> selectByIds=null;
		try {
			selectByIds= getService().selectByIds(ids);
			model.addAttribute("list", selectByIds);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw	new	DaoException("dao层:selectByIds()出现异常");
		} catch (ServiceException e) {
			e.printStackTrace();
			throw	new	ServiceException("service层:selectByIds()出现异常");
		} catch (ControllerException e) {
			e.printStackTrace();
			throw	new	ServiceException("controller层:selectByIds()出现异常");
		} catch (Exception e) {
			e.printStackTrace();
			throw	new	SystemException("系统出现异常");
		}
		return	jspUrl;
	}
	
	@RequestMapping(value="base/listByPage",method=RequestMethod.GET)
	public	String	listByPage(Byte pageNo,Byte	pageSize,Model	model,String jspUrl){
		List<T> listByPage=null;
		try {
			listByPage= getService().listByPage(pageNo, pageSize);
			model.addAttribute("list", listByPage);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw	new	DaoException("dao层:listByPage()出现异常");
		} catch (ServiceException e) {
			e.printStackTrace();
			throw	new	ServiceException("service层:listByPage()出现异常");
		} catch (ControllerException e) {
			e.printStackTrace();
			throw	new	ServiceException("controller层:listByPage()出现异常");
		} catch (Exception e) {
			e.printStackTrace();
			throw	new	SystemException("系统出现异常");
		}
		return	jspUrl;
	}
	
	
	
}
