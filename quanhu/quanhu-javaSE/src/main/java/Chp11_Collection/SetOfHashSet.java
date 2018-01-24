/**Created	by	chenshi  at	2018年1月19日 上午9:04:25*/
package Chp11_Collection;

import java.util.HashSet;
import java.util.Iterator;

import org.junit.Test;

/**
 * @description:	SetOfHashSet.java
 * @packageName:	collection
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class SetOfHashSet {
	/**Set接口的特点:无顺序,不可重复
	 * Set接口的实现类:HashSet和TreeSet
	 * HashSet按照先按照元素对象的HashCode/数组长度取余分配空间,如果取余相等,则再比较equals(),如果equals为true,则覆盖
	 * 如果是自定义对象,要实现HashSet的去重需求,则需要重写HashCode()和equals()方法*/
	
	@Test
	public	void	hashSet1(){
		HashSet<Object> hashSet = new	HashSet<>();
		hashSet.add("huxz");
		hashSet.add("liucy");
		hashSet.add("chens");
		hashSet.add("huxz");
		/**使用迭代器遍历*/
		Iterator<Object> iterator = hashSet.iterator();
		while(iterator.hasNext()){
			Object next = iterator.next();
			System.out.println(next.toString());
		}
		System.out.println("hashSet大小:"+hashSet.size());
	}
	
	@Test
	public	void	hashSet2(){
		HashSet<Object> hashSet = new	HashSet<>();
		hashSet.add(new	Student(1L, "huxz", (byte)30));
		hashSet.add(new	Student(2L, "liucy", (byte)25));
		hashSet.add(new	Student(3L, "chens", (byte)26));
		hashSet.add(new	Student(3L, "chens", (byte)26));
		/**使用迭代器遍历*/
		Iterator<Object> iterator = hashSet.iterator();
		while(iterator.hasNext()){
			Object next = iterator.next();
			System.out.println(next);
		}
		System.out.println("hashSet大小:"+hashSet.size());
	}
}


class	Student	{
	
	private Long id;
	private	String name;
	private Byte	age;
	/**
	 * @param id
	 * @param name
	 * @param age
	 */
	public Student(Long id, String name, Byte age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Byte getAge() {
		return age;
	}
	public void setAge(Byte age) {
		this.age = age;
	}
	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [" + (id != null ? "id=" + id + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (age != null ? "age=" + age : "") + "]";
	}
	
}
