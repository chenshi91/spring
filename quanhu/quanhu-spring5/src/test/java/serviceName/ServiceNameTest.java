/**Created	by	chenshi  at	2017年12月26日 下午6:02:26*/
package serviceName;

import java.util.List;

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
public class ServiceNameTest {
	private ApplicationContext act;
	private UserService	userService; 
	@Before
	public	void before(){
		act=new ClassPathXmlApplicationContext("applicationContext_serviceName.xml");
		userService=(UserService)act.getBean("userService");
	}
	@After
	public void after(){
		act=null;
	}
	
	
	
	@Test
	public void	deleteUser(){
		System.out.println("service deleteUser:"+userService.deleteUser(16L));
	}
	
	@Test
	public	void updateUser(){
		System.out.println("service  updateUser:"+userService.updateUser(new User(15L, "zhengmang", "chens")));
	}
	
	
	@Test
	public	void	listByPage(){
		List<User> list = userService.selectPage((byte)1, (byte)10);
		for (User user : list) {
			System.out.println(user.toString());
		}
	}
}
