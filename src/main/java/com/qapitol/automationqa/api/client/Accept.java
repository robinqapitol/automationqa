package com.qapitol.automationqa.api.client;

public enum Accept {

	APPLICATION_JSON("application/json"),
	APPLICATION_XML("application/xml"),
	TEXT_HTML("text/html"),
	TEXT_XML("text/xml");
	
	String value;
	
	Accept(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
