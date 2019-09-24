package com.MockTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.internal.matchers.*;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.zhoufudun.dao.PersonDao;
import com.zhoufudun.entity.Person;
import com.zhoufudun.mock.service.PersonService;
import com.zhoufudun.mock.service.UserAction;
import com.zhoufudun.mock.service.UserService;

import static org.mockito.ArgumentMatchers.*;
import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.*;
import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class) 
@PrepareForTest({UserActionTest.class}) //测试UserAction
public class UserActionTest {
    @Mock
    private UserService userService;
    @InjectMocks
    private UserAction userAction;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test 
    public void testExecuteForPublic() {
        //有返回值的方法 
        when(userService.sayHello(any(String.class))).thenReturn("mock sayHello!");
    	Mockito.doNothing().when(userService).sayHi(any(String.class));
        userAction. executeForPublic("hello");
        assertEquals("mock sayHello!", "mock sayHello!");
        /**
            //对无返回值的方法，内部执行逻辑会被空调用覆盖
			Mockito.doNothing().when(userService).sayHi(any(String.class)); 
			//有返回值的方法 
			when(userService.sayHello(any(String.class))).thenReturn("mock sayHello!");
			
			模拟私有方法
			// 模拟返回值私有方法.
			PowerMockito.doReturn("mock").when(userService, "privateMethod", any(String.class)); 
			// 模拟私有空方法. 
			PowerMockito.doNothing().when(userService, " privateMethod ", any(String.class));
         */
    }
}

