/**Created	by	chenshi  at	2017年12月22日 下午9:15:18*/
package yuanli.spring;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import yuanli.UserService;

import java.io.File;

/**
 * @description:	TestBeanPostProcessor.java
 * @packageName:	yuanli.spring
 * @projectName:	quanhu-spring3
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class TestBeanPostProcessor {

	@Test
	public	void testBeanPostProcessor(){
		String url="E:\\ideaProjects\\spring\\quanhu\\quanhu-spring3\\src\\test\\java\\yuanli\\spring\\applicationContext.xml";
		File file = new File(url);
		System.out.println(file.exists());
		ApplicationContext ctx=new ClassPathXmlApplicationContext(url);
		UserService	us=(UserService) ctx.getBean("us");
		
		us.login();
		System.out.println();
		us.regist();
	}

}
