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
        message.setText("����һ�������ʼ�");
        System.out.println("��ʼ����");
		mm.send(message);
		System.out.println("���ͳɹ�");
	}
}
