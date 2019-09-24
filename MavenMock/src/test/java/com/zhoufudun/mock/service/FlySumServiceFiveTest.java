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
/**
 * 说明：当需要mock静态方法的时候，必须加注解@PrepareForTest和@RunWith。
 * 注解@PrepareForTest里写的类是静态方法所在的类。
 * @author 19026404
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({FlySumServiceFiveTest.class})
public class FlySumServiceFiveTest {

	@Test
    @PrepareForTest(ClassDependency.class)
	public void testCallStaticMethod() {
		PowerMockito.mockStatic(ClassDependency.class);
		PowerMockito.when(ClassDependency.isStatic()).thenReturn(true);
		FlySumServiceFive flySumServiceFive=new FlySumServiceFive();
		Assert.assertTrue(flySumServiceFive.callStaticMethod());
	}

}
