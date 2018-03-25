/**Created	by	chenshi  at	2018年1月15日 下午8:58:14*/
package Chp14_Io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.jupiter.api.Test;

/**
 * @description:	Day4ObjectOutputStream.java
 * @packageName:	io
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class Day4ObjectOutputStream2 {
	/**补充小知识点:对象的克隆(对传输是对象时,修改对象的属性需要用对象的克隆)*/
	@Test
	public	void objectOutputStream() throws IOException, ClassNotFoundException{
		FileOutputStream fos = new	FileOutputStream("object2.dat");
		ObjectOutputStream oos = new	ObjectOutputStream(fos);
		Student2 student = new Student2(2L, "xujiali", (double) 78);
		oos.writeObject(student);
		student.setId(10L);
		Student2 s2 = (Student2) student.clone();
		oos.writeObject(s2);
		oos.close();
		
		InputStream fis = new	FileInputStream("object2.dat");
		ObjectInputStream ois = new	ObjectInputStream(fis);
		while(true){
			Object readObject = ois.readObject();
			if(readObject==null)break;
			if(readObject instanceof	Student2){
				Student2 stu=(Student2) readObject;
				System.out.println(stu);
			}
		}
		ois.close();
	}
}

class	Student2	implements Serializable,Cloneable{//必须实现Serializable接口,Cloneable接口
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
	public Student2(Long id, String name, Double scope) {
		super();
		this.id = id;
		this.name = name;
		this.scope = scope;
	}
	
	public	Object clone(){
		try {
			return	super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return	null;
		}
	}
	
	@Override
	public String toString() {
		return "Student2 [" + (id != null ? "id=" + id + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (scope != null ? "scope=" + scope : "") + "]";
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

	public Double getScope() {
		return scope;
	}

	public void setScope(Double scope) {
		this.scope = scope;
	}
	
}