/**Created	by	chenshi  at	2018年1月5日 下午1:42:41*/
package com.quanhu.base.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description:	GrobalExceptionHandler.java
 * @packageName:	com.quanhu.base.exception
 * @projectName:	quanhu-base
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class GrobalExceptionHandler implements HandlerExceptionResolver {

	/* 
	 * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		String errorMessage=null;
		if(ex instanceof	RuntimeException){
			//RuntimeException	rx=(RuntimeException) ex;
			errorMessage=ex.getMessage();
		}
		ModelAndView mv = new	ModelAndView();
		mv.addObject("errorMessage", errorMessage);
		mv.setViewName("forward:/error.jsp");
		return mv;
	}

}
