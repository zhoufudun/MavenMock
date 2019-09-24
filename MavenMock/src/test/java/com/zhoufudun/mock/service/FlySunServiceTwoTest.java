package com.zhoufudun.mock.service;

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

@RunWith(PowerMockRunner.class)
@PrepareForTest({FlySunServiceTwoTest.class})
public class FlySunServiceTwoTest {
	@Test
	//@PrepareForTest(FlySunServiceTwo.class)
	public void testCallArgumentInstance() {
        try {
        	File file = PowerMockito.mock(File.class);
            PowerMockito.whenNew(File.class).withAnyArguments().thenReturn(file);
            FlySunServiceTwo demo = new FlySunServiceTwo();
            PowerMockito.when(file.exists()).thenReturn(true);
            Assert.assertTrue(demo.callArgumentInstance("bbb"));
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
