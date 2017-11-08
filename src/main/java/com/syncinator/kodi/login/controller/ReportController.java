package com.syncinator.kodi.login.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.syncinator.kodi.login.util.Utils;

@RestController
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
    public JavaMailSender emailSender;
	
	@Value("${report.email.to}")
	private String to;
	@Value("${report.email.subject.prefix}")
	private String subjectPrefix;
	
	@RequestMapping(method=RequestMethod.POST)
	public void reportError(@RequestParam String stacktrace, HttpServletRequest request) throws IOException {
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setSubject(subjectPrefix + Utils.getRemoteAddress(request)); 
        message.setText(stacktrace);
        emailSender.send(message);
	}
}
