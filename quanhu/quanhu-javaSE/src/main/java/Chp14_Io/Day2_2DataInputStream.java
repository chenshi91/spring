/**Created	by	chenshi  at	2018年1月15日 下午3:51:27*/
package Chp14_Io;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @description:	DataInputStreamDay2.java
 * @packageName:	io
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class Day2_2DataInputStream {
	
	/**DataOutputStream,DataInputStream包装流能增强节点流的功能*/
	@Test
	public	void dataInputStream() throws IOException{
		long sun=789456123L;
		OutputStream os=new FileOutputStream("2.dat");
		DataOutputStream dos=new DataOutputStream(os);//包装流
		dos.writeLong(sun);
		dos.close();
		
		InputStream is=new FileInputStream("2.dat");
		DataInputStream dis = new DataInputStream(is);
		long readLong = dis.readLong();
		System.out.println(readLong);
		dis.close();
		
	}
}
