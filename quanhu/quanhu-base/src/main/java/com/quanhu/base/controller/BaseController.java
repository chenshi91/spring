/**Created	by	chenshi  at	2017年12月1日 上午10:54:10*/
package com.quanhu.base.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
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
	protected Logger logger = Logger.getLogger(BaseController.class);
	
	public	abstract	BaseService<T>	getService();
	
	@RequestMapping(value="base/insert",method=RequestMethod.POST)
	@ResponseBody
	public	Map<String,String>	insert(T t){
		HashMap<String, String> hashMap = new HashMap<String,String>(1);
		try {
			getService().insert(t);
			hashMap.put("code", "200");
			hashMap.put("message", "success");
			return hashMap;
		} catch (DataAccessException e) {
//			e.printStackTrace();
			logger.info("------------dao层:insert()出现异常:"+e.getMessage());
			hashMap.put("code", "500");
			hashMap.put("message", "dao层:insert()出现异常:"+e.getMessage());
			return hashMap;
		} catch (ServiceException e) {
			logger.info("------------service层:insert()出现异常:"+e.getMessage());
			hashMap.put("code", "500");
			hashMap.put("message", "service层:insert()出现异常:"+e.getMessage());
			return hashMap;
		} catch (ControllerException e) {
			logger.info("------------controller层:insert()出现异常:"+e.getMessage());
			hashMap.put("code", "500");
			hashMap.put("message", "controller层:insert()出现异常:"+e.getMessage());
			return hashMap;
		} catch (Exception e) {
			logger.info("------------系统出现异常");
			hashMap.put("code", "500");
			hashMap.put("message", "系统出现异常");
			return hashMap;
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
		HashMap<String, Byte> hashMap = new HashMap<String,Byte>(1);
		try {
			getService().delete(id);
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
