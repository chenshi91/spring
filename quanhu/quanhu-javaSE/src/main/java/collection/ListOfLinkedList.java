/**Created	by	chenshi  at	2018年1月19日 上午8:56:34*/
package collection;

import java.util.LinkedList;

/**
 * @description:	ListOfLinkedList.java
 * @packageName:	collection
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class ListOfLinkedList {
	/**和ArrayList相比,LinkedList查询慢,增删快,底层是用链表实现*/
	
	public static void main(String[] args) {
		LinkedList<Object> linkedList = new	LinkedList<>();
		linkedList.add("huxy");
		linkedList.add("liucy");
		linkedList.add("chens");
		for (Object object : linkedList) {
			System.out.println(object);
		}
		
	}
}
