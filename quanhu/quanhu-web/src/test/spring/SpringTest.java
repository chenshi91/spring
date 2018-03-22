/**Created	by	chenshi  at	2018年3月15日 下午10:55:10*/
package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:	SpringTest.java
 * @packageName:	spring
 * @projectName:	quanhu-web
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class SpringTest {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		Object bean = ac.getBean("dataSource");
		System.out.println(bean);
	}
	
}
