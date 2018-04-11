/**Created	by	chenshi  at	2018年1月16日 下午12:00:55*/
package Chp16_Reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description:	day1_1reflect.java
 * @packageName:	reflect
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class Day1_0Reflect {
	
	@Test
	public void reflect() throws ReflectiveOperationException, IllegalAccessException{
		String  className = "Chp16_Reflect.Student";
		String  methodName = "study";
		try {
			/**1,根据类名打印类里面所有方法*/
			printMethods(className);
			
			/**2,根据类名,创建对象*/
			Object object=createObject(className);
			System.out.println(object instanceof Student);
			
			/**3,根据方法名,调用类对象*/
			Object methodInvoke = methodInvoke(object,methodName,"English",(double)6);
			System.out.println(methodInvoke);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("printMethods()出现异常");
		}
	}

	

	/**
	 * @description:printMethods(根据类名打印类里面所有方法)
	 * @param className
	 * @return void
	 * @throws ClassNotFoundException 
	 */
	public	static void printMethods(String className) throws ClassNotFoundException {
		Class<?> forName = Class.forName(className);
		Method[] methods = forName.getDeclaredMethods();//返回本类中所有的方法,包括private私有方法
		for (Method method : methods) {
			System.out.println(method.getName());
		}
//		Method[] declaredMethods = forName.getMethods();//返回类中所有的公开方法,包括父类中的方法
	}
	
	/**
	 * @description:createObject(根据类名,创建对象)
	 * @param className
	 * @return
	 * @return Object
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static Object createObject(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		return Class.forName(className).newInstance();
	}
	
	/**
	 * @description:methodInvoke(根据方法名,调用类对象)
	 * @param object
	 * @param methodName
	 * @return
	 * @return Object
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public static Object methodInvoke(Object object, String methodName,Object methodField1,Object methodField2) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<? extends Object> class1 = object.getClass();
		Method method = class1.getDeclaredMethod(methodName,methodField1.getClass(),methodField2.getClass());
		return method.invoke(object,methodField1,methodField2);
	}
}

class	Student{
	private	Long id;
	private	String name;
	private	Double	scope;
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
	/**
	 * 
	 */
	public Student() {
		super();
		System.out.println("create student");
	}
	
	public	void	study(){
		System.out.println("study all day");
	}
	
	public String study(String name,Double hours){
		return	"study "+name+" "+hours+"小时";
	}
	
	@SuppressWarnings("unused")
	private void	run(){
		System.out.println("private修饰的方法调用了");
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
	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [" + (id != null ? "id=" + id + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (scope != null ? "scope=" + scope : "") + "]";
	}
	
}
