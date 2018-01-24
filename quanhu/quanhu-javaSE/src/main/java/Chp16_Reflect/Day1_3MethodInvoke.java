/**Created	by	chenshi  at	2018年1月16日 下午5:40:04*/
package Chp16_Reflect;

import java.lang.reflect.Method;

import org.junit.Test;

/**
 * @description:	day1_3methodInvoke.java
 * @packageName:	reflect
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class Day1_3MethodInvoke {
	
	@Test
	public void methodInvoke(){
		Student student = new	Student();
		student.study();
		String string = student.study("English", (double)3);
		System.out.println(string);
	}
	
	@Test
	public void methodInvoke2() throws Exception{
		/**用反射重写*/
		Class<?> class1 = Class.forName("reflect.Student");
		Object object = class1.newInstance();//反射创建类的对象(无参构造)
		Method declaredMethod = class1.getDeclaredMethod("study");//通过方法名得到类方法(无参方法)
		Object invoke2 = declaredMethod.invoke(object);//调用类的对象的方法(无参方法)
		System.out.println(invoke2);
		
		Method method = class1.getMethod("study", String.class,Double.class);//通过方法名得到类方法(有参方法)
		Object invoke = method.invoke(object, "English",new Double(3));//调用类的对象的方法(有参方法)
		System.out.println(invoke);
		
		Method method2 = class1.getDeclaredMethod("run");
		method2.setAccessible(true);//调用private修饰的方法开关
		method2.invoke(object);
	}

}
