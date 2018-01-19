/**Created	by	chenshi  at	2018年1月19日 下午4:12:23*/
package generic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @description:	Generic.java
 * @packageName:	generic
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class Generic {
	/**泛型		模板编程		应用在集合框架中实现类型安全的集合(约定集合中的元素类型)
	 * 不同泛型之间不能相互赋值(泛型没有多态)
	 * 泛型的通配符:?(任何类型)
	 * ? extends Number :Number或任何Number的子类
	 * ? super	Number	:Number或任何Number的父类
	 * ? extends	Comparable:任何实现Comparable接口的类
	 * */
	
	@Test
	public	void generic(){
		List<Object> list1 = new	ArrayList<Object>();
		List<String> list2 = new	ArrayList<String>();
		List<Number> list3 = new	ArrayList<Number>();
		List<Integer> list4 = new	ArrayList<Integer>();
		List<Double> list5 = new	ArrayList<Double>();
		
		printNumber(list1);
		printAll(list2);
		printNumber(list3);
		print(list4);
		print(list5);
		
		Number[]	numbers=new	Number[]{1,2,5,6,7};
		copy(list3, numbers);
		for (Number number : list3) {
			System.out.print(number+" ");
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static <T	extends Number & Comparable> void	print(List<T>	list){}
	public static  void	printAll(List<? extends Object>	list){}
	public static  void	printNumber(List<? super Number>	list){}
	
	public	static<T extends Number,A extends Object>	void copy(List<T> list,T[] obs){
		for (T t : obs) {
			list.add(t);
		}
	}
}

class	Topic<T extends Object ,A extends Number>{
	
	public void method1(T t){}
	public T method2(){
		return null;
	}
}