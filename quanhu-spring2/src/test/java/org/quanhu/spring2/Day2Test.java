/**Created	by	chenshi  at	2017年12月5日 上午11:50:12*/
package org.quanhu.spring2;

import org.junit.Before;
import org.junit.Test;
import org.quanhu.spring2.aop.AopMethodInteception;
import org.quanhu.spring2.aop.TimeHandler;
import org.quanhu.spring2.day2.service.HelloWorld;
import org.quanhu.spring2.day2.service.impl.HelloWorldImpl;
import org.springframework.aop.framework.ProxyFactory;
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
	public	void	createHelloWorld(){
		HelloWorldImpl	helloWorld=(HelloWorldImpl) act.getBean("helloWorld");
		helloWorld.printHelloWorld();
	}
	
	@Test
	public	void	createTime(){
		TimeHandler	timeHandler=(TimeHandler) act.getBean("printTime");
		timeHandler.printStartTime();
		timeHandler.printEndTime();
	}
	
	@Test
	public	void	proxyFactory(){
		ProxyFactory proxyFactory = new	ProxyFactory();//创建代理工厂
		proxyFactory.setTarget(new HelloWorldImpl());//设置原始类
		proxyFactory.addAdvice(new TimeHandler());//添加额外功能
		
		HelloWorldImpl	hellowWorldImpl=(HelloWorldImpl) proxyFactory.getProxy();//从代理工厂中获取代理对象
		hellowWorldImpl.printHelloWorld();
		System.out.println("----------------------------------------------------");
		hellowWorldImpl.doPrint();
	}
	
	@Test
	public void methodInterceptor(){
		ProxyFactory proxyFactory = new	ProxyFactory();//创建代理工厂
		proxyFactory.setTarget(new HelloWorldImpl());//设置原始类
		proxyFactory.addAdvice(new AopMethodInteception());//添加额外功能
		
		HelloWorld	helloWorld=(HelloWorld) proxyFactory.getProxy();//从代理工厂中拿到代理对象
		helloWorld.printHelloWorld();
		System.out.println();
		System.out.println();
		helloWorld.doPrint();
	}
	
	public void xml(){
		act.getBean("helloWorldProxy");
	}

}
