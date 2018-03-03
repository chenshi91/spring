/**Created	by	chenshi  at	2017年12月1日 上午10:54:10*/
package com.quanhu.base.utils;

import java.io.File;

/**
 * @description:	UpdateFileNameUtils.java
 * @packageName:	com.quanhu.activie.base.utils
 * @projectName:	common-base
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class UpdateFileNameUtils {
	public static void main(String[] args) {
		String fileUrl = "H:/苏菲玛索电影全集";String fileOldName = "【苏菲·玛索】";String fileReplaceName = "【苏菲·玛索】";
		updateFileName(fileUrl,fileOldName,fileReplaceName);
	}
	

	/**
	 * 
	 * @description:updateFileName(批量修改文件名称)
	 * @param fileUrl
	 * @param fileOldName
	 * @param fileReplaceName
	 * @return void
	 * @author chenshi
	 */
	private static void updateFileName(String fileUrl, String fileOldName, String fileReplaceName) {
		File f = new File(fileUrl);  
        if (f.exists()) {  
            if (f.isDirectory()) {  
                File[] files = f.listFiles();  
                for (int i = 0; i < files.length; i++) {  
                    String oldname = files[i].getName();  
                    String newname = oldname.replace(fileOldName, fileReplaceName);
                    newname = newname + "";  
                    if (!oldname.equals(newname)) {  
                        String path = files[i].getParent();  
                        File newfile = new File(path + "/" + newname);  
                        if (newfile.exists()) {  
                            System.out.println(newname + "已经存在�?");  
                        } else {  
                            files[i].renameTo(newfile);  
                        }  
                    }  
                }  
            }  
        } else {  
            System.out.println("File does not exist!");  
        }
	}
}
