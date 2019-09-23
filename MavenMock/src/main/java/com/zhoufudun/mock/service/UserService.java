package com.zhoufudun.mock.service;

public class UserService {
	//无返回值的公共方法
	public void sayHi(String arg)
	{ 
		System.out.println("real"+arg+"!"); 
	} 
	//有返回值的公共方法
	public String sayHello(String arg)
	{ 
		return "real "+arg+" !"; 
	}
	
}
