/**Created	by	chenshi  at	2017年12月18日 上午11:48:29*/
package com.quanhu.annotations;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target(ElementType.METHOD)
/**
 * @description:	Log.java
 * @packageName:	com.quanhu.annotations
 * @projectName:	quanhu-spring3
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public @interface Log {
	String name() default "chen";
	String value();
}
