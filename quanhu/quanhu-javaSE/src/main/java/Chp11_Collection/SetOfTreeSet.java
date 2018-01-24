/**Created	by	chenshi  at	2018年1月19日 上午9:23:39*/
package Chp11_Collection;

import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

/**
 * @description:	SetOfTreeSet.java
 * @packageName:	collection
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class SetOfTreeSet {
	/**TreeSet特点是:可排序
	 * 如果是自定义对象,要实现排序需求则需要实现Comparable()接口指明排序规则*/
	
	@Test
	public void treeSet1(){
		TreeSet<Object> treeSet = new	TreeSet<>();
		treeSet.add("huxz");
		treeSet.add("haxz");
		treeSet.add("hixz");
		treeSet.add("liucy");
		treeSet.add("liuak");
		treeSet.add("chens");
		treeSet.add("chena");
		Iterator<Object> iterator = treeSet.iterator();
		while(iterator.hasNext()){
			String next = (String) iterator.next();
//			if(next.contains("chen"))	treeSet.remove(next);
			System.out.println(next);
		}
		System.out.println("TreeSet大小:"+treeSet.size());
	}
	
}
