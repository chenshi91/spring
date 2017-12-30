/**Created	by	chenshi  at	2017年12月30日 下午9:04:53*/
package com.quanhu.aop;

import java.lang.reflect.Method;
import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.quanhu.annotations.UserAnnotation;

/**
 * @description:	Aop.java
 * @packageName:	com.quanhu.aop
 * @projectName:	xunlianying-annotation
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
@Component
@Aspect
public class AnnotationAop {
	protected Logger logger = Logger.getLogger(AnnotationAop.class);
	
	@Around(value="execution(* com.quanhu.service.impl..*.*(..))")
	public Object	around(ProceedingJoinPoint	pjp) throws Throwable{
		Object target = pjp.getTarget();//获取目标对象
		MethodSignature methodSinature = (MethodSignature) pjp.getSignature();
		Method method = methodSinature.getMethod();//获取调用方法
		logger.info("--------service----start:"+target.getClass()+"."+method.getName());
		if(method.isAnnotationPresent(UserAnnotation.class)){//如果方法上存在自定义注解
			logger.info("做权限判断...");
			UserAnnotation annotation = method.getAnnotation(UserAnnotation.class);
			String[] userRole = annotation.userRole();
			for (String string : userRole) {
				logger.info(string);
			}
			String comment = annotation.comment();
			logger.info(comment);
		}
		Date startDate = new	Date();
		Object proceed = pjp.proceed();
		logger.info("--------service----end:"+target.getClass()+"."+method.getName()+",耗时毫秒数:"+(new Date().getTime()-startDate.getTime()));
		return	proceed;
	}

}
