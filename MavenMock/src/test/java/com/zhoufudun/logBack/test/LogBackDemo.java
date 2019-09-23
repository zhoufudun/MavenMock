package com.zhoufudun.logBack.test;
import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhoufudun.mail.service.MailService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class LogBackDemo {
	
	@Test
	public void LogBackTest() {
		final Logger logger = LoggerFactory.getLogger(LogBackDemo.class);
		logger.info("logback≤‚ ‘1");
		logger.warn("logback≤‚ ‘2");
		logger.debug("logback≤‚ ‘3");
		logger.warn("logback≤‚ ‘4");
	}
}

