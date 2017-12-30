/**Created	by	chenshi  at	2017年12月26日 下午6:02:26*/
package annotation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.quanhu.entity.User;
import com.quanhu.service.UserService;

/**
 * @description:	Spring4Test.java
 * @packageName:	test
 * @projectName:	quanhu-spring4
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class AnnotationTest {
	private ApplicationContext act;
	private UserService	userService; 
	@Before
	public	void before(){
		act=new ClassPathXmlApplicationContext("applicationContext_annotation.xml");
		userService=(UserService)act.getBean("userService");
	}
	@After
	public void after(){
		act=null;
	}
	
	
	
	@Test
	public void	selectUser(){
		User user = userService.selectByUsernameAndPassword("zheng", "mang");
		System.out.println(user.toString());
	}
	
	@Test
	public	void login(){
		System.out.println("service  login:"+userService.login("zheng", "mang"));
	}
	
	
	
}
