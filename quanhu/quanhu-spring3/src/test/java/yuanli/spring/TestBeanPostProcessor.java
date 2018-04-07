/**Created	by	chenshi  at	2017年12月22日 下午9:15:18*/
package yuanli.spring;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import yuanli.UserService;

/**
 * @description:	TestBeanPostProcessor.java
 * @packageName:	yuanli.spring
 * @projectName:	quanhu-spring3
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class TestBeanPostProcessor {
	
	private	ApplicationContext ctx=null;
	
	@Before
	public void	before(){
		ctx=new ClassPathXmlApplicationContext("classpath:yuanli/spring/applicationContext.xml");
	}
	
	@After
	public	void	After(){
		ctx=null;
	}
	
	@Test
	public	void testBeanPostProcessor(){
		UserService	us=(UserService) ctx.getBean("us");
		
		us.login();
		System.out.println();
		us.regist();
	}

}
