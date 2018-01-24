/**Created	by	chenshi  at	2018年1月23日 下午11:20:20*/
package Chp09_Interface;

import java.util.Arrays;

/**
 * @description:	InterfaceCallback.java
 * @packageName:	Chp9_Interface
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class InterfaceCallback {
	/**接口回调*/
	public static void main(String[] args) {
		Student[]	stuends=new	Student[4];
		stuends[0]=new 	Student((long)3, "xujiali", (byte)20);
		stuends[1]=new 	Student((long)2, "chens", (byte)25);
		stuends[2]=new 	Student((long)5, "zhengm", (byte)12);
		stuends[3]=new 	Student((long)5, "liying", (byte)18);
		printAll(stuends);
		Arrays.sort(stuends);
		/*Arrays.sort(Student[]	stuends, new Comparable<Student>(){

			@Override
			public int compareTo(Student stu2) {
				if(this.age>stu2.age)	return	1;
				else	if (this.age<stu2.age) return	-1;
				else	return 0;
			}
			
		});*/
		System.out.println("--------------排序后-------------");
		printAll(stuends);
	}

	private static void printAll(Student[] stuends) {
		if(stuends==null)	return;
		for (Student student : stuends) {
			System.out.println(student!=null?student.toString():"null");
		}
	}
	
}

class	Student implements	Comparable<Student>{
	private	Long id;
	private	String name;
	private	Byte	age;
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
	
	@Override
	public int compareTo(Student stu2) {
		if(this.age>stu2.age)	return	1;
		else	if (this.age<stu2.age) return	-1;
		else	return 0;
	}

	@Override
	public String toString() {
		return "Student [" + (id != null ? "id=" + id + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (age != null ? "age=" + age : "") + "]";
	}
	
}