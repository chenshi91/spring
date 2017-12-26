/**Created	by	chenshi  at	2017年12月26日 下午6:02:26*/
package jdbcTemplate;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.quanhu.dao.UserDao;
import com.quanhu.entity.User;

/**
 * @description:	Spring4Test.java
 * @packageName:	test
 * @projectName:	quanhu-spring4
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class Spring4Test {
	private ApplicationContext act;
	private UserDao	userDao; 
	@Before
	public	void before(){
		act=new ClassPathXmlApplicationContext("applicationContext.xml");
		userDao=(UserDao)act.getBean("userDao");
	}
	@After
	public void after(){
		act=null;
	}
	
	@Test
	public void insertUser(){
		userDao.insert(new User(null, "zheng3", "mang3"));
	}
	
	@Test
	public void	deleteUser(){
		userDao.delete(2L);
	}
	
	@Test
	public	void updateUser(){
		userDao.update(new User(3L, "zhengmang", "chens"));
	}
	
	@Test
	public void	selectUser(){
		User user = userDao.selectByUsernameAndPassword("zhengmang", "chens");
		System.out.println(user.toString());
	}
	
	@Test
	public	void	listByPage(){
		List<User> list = userDao.listByPage((byte)2,(byte) 5);
		for (User user : list) {
			System.out.println(user.toString());
		}
	}
}
