package com.zhoufudun.mock.service;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.*;
import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.*;
import static org.mockito.Mockito.verify;
/**
 * 说明： 必须加注解@PrepareForTest和@RunWith。
 * 注解@PrepareForTest里写的静态和final方法所在的类
 * Mock系统类的静态和final方法 。。。。。。
 * @author 19026404
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(FlySumServiceSevenTest.class)
public class FlySumServiceSevenTest {

	@Test
	//注释了能看覆盖率，但是测试无法通过？？
	//@PrepareForTest({FlySumServiceSeven.class})
	public void testCallSystemStaticMethod() {
		FlySumServiceSeven demo=new FlySumServiceSeven();
		PowerMockito.mockStatic(System.class);
		PowerMockito.when(System.getProperty("bbb")).thenReturn("lll");
		Assert.assertEquals("lll", demo.callSystemStaticMethod("bbb"));
	}

}
