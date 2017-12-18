/**Created	by	chenshi  at	2017年12月18日 下午4:04:22*/
package com.quanhu.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @description:	Aop.java
 * @packageName:	com.quanhu.aop
 * @projectName:	quanhu-spring3
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class Aop implements MethodInterceptor {

	/* 
	 * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
	 */
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("<--------------before    log----------------");
		
		Object proceed = invocation.proceed();
		System.out.println("--------------after    log---------------->");
		return proceed;
	}

}
