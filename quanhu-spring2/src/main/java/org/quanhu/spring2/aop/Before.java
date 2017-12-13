/**Created	by	chenshi  at	2017年12月13日 上午9:39:03*/
package org.quanhu.spring2.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * @description:	Before.java
 * @packageName:	org.quanhu.spring2.aop
 * @projectName:	quanhu-spring2
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class Before implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("-----------before    log---------------");
		method.invoke(target, args);
	}

}
