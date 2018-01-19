/**Created	by	chenshi  at	2018年1月19日 下午6:14:53*/
package tips;

/**
 * @description:	VariableLengthParameter.java
 * @packageName:	tips
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class VariableLengthParameter {
	/**可变长参数:由编译器负责将多个实参封装成数组
	 * 一个方法中最多只能有一个可变长参数,且必须是参数表中最后一个参数(sun公司强制规定,避免参数混淆)*/
	public static void main(String[] args) {
		method1("chens","huxz","liucy","zhengm");
	}
	
	/**等价于
	 * static void method1(String[] param2){}*/
	static void method1(String... param2){}
	static void method2(String param1,String... param2){}
}
