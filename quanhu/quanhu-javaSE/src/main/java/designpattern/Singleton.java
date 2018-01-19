/**Created	by	chenshi  at	2018年1月17日 上午11:24:23*/
package designpattern;

/**
 * @description:	Singleton.java
 * @packageName:	designpattern
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class Singleton {
	/**day16:单例模式*/
	public static void main(String[] args) {
		Myclass myclass = Myclass.newInstance();
		Myclass2 myclass2 = Myclass2.newInstance();
		System.out.println(myclass);
		System.out.println(myclass2);
	}
}

/**饿汉式*/
class	Myclass {
	private static final Myclass ins=new Myclass();
	public static Myclass newInstance(){
		return ins;
	}
	private Myclass(){}
}

/**懒汉式*/
class Myclass2 {
	private static Myclass2 ins=null;
	public static synchronized Myclass2 newInstance(){
		if(ins==null) ins=new Myclass2();
		return ins;
	}
	private Myclass2(){}
}