package com.ozyegin.firstproject.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("tr")
@Profile("turkish")
public class MessageBeanTrImpl implements MessageBean {

	@Override
	public String getHelloMessage() {
		
		return "Merhaba, nasilsiniz?";
	}

}
