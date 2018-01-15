/**Created	by	chenshi  at	2018年1月15日 下午12:54:13*/
package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

/**
 * @description:	InputStreamDay2.java
 * @packageName:	io
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class InputStreamDay2_1 {
	/**IO编程步骤:
	 * 1,创建节点流
	 * 2,封装过滤流
	 * 3,读/写数据
	 * 4,关闭流*/

	@Test
	public  void inputStream()  {
		InputStream fis=null;
		try {
			fis = new	FileInputStream("1.txt");
			byte[] bs=new byte[8];
			while (true) {
				int read = fis.read(bs);
				if(read==-1) break;
				else for (byte b : bs) {
					System.out.print((char)b);
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}finally{
			try {
				if(fis!=null)fis.close();
			} catch (IOException e) {
				e.printStackTrace();
				
			}
		}
		
	}

}
