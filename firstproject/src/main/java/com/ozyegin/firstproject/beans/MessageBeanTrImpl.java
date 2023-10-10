package com.ozyegin.firstproject.beans;

import org.springframework.stereotype.Component;

@Component("tr")
public class MessageBeanTrImpl implements MessageBean {

	@Override
	public String getHelloMessage() {
		
		return "Merhaba, nasilsiniz?";
	}

}
