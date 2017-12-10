/**Created	by	chenshi  at	2017年12月5日 上午11:50:12*/
package org.quanhu.spring1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.quanhu.spring1.day1.entity.User;
import org.quanhu.spring1.day1.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:	Day1Test.java
 * @packageName:	org.quanhu.spring1
 * @projectName:	quanhu-spring1
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class Day1Test {
	
	private	ApplicationContext	act=null;
	private	InputStream inputStream=null;
	private	Properties properties = null;
	
	@Before
	public	void	createApplicationContext(){
		act=new		ClassPathXmlApplicationContext("applicationContext/applicationContext.xml");
		try {
			inputStream = getClass().getResourceAsStream("/config/jdbc.properties");
			properties = new	Properties();
			properties.load(inputStream);
		} catch (IOException e) {
			System.out.println("捕获带了io异常");
			e.printStackTrace();
		}
	}
	
	@After
	public void colseResource(){
		inputStream=null;
		act=null;
		properties=null;
	}
	
	@Test
	public	void	createUser(){
		User user = (User) act.getBean("user");
		System.out.println(user.toString());
	}
	
	@Test
	public	void	createUser2(){
		User user = (User) act.getBean("user2");
		System.out.println(user.toString());
	}
	
	@Test
	public	void	createUserService(){
		UserService userService = (UserService) act.getBean("userService");
		User user = userService.selectById(1L);
		System.out.println(user.toString());
		userService.regist("chenshi", "1234565");
	}
	
	@Test
	public	void	properties(){
		Set<Entry<Object, Object>> entrySet = properties.entrySet();
		for (Entry<Object, Object> entry : entrySet) {
			System.out.println(entry.getKey()+"="+entry.getValue());
		} 
		System.out.println(properties.get("username").toString());
	}
	

}
