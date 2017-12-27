/**Created	by	chenshi  at	2017年12月26日 下午6:02:26*/
package dataSourceTransactionManager;

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
public class TransactionManagerTest {
	private ApplicationContext act;
	private UserService	userService; 
	@Before
	public	void before(){
		act=new ClassPathXmlApplicationContext("applicationContext.xml");
		userService=(UserService)act.getBean("userService");
	}
	@After
	public void after(){
		act=null;
	}
	
	@Test
	public void insertUser(){
		System.out.println("service insertUser:"+userService.regist(new User(null, "chens", "555")));
	}
	
//	@Test
//	public void	deleteUser(){
//		userDao.delete(2L);
//	}
//	
//	@Test
//	public	void updateUser(){
//		System.out.println("updateUser,dao返回值:"+userDao.update(new User(3L, "zhengmang", "chens")));
//	}
//	
	@Test
	public void	selectUser(){
		System.out.println("sevice login:"+userService.login("chens", "666"));
	}
	
//	@Test
//	public	void	listByPage(){
//		List<User> list = userDao.listByPage((byte)2,(byte) 5);
//		for (User user : list) {
//			System.out.println(user.toString());
//		}
//	}
}
