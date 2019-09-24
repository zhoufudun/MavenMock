package com.zhoufudun.mail.service;

import java.io.IOException;

import org.springframework.mail.MailMessage;


public interface MailService {
	void sendSimpleMail(String to, String subject, String content);

	String getFrom();

//    void sendHtmlMail(String to, String subject, String content);
//
//    void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
//    
//    public void setMailMessage(MailMessage mailMessage);
//    
//    public void sendHtml(String content, MailType... mailTypes) throws IOException;
//
//	  void setMailMessage();

}
