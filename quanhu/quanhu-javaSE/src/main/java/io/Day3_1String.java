/**Created	by	chenshi  at	2018年1月15日 下午5:49:22*/
package io;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

/**
 * @description:	StringDay3_1.java
 * @packageName:	io
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class Day3_1String {
	/**乱码的出现是字符串编码和解码的不一致导致的
	 * @throws UnsupportedEncodingException */
	@Test
	public	void	bianma() throws UnsupportedEncodingException{
		String str1="庆祝51劳动节";
		byte[] bytes = str1.getBytes("GBK");
		String str2 = new String(bytes,"Big5");
		System.out.println(str1);
		System.out.println(str2);
		
		byte[] bytes2 = str2.getBytes("Big5");
		String str3 = new	String(bytes2,"GBK");
		System.out.println(str3);
		
	}
}
