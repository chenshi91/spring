/**Created	by	chenshi  at	2018年1月15日 下午2:33:38*/
package Chp14_Io;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @description:	OutputStreamDay2.java
 * @packageName:	io
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class Day2_1OutputStream {
	
	/**输出流向文件写字节,字节流*/
	@Test
	public void fileOutputStream() throws IOException {
		String str="2018-01-15,hellow world!";
		OutputStream os = new	FileOutputStream("xujiali.txt");
		os.write(str.getBytes());
		os.close();
	}

}
