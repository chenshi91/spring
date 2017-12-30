/**Created	by	chenshi  at	2017年12月30日 下午8:43:19*/
package zhujie;

import org.junit.Before;
import org.junit.Test;

import com.quanhu.base.test.CommonTest;
import com.quanhu.service.UserService;

/**
 * @description:	ZhujieTest.java
 * @packageName:	zhujie
 * @projectName:	xunlianying-annotation
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class ZhujieTest extends	CommonTest{
	UserService	us;
	
	@Before
	public	void	before(){
		createApplicationContext("spring-mybatis.xml");
	}
	
	@Test
	public	void	selectUser(){
		us=(UserService) ac.getBean("us");
		System.out.println(us.selectById(1L).toString());
	}

}
