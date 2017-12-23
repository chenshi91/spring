/**Created	by	chenshi  at	2017年12月22日 下午8:48:28*/
package yuanli.cglib;

import java.lang.reflect.Method;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import yuanli.UserService;
import yuanli.UserServiceImpl;

/**
 * @description:	TestCglibProxy.java
 * @packageName:	yuanli.cglib
 * @projectName:	quanhu-spring3
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class TestCglibProxy {
	
	@Test
	public void testCglibProxy(){
		UserService userServiceImpl = new	UserServiceImpl();
		
		Enhancer enhancer = new	Enhancer();
		/**1,设置父类*/
		enhancer.setSuperclass(userServiceImpl.getClass());
		
		InvocationHandler invocationHandler = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("--------cglibProxy     log-------");
				Object invoke = method.invoke(userServiceImpl, args);
				return invoke;
			}
		};
		
		/**2,设置额外功能*/
		enhancer.setCallback(invocationHandler);
		
		/**3,获取原始对象*/
		UserService	us=(UserService)enhancer.create();
		us.login();
		System.out.println();
		us.regist();
	}

}
