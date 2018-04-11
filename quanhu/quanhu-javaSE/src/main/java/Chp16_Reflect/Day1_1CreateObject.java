/**Created	by	chenshi  at	2018年1月16日 下午6:11:11*/
package Chp16_Reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

/**
 * @description:	Day1CreateObject.java
 * @packageName:	reflect
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class Day1_1CreateObject {
	
	@Test
	public void createObject() throws ClassNotFoundException, Exception{
		/**反射创建对象*/
		Class<?> forName = Class.forName("Chp16_Reflect.Student");
		Object object = forName.newInstance();
		System.out.println(object instanceof Student);
		System.out.println(forName.getInterfaces());
		/*Field[] fields = forName.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}*/
	}
}
