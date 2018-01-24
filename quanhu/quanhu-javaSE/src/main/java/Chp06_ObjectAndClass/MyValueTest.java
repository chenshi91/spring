/**Created	by	chenshi  at	2018年1月22日 上午8:37:27*/
package Chp06_ObjectAndClass;

/**
 * @description:	MyValueTest.java
 * @packageName:	Chp6_ObjectAndClass
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class MyValueTest {
	/**在 Java 中的方法参数传递中，基本类型传值，对象类型传地址*/
	public static void main(String[] args) {
		int a=10;
		changeInt(a);
		System.out.println(a);
		 
		MyValue mv = new	MyValue();
		mv.value=10;
		changeObject(mv);
		System.out.println(mv.value);
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