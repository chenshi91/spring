package com.quanhu.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.quanhu.service.MyService;

public class Test {
	
	public static void main(String[] args){
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		MyService service = ac.getBean(MyService.class);
		service.login();
	}

}
