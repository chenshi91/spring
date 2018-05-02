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
	/**在 Java 中的方法参数传递中，
	 * 	8种基本数据类型栈空间直接传值，
	 * 	引用数据类型(类，数组,String,static修饰)传地址，
	 * 		指针指向堆空间（类，数组）
	 * 		指针指向常量池（String）
	 * 		指针指向静态域（static修饰）	*/
	public static void main(String[] args) {
		int a=10;
		changeInt(a);
		System.out.println("基本数据类型栈空间直接赋值："+a);
		 
		MyValue mv = new	MyValue();
		mv.value=10;
		changeObject(mv);
		System.out.println("引用数据类型（对象）指针指向堆空间："+mv.value);

		String str="123";
		changeString(str);
		System.out.println("引用数据类型（String）指针指向常量池："+str);

		int[] ids=new int[]{2,1,3,7};
		changeInteger(ids);
		System.out.println("引用数据类型（数组）指针指向堆空间：");
		for (int id : ids) {
            System.out.print(id+" ");
        }
	}

	private static void changeInteger(int[] ids) {
		ids[1]=10;
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