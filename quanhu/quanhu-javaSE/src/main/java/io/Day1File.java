/**Created	by	chenshi  at	2018年1月14日 下午9:50:37*/
package io;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import org.junit.Test;

/**
 * @description:	FileDay1.java
 * @packageName:	io
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class Day1File {
	
	@Test
	public void wenjianFile() throws IOException {
		File file = new	File("xujiali.txt");//File对象代表磁盘上的一个文件或目录
		file.createNewFile();//创建新文件	
		file.mkdir();//创建新目录
//		file.delete();//删除文件/目录
		boolean directory = file.isDirectory();//判断是否是目录
		boolean file2 = file.isFile();//判断是否是文件
		String absolutePath = file.getAbsolutePath();//获得绝对路径
//		File absoluteFile = file.getAbsoluteFile();
		System.out.println("是否是目录:"+directory);
		System.out.println("是否是文件:"+file2);
		System.out.println("绝对路径:"+absolutePath);
		
	}
	
	@Test
	public	void	muluFile(){
		File muluFile = new	File("E:\\");
		File[] listFiles = muluFile.listFiles(new	FileFilter(){
			/**匿名内部类,文件过滤*/
			@Override
			public boolean accept(File pathname) {
				if(pathname.isDirectory()) return false;//
				else if(pathname.isFile()&&pathname.getName().endsWith(".txt")) return true;
				else	return false;
			}});//返回目录下面所有文件/目录的数组
		for (File f : listFiles) {
			if(f.isFile()){	System.out.println("文件:"+f.getName());}
			else if (f.isDirectory()) {System.out.println("目录:"+f.getName());	}
		}
	}

}
class	MyFileFilter	implements	FileFilter{

	@Override
	public boolean accept(File file) {
		System.out.println("File对象以:"+file.getName()+"为参,调用accept()方法");
		return false;
	}
	
}	

