package com.zhoufudun.mock.service;

import java.io.File;

/**
 * PowerMock基本用法
   (1) 普通Mock： Mock参数传递的对象
 * @author 19026404
 *
 */
public class FlySunService {
	public boolean callArgumentInstance(File file){
		return file.exists();
	}
}
