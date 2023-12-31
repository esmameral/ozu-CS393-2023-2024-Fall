package com.ozyegin.firstproject.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("greetingService")
//@Scope("prototype")
public class GreetingServiceImpl implements GreetingService {
	
	private int randomNumber=(int) (Math.random()*100);
	@Value("${greeting.message}")
	private String newMessage;
	
	
	@Autowired
	private MessageBean messageBean;
	
	
	@Autowired
	//@Lazy//without Lazy throws "BeanCurrentlyInCreationException"
	private SimpleDateFormat df;
	
	public void setDf(SimpleDateFormat df) {
		this.df = df;
	}

	public int getRandomNumber() {
		return randomNumber;
	}
	
	@Override
	public String sayHello() {
		return newMessage+" "+  messageBean.getHelloMessage()+ " Current date-time:"+df.format(new Date()) ;
	}

}
