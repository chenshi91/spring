/**Created	by	chenshi  at	2017年12月5日 上午11:50:12*/
package org.quanhu.spring1;

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
	
	@Before
	public	void	createApplicationContext(){
		act=new		ClassPathXmlApplicationContext("applicationContext/applicationContext.xml");
	}
	
	@Test
	public	void	createObject(){
		User user = (User) act.getBean("user");
		System.out.println(user.toString());
	}
	
	@Test
	public	void	createUserService(){
		UserService userService = (UserService) act.getBean("userService");
		User user = userService.selectById(1L);
		System.out.println(user.toString());
		userService.regist("chenshi", "1234565");
	}
	
	

}
