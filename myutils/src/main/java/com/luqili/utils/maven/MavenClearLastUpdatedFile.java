package com.luqili.utils.maven;

import java.io.File;

/**
 * 清理Maven下载失败引起的LastUpdated文件
 * @author luqili
 *
 */
public class MavenClearLastUpdatedFile {
	
	/**
	 * 删除指定后缀的文件。
	 * @param file
	 */
	public static void delFile(File file,String fileExit){
		if(file.isFile()){
			String fileName=file.getName();
			if(fileName.endsWith(fileExit)){
				file.delete();
				System.out.println("删除匹配文件:"+file.getPath());
			}
		}else{
			File[] lt=file.listFiles();
			if(lt!=null && lt.length>0){
				for(File child:lt){
					delFile(child,fileExit);
				}
			}else{
				file.delete();//删除空文件夹
				System.out.println("删除空文件夹:"+file.getPath());
			}
		}
	}
	
	public static void main(String[] args) {
		String basePath="/home/luqili/.m2";
		String fileExit=".lastUpdated";
		File root = new File(basePath);
		delFile(root,fileExit);
	}

}
