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
 * 说明： 当需要mock final方法的时候，必须加注解@PrepareForTest和@RunWith。
 * 注解@PrepareForTest里写的类是final方法所在的类
 * @author 19026404
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({FlySumServiceFourTest.class})
public class FlySumServiceFourTest {

	@Test
    @PrepareForTest(ClassDependency.class)
	public void testCallFinalMethod() {
		ClassDependency refer=PowerMockito.mock(ClassDependency.class);
		PowerMockito.when(refer.isAlive()).thenReturn(true);
		FlySumServiceFour demo = new FlySumServiceFour();
		Assert.assertTrue(demo.callFinalMethod(refer));
	}

}
