package com.zhoufudun.mock.service;
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
/**
 * 说明： 当需要mock 私有方法的时候，必须加注解@PrepareForTest和@RunWith。
 * 注解@PrepareForTest里写的类是私有方法所在的类
 * @author 19026404
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({FlySunServiceSixTest.class})
public class FlySunServiceSixTest {

	@Test
	//@PrepareForTest(FlySunServiceSix.class)
	public void testCallPrivateMethod() {
		try {
			FlySunServiceSix demo=PowerMockito.mock(FlySunServiceSix.class);
			//Sets the real implementation to be called when the method is called on a mock object
			PowerMockito.when(demo,"callPrivateMethod").thenCallRealMethod();
			//设置真正调用的方法
			PowerMockito.when(demo,"isAlive").thenReturn(true);
			Assert.assertTrue(demo.callPrivateMethod());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
