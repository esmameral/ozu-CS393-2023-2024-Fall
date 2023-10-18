package com.ozyegin.firstproject.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("eng")
//@Primary
@Profile("english")
public class MessageBeanEnImpl implements MessageBean {

	@Override
	public String getHelloMessage() {
		
		return "Hello, how are you?";
	}
}
