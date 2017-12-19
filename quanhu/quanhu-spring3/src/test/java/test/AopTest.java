/**Created	by	chenshi  at	2017年12月18日 下午2:11:51*/
package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.quanhu.service.MyService;
import com.quanhu.service.impl.MyServiceImpl2;

/**
 * @description:	AopTest.java
 * @packageName:	test
 * @projectName:	quanhu-spring3
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class AopTest {
	ApplicationContext	ac=null;
	MyService	myService=null;
	MyServiceImpl2	myService2=null;
	
	@Before
	public void createFactory(){
		ac=new ClassPathXmlApplicationContext("/config/applicationContext.xml");
		myService=(MyService)ac.getBean("myService");
		myService2=(MyServiceImpl2)ac.getBean("myService2");
	}
	
	@After
	public void closeFactory(){
		ac=null;
	}
	
	@Test
	public void aopTest(){
		myService.regist();
		syso3();
		myService.login();
		syso3();
		myService.m1("meng");
		syso3();
		myService.m2("chen", "shen");
		
	}

	private void syso3() {
		for (int i = 0; i < 3; i++) {
			System.out.println();
		}
	}
	
	@Test
	public void aopTest2(){
		myService2.selectById(110L);
	}
	
}
