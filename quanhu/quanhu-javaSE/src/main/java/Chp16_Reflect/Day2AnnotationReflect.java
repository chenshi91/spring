/**Created	by	chenshi  at	2018年1月16日 下午10:45:55*/
package Chp16_Reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

/**
 * @description:	Day2AnnotationTest.java
 * @packageName:	reflect
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class Day2AnnotationReflect {
	
	@Test
	public void annotation() throws Exception{
		Class<?> forName = Class.forName("Chp16_Reflect.School");
		Method[] methods = forName.getDeclaredMethods();
		for (Method method : methods) {
			if(method.isAnnotationPresent(MethodAnnotation.class)){
				MethodAnnotation methodAnnotation = method.getAnnotation(MethodAnnotation.class);
				String key = methodAnnotation.key();
				String value = methodAnnotation.value();
				System.out.println(method.getName()+" key="+key+" value="+value);
			}
		}
		Method m2 = forName.getMethod("m2");
		m2.invoke(forName.newInstance());
	}
}

class School{
	
	@MethodAnnotation(key="meng",value = "huan")
	public void m1(){
		
	}
	
	public void m2(){
		System.out.println("--do  m2Method()----");
	}
	
	@MethodAnnotation(value = "zhengm")
	public void m3(){
		
	}
	
	@Override
	public String toString(){
		return null;
		
	}
}

