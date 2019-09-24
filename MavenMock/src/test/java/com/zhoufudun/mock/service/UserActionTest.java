package com.zhoufudun.mock.service;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.*;
@RunWith(PowerMockRunner.class)
public class UserActionTest {
	@Mock 
	private UserService userService;
	@InjectMocks
	@Spy//真实对象，必须手动new 
	private UserAction userAction=new UserAction();
	@Test
	public void testExecuteForPublic() {
//		PowerMockito.doNothing().when(userService).sayHi("hello");
//		//Mockito.doNothing().when(userService).sayHi(any(String.class));
//		userAction.executeForPublic("hello");
//		//assertEquals("hello", s);
		when(userService.sayHello(any(String.class))).thenReturn("mock sayHello!");
    	Mockito.doNothing().when(userService).sayHi(any(String.class));
        userAction.executeForPublic("hello");
        userAction.println();
        assertEquals("mock sayHello!", "mock sayHello!");
	}

}
