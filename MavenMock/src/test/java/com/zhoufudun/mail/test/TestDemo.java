package com.zhoufudun.mail.test;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
public class TestDemo {
	
	@Test
	public void MailTest(){
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("applicationContext.xml");
	    	 
		JavaMailSender  mm =  (JavaMailSender )context.getBean("javaMailSender");
		System.out.println("3371324264@qq.com");
		SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("3371324264@qq.com");
        message.setTo("1215906004@qq.com");
        message.setText("这是一个测试邮件");
        System.out.println("开始发送");
		mm.send(message);
		System.out.println("发送成功");
	}
}
