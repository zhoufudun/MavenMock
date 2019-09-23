package com.zhoufudun.mock.service;

public class FlySumServiceSeven {
	 public String callSystemStaticMethod(String str) {
		 return System.getProperty(str);
	 }
}
