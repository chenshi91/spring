/**Created	by	chenshi  at	2018年1月11日 下午1:39:54*/
package Chp12_Exception;

/**
 * @description:	TestException.java
 * @packageName:	com.quanhu.exception
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class TestException {
	public static void main(String[] args) {
	
		System.out.println(method1(1));
	}

	private static int method1(int i) {
		try {
			return 10/i;
		} catch (Exception e) {
			e.printStackTrace();
			return 888;
		}finally {
			return 0;
		}
	}
	
	
}
