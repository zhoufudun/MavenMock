package com.zhoufudun.mock.service;
/**
 * @author 19026404
 */
public class UserAction {
	private UserService userService;
	public void executeForPublic(String something)
	{ 
		userService.sayHi(something); 
		System.out.println(userService.sayHello(something)); 
		
	}
	public void println(){
		System.out.println("println()"); 
	}
	
}
