package com.phonepe.model;

import java.util.Map;

public class Message {

	private String messageId;
	private Map<String, String> data;

	public Message(String messageId, Map<String, String> data) {
		super();
		this.messageId = messageId;
		this.data = data;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}
}
