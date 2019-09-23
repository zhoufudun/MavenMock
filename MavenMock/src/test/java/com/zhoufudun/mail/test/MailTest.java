package com.zhoufudun.mail.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhoufudun.logBack.test.LogBackDemo;
import com.zhoufudun.mail.service.MailService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
public class MailTest {
	private final Logger logger = LoggerFactory.getLogger(MailTest.class);
	
	@Resource
	private  MailService mailService;
	@Value("${mail.fromAddress}")
	private String from;
	
	@Test
	public void MailTestOne(){	
		System.out.println(mailService.getFrom());
		logger.info("开始发送邮件");
		mailService.sendSimpleMail("1215906004@qq.com", "ceshi", "这是一个测试邮箱，不能用公司的网络");		
		//logger.info("邮件发送成功");
	}
	@Test
	public void test(){
		System.out.println(from);
	}
}
