package com.qapitol.automationqa.api.client;

public enum ContentType {

	APPLICATION_JSON("application/json"),
	APPLICATION_XML("application/xml"),
	MULTIPART_FORM("multipart/form-data"),
	URL_ENCODED_FORM("application/x-www-form-urlencoded");
	
	String value;
	
	ContentType(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
