/**Created	by	chenshi  at	2017年12月5日 上午11:50:12*/
package org.quanhu.spring2;

import org.junit.Before;
import org.junit.Test;
import org.quanhu.spring2.aop.TimeHandler;
import org.quanhu.spring2.day2.service.impl.HelloWorldImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:	Day1Test.java
 * @packageName:	org.quanhu.spring1
 * @projectName:	quanhu-spring1
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class Day2Test {
	
	private	ApplicationContext	act=null;
	
	@Before
	public	void	createApplicationContext(){
		act=new		ClassPathXmlApplicationContext("applicationContext/applicationContext.xml");
	}
	
	
	@Test
	public	void	createUserService(){
		HelloWorldImpl	helloWorld=(HelloWorldImpl) act.getBean("helloWorld");
		helloWorld.printHelloWorld();
	}
	
	@Test
	public	void	createTime(){
		TimeHandler	timeHandler=(TimeHandler) act.getBean("printTime");
		timeHandler.printStartTime();
		timeHandler.printEndTime();
	}
	

}
