/**Created	by	chenshi  at	2018年1月22日 上午8:37:27*/
package Chp06_ObjectAndClass;

import java.util.Arrays;

/**
 * @description:	MyValueTest.java
 * @packageName:	Chp6_ObjectAndClass
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class MyValueTest {
	/**在 Java 中的方法参数传递中，基本类型+String类型传值，对象类型传地址*/
	public static void main(String[] args) {
		int a=10;
		changeInt(a);
		System.out.println(a);
		 
		MyValue mv = new	MyValue();
		mv.value=10;
		changeObject(mv);
		System.out.println(mv.value);

		String str="123";
		changeString(str);
		System.out.println(str);
		System.out.println("java" + 6 + 6);

		int[] ids=new int[]{2,1,3,7};
		changeInteger(ids);
        for (int id : ids) {
            System.out.print(id+" ");
        }
	}

	private static void changeInteger(int[] ids) {
		ids=new int[]{5,1,6};
	}

	private static void changeString(String str) {
		str="hello";
	}

	public static void changeObject(MyValue mv) {
		mv.value++;
	}

	public static void changeInt(int n) {
		n++;
	}
}

class MyValue{
	int value;
}