/**Created	by	chenshi  at	2017年12月5日 上午11:50:12*/
package org.quanhu.spring2;

import org.junit.After;
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
		act=new		ClassPathXmlApplicationContext("classpath:/applicationContext/applicationContext.xml");
	}
	
	@After
	public void closeResource(){
		act=null;
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
		//创建代理工厂
		ProxyFactory proxyFactory = new	ProxyFactory();
		//设置原始类
		proxyFactory.setTarget(new HelloWorldImpl());
		//添加额外功能
		proxyFactory.addAdvice(new TimeHandler());
		
		//从代理工厂中获取代理对象
		HelloWorldImpl	hellowWorldImpl=(HelloWorldImpl) proxyFactory.getProxy();
		hellowWorldImpl.printHelloWorld();
		System.out.println("----------------------------------------------------");
		hellowWorldImpl.doPrint();
	}
	
	@Test
	public void methodInterceptor(){
		//创建代理工厂
		ProxyFactory proxyFactory = new	ProxyFactory();
		//设置原始类
		proxyFactory.setTarget(new HelloWorldImpl());
		//添加额外功能
		proxyFactory.addAdvice(new AopMethodInteception());
		//从代理工厂中拿到代理对象
		HelloWorld	helloWorld=(HelloWorld) proxyFactory.getProxy();
		
		helloWorld.printHelloWorld();
		System.out.println();
		System.out.println();
		helloWorld.doPrint();
	}
	
	@Test
	public void xml(){
		act.getBean("helloWorldProxy");
	}

}
