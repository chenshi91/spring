/**Created	by	chenshi  at	2017年12月22日 下午9:10:04*/
package yuanli.spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @description:	MyBeanPostProcessor.java
 * @packageName:	yuanli.spring
 * @projectName:	quanhu-spring3
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String id) throws BeansException {
		/**2,对bean进行加工*/
		InvocationHandler invocationHandler = new InvocationHandler() {
			@Override
			public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
				System.out.println("----------------spring log------------------");
				/*对原接口调用*/
				Object invoke = method.invoke(bean, args);
				return invoke;
			}
		};
		Object newProxyInstance = Proxy.newProxyInstance(MyBeanPostProcessor.class.getClassLoader(),
				bean.getClass().getInterfaces(), invocationHandler);
		
		return newProxyInstance;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String id) throws BeansException {
		/**1,原结果不变,照常返回给spring*/
		return bean;
	}

}
