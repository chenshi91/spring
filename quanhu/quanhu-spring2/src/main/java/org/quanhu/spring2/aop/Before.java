/**Created	by	chenshi  at	2017年12月13日 上午9:39:03*/
package org.quanhu.spring2.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @description:	Before.java
 * @packageName:	org.quanhu.spring2.aop
 * @projectName:	quanhu-spring2
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class Before implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] objects, Object o) throws Throwable {
		System.out.println("---------log");
	}
}
