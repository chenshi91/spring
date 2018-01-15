/**Created	by	chenshi  at	2018年1月15日 下午6:29:44*/
package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

import org.junit.Test;

/**
 * @description:	WriteAndReadDay3_2.java
 * @packageName:	io
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class Day3_2WriteAndRead {

	@Test
	public void writeAndRead() throws IOException{
		OutputStream fos = new	FileOutputStream("day3.txt");//字节流
		Writer	write=new OutputStreamWriter(fos,"GBK");//字节流-->字符流,并制定编码格式,如不制定则默认GBK
		PrintWriter printWriter = new	PrintWriter(write);//加上缓冲流
		printWriter.println("葡萄美酒夜光杯,");
		printWriter.println("欲饮琵琶马上催.");
		printWriter.println("天生我材必有用,");
		printWriter.println("我是流氓我怕谁.");
		printWriter.close();
		
		FileInputStream fis = new	FileInputStream("day3.txt");
		Reader read=new	InputStreamReader(fis,"GBK");
		BufferedReader br=new BufferedReader(read);
		while(true){
			String readLine = br.readLine();
			if(readLine==null)	break;
			else System.out.println(readLine);
		}
		br.close();
	}
}
