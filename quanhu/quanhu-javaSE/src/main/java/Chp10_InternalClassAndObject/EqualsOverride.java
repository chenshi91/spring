/**Created	by	chenshi  at	2018年1月24日 下午9:50:07*/
package Chp10_InternalClassAndObject;

/**
 * @description:	EqualsOverride.java
 * @packageName:	Chp10_InternalClassAndObject
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class EqualsOverride {
	/**Object类是所有类的父类
	 * 1,finalize(),回收垃圾对象时,最后调用
	 * 2,getClass(),返回对象的实际类型
	 * 3,toString(),返回对象的String形式
	 * 4,equals(Object obj)判断this和obj对象是否相等,Object比较的是对象的首地址,自定义类比较需要重写equals()*/
	public static void main(String[] args) {
		Student s1 = new	Student("xujiali", 18);
		Student s2 = new	Student("xujiali", 18);
		System.out.println(s1.equals(s2));
	}
}

class	Student{
	private	String	name;
	private	Integer	age;
	
	public Student(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		//1,取反性,若是同一对象则不比较
		if(this==obj)	return	true;
		super.equals(obj);/**也可以用父类的这个原始方法来代替*/
		//2,判断是否为null
		if(obj==null)	return	false;
		//3,判断是否是同一类型
		if(this.getClass()!=obj.getClass())	return	false;
		//4,若是同一类型,则强转为同一类型逐一比较属性是否相同
		Student stu=(Student) obj;
		if(this.name!=stu.getName()||this.age!=stu.getAge())	return	false;
		
		return true;
	}
	
	@Override
	public String toString() {
		return "Student [" + (name != null ? "name=" + name + ", " : "") + (age != null ? "age=" + age : "") + "]";
	}
	
}