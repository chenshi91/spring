/**Created	by	chenshi  at	2018年1月22日 下午11:47:20*/
package Chp09_Interface;

import org.junit.Test;

/**
 * @description:	InterfaceTest.java
 * @packageName:	Chp9_Interface
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class InterfaceTest {
	/**1,接口是特殊的抽象类
	 * 2,接口能够实现多继承,不同于类的单继承
	 * 3,接口和多态*/
	@Test
	public void test1(){
		
	}
}

abstract	class	MyAbstractClass{
	public static final int VALUE1 = 100; //属性是公开静态常量
	public static final int VALUE2 = 200; //第二个属性
	public abstract void m1(); //方法是公开抽象方法
	public abstract void m2(int n); //第二个方法
}

interface MyInterface{
	public static final int VALUE1 = 100;
	public static final int VALUE2 = 200;
	public abstract void m1();
	public abstract void m2(int n);
}

interface MyInterface2{
	 int VALUE1 = 100;
	 int VALUE2 = 200;
	 void m1();
	 void m2(int n);
}
