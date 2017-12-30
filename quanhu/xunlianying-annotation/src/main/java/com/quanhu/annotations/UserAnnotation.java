/**Created	by	chenshi  at	2017年12月30日 下午6:57:32*/
package com.quanhu.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD,ElementType.PARAMETER})
/**
 * @description:	UserAnnotation.java
 * @packageName:	com.quanhu.annotations
 * @projectName:	xunlianying-annotation
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public @interface UserAnnotation {
	String[]	userRole();
	String		comment();
}
