/**Created	by	chenshi  at	2018年1月19日 上午8:51:40*/
package Chp11_Collection;

import java.util.Vector;

/**
 * @description:	ListOfVertor.java
 * @packageName:	collection
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class ListOfVertor {
	/**和ArrayList的唯一区别是所有方法都是同步方法,重量级的*/
	
	public static void main(String[] args) {
		Vector<Object> vector = new	Vector<>();
		vector.add("chens");
		vector.add("huxz");
		vector.add("liucy");
		for (Object object : vector) {
			System.out.println(object);
		}
	}
}
