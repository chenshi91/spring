/**Created	by	chenshi  at	2018年1月15日 下午8:58:14*/
package Chp14_Io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

/**
 * @description:	Day4ObjectOutputStream.java
 * @packageName:	io
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class Day4ObjectOutputStream {
	
	@Test
	public	void objectOutputStream() throws IOException, ClassNotFoundException{
		FileOutputStream fos = new	FileOutputStream("object.dat");
		ObjectOutputStream oos = new	ObjectOutputStream(fos);
		oos.writeObject(new Student(1L, "huxz", (double) 95));
		oos.writeObject(new Student(2L, "xujiali", (double) 78));
		oos.writeObject(new Student(3L, "zhengm", (double) 86));
		oos.close();
		
		FileInputStream fis = new	FileInputStream("object.dat");
		ObjectInputStream ois = new	ObjectInputStream(fis);
		while(true){
			Object readObject = ois.readObject();
			if(readObject==null)break;
			if(readObject.getClass()==Student.class){
				Student stu=(Student) readObject;
				System.out.println(stu);
			}
		}
		ois.close();
	}
}

class	Student	implements Serializable{//必须实现Serializable接口
	/***/
	private static final long serialVersionUID = -3822917240982262779L;
	private	Long id;
	private String name;
	private	transient	Double scope;//用transient修饰的属性不参与序列化,临时属性
	/**
	 * @param id
	 * @param name
	 * @param scope
	 */
	public Student(Long id, String name, Double scope) {
		super();
		this.id = id;
		this.name = name;
		this.scope = scope;
	}
	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [" + (id != null ? "id=" + id + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (scope != null ? "scope=" + scope : "") + "]";
	}
	
}