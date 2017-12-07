/**Created	by	chenshi  at	2017年12月7日 下午1:59:23*/
package org.quanhu.spring2.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @description:	AopMethodInteception.java
 * @packageName:	org.quanhu.spring2.aop
 * @projectName:	quanhu-spring2
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class AopMethodInteception implements MethodInterceptor {

	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		before();
		Object object = methodInvocation.proceed();
		after();
		return object;
	}
	
	public	void	before(){
		System.out.println("-----aop     before------------");
	}
	
	public void after(){
		System.out.println("-----aop     after------------");
	}
	

}
