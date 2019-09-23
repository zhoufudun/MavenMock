package com.zhoufudun.mock.service;

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
import com.zhoufudun.mock.service.MockPrivateService;
import com.zhoufudun.mock.service.PersonService;
import com.zhoufudun.mock.service.UserAction;
import com.zhoufudun.mock.service.UserService;

import static org.mockito.ArgumentMatchers.*;
import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.*;
import static org.mockito.Mockito.verify; 

@RunWith(PowerMockRunner.class)
@PrepareForTest({MockPrivateService.class})
public class MockPrivateServiceTest {
			///@Spy修饰的对象必须要手动new出来，或者 mockPrivateClass = PowerMockito.spy(new MockPrivateClass());
			@Spy
		    private MockPrivateService mockPrivateService=new MockPrivateService();

		    @Test
		    public void testMockPrivateFunc(){
		    	/**
		    	 *  @Spy
		    		private MockPrivateClass mockPrivateClass=new MockPrivateClass();
		    		于以下代码作用于一致：
		    		mockPrivateClass = PowerMockito.spy(new MockPrivateClass());
		    	 */
		        
		        try {
					PowerMockito.when(mockPrivateService, "privateFunc").thenReturn("test");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		        String realResult = mockPrivateService.mockPrivateFunc();

		        Assert.assertEquals("test", realResult);

		        try {
					PowerMockito.verifyPrivate(mockPrivateService, Mockito.times(1)).invoke("privateFunc");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		    }

}
