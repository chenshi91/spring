/**Created	by	chenshi  at	2017年12月22日 下午8:29:30*/
package yuanli.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

import yuanli.UserService;
import yuanli.UserServiceImpl;

/**
 * @description:	TestJdkProxy.java
 * @packageName:	yuanli.jdk
 * @projectName:	quanhu-spring3
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class TestJdkProxy {
	
	@Test
	public void testJdkProxy(){
		UserService userServiceImpl = new	UserServiceImpl();
		
		InvocationHandler invocationHandler = new	InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("--------JdkProxy     log-----------------");
				Object invoke = method.invoke(userServiceImpl, args);
				return invoke;
			}
		};
		
		/**
		 * JDK底层Proxy方法
		 *
		 * 1,借用classLoader
		 * 2,原始对象所实现的接口
		 * 3,额外功能InvocationHandler
		 */
		UserService	us=(UserService) Proxy.newProxyInstance(TestJdkProxy.class.getClassLoader(), 
				userServiceImpl.getClass().getInterfaces(),
				invocationHandler);
		
		us.login();
		System.out.println();
		us.regist();
	}
}
