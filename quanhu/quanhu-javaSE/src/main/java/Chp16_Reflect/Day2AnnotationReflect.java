/**Created	by	chenshi  at	2018年1月16日 下午10:45:55*/
package Chp16_Reflect;

import java.lang.reflect.Method;

import org.junit.Test;

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
		Class<?> forName = Class.forName("reflect.School");
		Method[] methods = forName.getDeclaredMethods();
		for (Method method : methods) {
			if(method.isAnnotationPresent(MethodAnnotation.class)){
				MethodAnnotation methodAnnotation = method.getAnnotation(MethodAnnotation.class);
				String key = methodAnnotation.key();
				String value = methodAnnotation.value();
				System.out.println(method.getName()+" key="+key+" value="+value);
			}
		}
		
	}
}

class School{
	
	@MethodAnnotation(key="meng",value = "huan")
	public void m1(){
		
	}
	
	public void m2(){
		
	}
	
	@MethodAnnotation(value = "zhengm")
	public void m3(){
		
	}
	
	@Override
	public String toString(){
		return null;
		
	}
}

