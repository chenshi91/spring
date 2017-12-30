/**Created	by	chenshi  at	2017年12月30日 下午3:32:33*/
package com.quanhu.base.aops;

import java.lang.reflect.Method;
import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @description:	BaseServiceLogAop.java
 * @packageName:	com.quanhu.base.aops
 * @projectName:	quanhu-base
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
@Aspect
@Component
public class ServiceLogAop {
	protected Logger logger = Logger.getLogger(ServiceLogAop.class);
	
	@Around(value="execution(* com.quanhu..*.service.impl..*.*(..)) or execution(* com.quanhu.base.service.impl..*.*(..))")
	public Object	around(ProceedingJoinPoint	pjp) throws Throwable{
		/**1,获取目标对象,方法*/
		Object target = pjp.getTarget();
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		Method method = methodSignature.getMethod();
		logger.info("--------service----start:"+target.getClass()+"."+method.getName());
		Date startDate = new	Date();
		Object proceed = pjp.proceed();
		logger.info("--------service----end:"+target.getClass()+"."+method.getName()+",耗时毫秒数:"+(new Date().getTime()-startDate.getTime()));
		return	proceed;
	}
	
}
