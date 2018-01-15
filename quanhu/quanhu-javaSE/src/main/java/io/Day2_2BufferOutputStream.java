/**Created	by	chenshi  at	2018年1月15日 下午4:19:05*/
package io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.Test;

/**
 * @description:	BufferOutputStreamDay2_2.java
 * @packageName:	io
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class Day2_2BufferOutputStream {
	/**BufferedOutputStream现将数据从jvm读取到缓冲区,然后再从缓冲区一次性全部读取到file文件里面
	 * 一般用于写操作,和OutputStream连用*/
	@Test
	public void bufferOutputStream() throws IOException{
		OutputStream os = new	FileOutputStream("bufferOutputStream.txt");
		BufferedOutputStream bos = new	BufferedOutputStream(os);
		bos.write('A');
		bos.flush();//将缓冲区数据释放,一次性全部读取到file文件里面
		bos.close();
	}
}
