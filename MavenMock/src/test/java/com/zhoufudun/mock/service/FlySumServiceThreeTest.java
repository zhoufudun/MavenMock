package com.zhoufudun.mock.service;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.ArgumentMatchers.*;
import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.*;
import static org.mockito.Mockito.verify;
/**
 * 该例子出错，没有解决问题
 * @author 19026404
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({FlySumServiceThreeTest.class,FlySumServiceThree.class})
public class FlySumServiceThreeTest {
	@Mock
	private File file;
	@Mock
	private FlySumServiceThree flySumServiceThree;
	//在每一个@Test方法执行前执行一次
	@Before
	public void setup() {
	    MockitoAnnotations.initMocks(this);
	    //file=PowerMockito.mock(File.class);
	}
	@Test
	public void testCallArgumentInstance() {
		try {
			whenNew(File.class).withArguments("a").thenReturn(file);
			when(file.exists()).thenReturn(true);
			assertTrue(flySumServiceThree.callArgumentInstance("a"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
