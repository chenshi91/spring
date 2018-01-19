/**Created	by	chenshi  at	2018年1月1日 上午10:01:31*/
package com.quanhu.base.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
/**
 * @description:	RedisAnnotation.java
 * @packageName:	com.quanhu.base.annotations
 * @projectName:	quanhu-base
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public @interface RedisAnnotation {
	
	String	effectiveTime();
	@SuppressWarnings("rawtypes")
	Class	returnResult();
	
}
