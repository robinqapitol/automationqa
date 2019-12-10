package com.qapitol.automationqa.api.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApiDataLog {
	
	Logger log = LogManager.getLogger(getClass());
	
	
	public void logApiRequest(HttpRequest httpRequest) throws IOException {
		log.info("***************************************************************************");
		log.info("REQUEST:");
		log.info("Url:"+httpRequest.getRequestLine().getUri());
		log.info("Method:"+httpRequest.getRequestLine().getMethod());
		Header[] headers = httpRequest.getAllHeaders();
		for (Header header : headers) {
			log.info("Header:"+header.getName() +":"+ header.getValue());
		}
		if (httpRequest instanceof HttpEntityEnclosingRequest) {
			HttpEntityEnclosingRequest httpEntityEnclosingRequest = (HttpEntityEnclosingRequest) httpRequest;
			HttpEntity entityBody = httpEntityEnclosingRequest.getEntity();
			
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			entityBody.writeTo(outStream);
			String body = new String(outStream.toByteArray(), StandardCharsets.UTF_8);
			log.info(body);
		}
	}

	public void logApiResponse(HttpResponse httpResponse) throws ParseException, IOException {
		log.info("--****--");
		log.info("RESPONSE:");
		log.info("StatusCode:"+httpResponse.getStatusLine().getStatusCode());
		Header[] headers = httpResponse.getAllHeaders();
		for (Header header : headers) {
			log.info("Header:"+header.getName() +":"+ header.getValue());
		}
		log.info(ApiUtils.getEntityInString(httpResponse));
		log.info("***************************************************************************");	
	}
}
