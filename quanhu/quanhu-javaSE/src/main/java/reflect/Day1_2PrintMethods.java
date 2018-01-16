/**Created	by	chenshi  at	2018年1月16日 下午12:10:22*/
package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.junit.Test;

/**
 * @description:	day1_2reflect.java
 * @packageName:	reflect
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class Day1_2PrintMethods {
	
	/**3种通过反射得到类对象的方式*/
	@SuppressWarnings("rawtypes")
	@Test
	public void printMethodsAndFields() throws Exception{
		Class<HashMap> c1=HashMap.class;
		
		HashMap<Object, Object> hashMap = new	HashMap<>();
		Class<?> c2=hashMap.getClass();
		
		Class<?> c3=Class.forName("java.util.HashMap");
		
		System.out.println("类名:");
		System.out.println(c1.getName());
		System.out.println(c1.getSimpleName());
		System.out.println("父类类名:");
		System.out.println(c2.getSuperclass().getName());
		System.out.println("实现的接口:");
		Class[] interfaces = c3.getInterfaces();
		for (Class class1 : interfaces) {
			System.out.println(class1.getName());
		}
		System.out.println("所有的方法:");
		Method[] methods = c1.getMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
		System.out.println("属性:");
		Field[] fields = c2.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);//允许访问私有属性
			System.out.println(field.getName());
		}
//		System.out.println("类名:");
		
	}
}
