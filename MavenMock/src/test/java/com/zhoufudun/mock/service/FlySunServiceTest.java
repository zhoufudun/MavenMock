package com.zhoufudun.mock.service;
import static org.mockito.ArgumentMatchers.*;
import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.*;
import static org.mockito.Mockito.verify;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;

public class FlySunServiceTest {
	
	@Mock
	private FlySunService flySunService;
	//在每一个@Test方法执行前执行一次
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
	@Test
	public void testCallArgumentInstance() {
		//mock出 入参File对象
    /**
     * 方法一
     * 
        File file=PowerMockito.mock(File.class);
		when(flySunService.callArgumentInstance(file)).thenReturn(true);
		assertTrue(flySunService.callArgumentInstance(file));
     */
//		File file=PowerMockito.mock(File.class);
//		when(flySunService.callArgumentInstance(file)).thenReturn(true);
//		assertTrue(flySunService.callArgumentInstance(file));
	/**
	 * 方法二	
	 * 说明：普通Mock不需要加@RunWith和@PrepareForTest注解。
	 */
		File file=PowerMockito.mock(File.class);
		FlySunService flySunService2=new FlySunService();
		PowerMockito.when(file.exists()).thenReturn(true);
		Assert.assertTrue(flySunService2.callArgumentInstance(file));
	}

}
