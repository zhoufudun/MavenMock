package com.zhoufudun.mock.service;

import java.io.File;

/**
 * Mock方法内部new出来的对象
 * @author 19026404
 */
public class FlySumServiceThree {
	public boolean callArgumentInstance(String path){
		File file=new File(path);
		return file.exists();
	}
}
