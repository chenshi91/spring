/**Created	by	chenshi  at	2018年1月22日 上午9:08:13*/
package Chp07_ThreeCharacteristicsOfObjectOriented;

/**
 * @description:	SuperTest.java
 * @packageName:	Chp7_ThreeCharacteristicsOfObjectOriented
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class SuperTest {
	/**super 关键字
	 * 1,用在构造方法上可以指定在递归构造父类对象的时候，调用父类的哪一个构造方法
	 * 2,就是把 super 当做是一个引用，这个引用指向父类对象
	 * super 引用就可以使用 A 父类对象中的属性和方法。最典型的用途是，使用super在子类中，调用父类被覆盖的方法
	 * (★★★★★)因此，在实际开发中，如果要增强一个类中某一个方法的功能，可以继承这个类，然后
	       覆盖这个类的方法。在覆盖时，可以利用 super 关键字调用父类中的实现，然后在父类实现
	       的基础上，增加子类特有的新功能*/
	public static void main(String[] args) {
		Child child = new	Child();
		child.m1();
		child.m2();
	}
}

class Parent{
	public void m(){
		System.out.println("m  in parent");
	}
}

class Child	extends Parent{
	public void m(){
		System.out.println("m  in child");
	}
	
	public void m1(){
		super.m();
	}
	
	public void m2(){
		this.m();
	}
}