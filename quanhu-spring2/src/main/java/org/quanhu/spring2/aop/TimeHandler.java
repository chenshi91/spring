/**Created	by	chenshi  at	2017年12月5日 下午3:33:20*/
package org.quanhu.spring2.aop;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * @description:	TimeHandler.java
 * @packageName:	org.quanhu.spring2.aop
 * @projectName:	quanhu-spring2
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class TimeHandler implements	MethodBeforeAdvice,AfterReturningAdvice{
	
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("printEndTime:" + new	SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new	Date(System.currentTimeMillis())));
	}

	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("printStartTime:" + new	SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new	Date(System.currentTimeMillis())));
	}
	
	public	void	printStartTime(){
		System.out.println("printStartTime:" + new	SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new	Date(System.currentTimeMillis())));
	}
	
	public	void	printEndTime(){
		System.out.println("printEndTime: " + new	SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new	Date(System.currentTimeMillis())));
	}
}
