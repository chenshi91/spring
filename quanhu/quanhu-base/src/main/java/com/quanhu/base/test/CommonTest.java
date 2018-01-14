/**Created	by	chenshi  at	2017年12月30日 下午8:48:09*/
package com.quanhu.base.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:	CommonTest.java
 * @packageName:	com.quanhu.base.test
 * @projectName:	quanhu-base
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class CommonTest {
	
	public	ApplicationContext	ac;
	
	public	ApplicationContext	createApplicationContext(String xmlUrl){
		return	this.ac=new	ClassPathXmlApplicationContext(xmlUrl);
	}
	
	public	void	closeApplicationContext(){
		ac=null;
	}

}
