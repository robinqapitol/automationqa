package com.qapitol.automationqa.api.client;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class ApiUtils {

	ApiDataLog apiDataLog = new ApiDataLog();
	ApiAllureLog allureLog = new ApiAllureLog();

	public void addLogAndAllure(HttpRequest httpRequest) throws IOException {
		allureLog.attachHttpRequestInAllure(httpRequest);
		apiDataLog.logApiRequest(httpRequest);
	}

	public void addLogAndAllure(HttpResponse httpResponse) throws ParseException, IOException {
		apiDataLog.logApiResponse(httpResponse);
		allureLog.attachHttpResponseInAllure(httpResponse);
	}

	public String getEntityInString(HttpRequest httpRequest) throws ParseException, IOException {
		String entityString = null;
		if (httpRequest instanceof HttpEntityEnclosingRequest) {
			HttpEntityEnclosingRequest httpEntityEnclosingRequest = (HttpEntityEnclosingRequest) httpRequest;
			HttpEntity entityBody = httpEntityEnclosingRequest.getEntity();
			entityString = EntityUtils.toString(entityBody);
			StringEntity sten = new StringEntity(entityString);
			((HttpEntityEnclosingRequest) httpRequest).setEntity(sten);
		}
		return entityString;
	}

	public static String getEntityInString(HttpResponse httpResponse) throws ParseException, IOException {
		String entityString = null;
		HttpEntity entity = httpResponse.getEntity();
		entityString = EntityUtils.toString(entity);
		StringEntity sten = new StringEntity(entityString);
		httpResponse.setEntity(sten);
		return entityString;
	}

	public File responseAsFile(HttpResponse response, String filePath)
			throws UnsupportedOperationException, IOException {
		File file = null;
		InputStream inputStream = response.getEntity().getContent();
		FileOutputStream fileOutpuStream = new FileOutputStream(new File(filePath));
		int inByte;
		while ((inByte = inputStream.read()) != -1)
			fileOutpuStream.write(inByte);
		inputStream.close();
		fileOutpuStream.close();
		file = new File(filePath);
		return file;
	}

	public File responseAsFile_Method2(HttpResponse response, String filePath)
			throws UnsupportedOperationException, IOException {
		File file = null;
		InputStream inputStream = response.getEntity().getContent();
		FileUtils.copyInputStreamToFile(inputStream, new File(filePath));
		file = new File(filePath);
		return file;
	}
	
	public static <T> T responseToPojoObject(HttpResponse httpResponse, Class<T> className) throws ParseException, IOException {
		String responseContentType = null;
		Header[] headers = httpResponse.getHeaders("Content-Type");
		responseContentType = headers[0].getValue();
		T t = null;
		if(responseContentType != null && responseContentType.contains("json")) {
			t = convertJsonStringToPojoObject(ApiUtils.getEntityInString(httpResponse), className);
		}else if(responseContentType != null && responseContentType.contains("xml")) {
			t = convertXmlStringToPojoObject(ApiUtils.getEntityInString(httpResponse), className);
		}
		return t;
	}
	
	public static <T> T convertJsonStringToPojoObject(String value, Class<T> className) throws JsonMappingException, JsonProcessingException {
		T t = null;
			ObjectMapper objectMapper = new ObjectMapper();
			t = objectMapper.readValue(value, className);
		return t;
	}
	
	public static <T> T convertXmlStringToPojoObject(String value, Class<T> className) throws JsonMappingException, JsonProcessingException {
		T t = null;
		XmlMapper xmlMapper = new XmlMapper();
		t = xmlMapper.readValue(value, className);
		return t;
	}
	
	public static <T> String convertPojoObjectToJsonString(T payload) throws JsonMappingException, JsonProcessingException {
		String stringEntity = null;
		ObjectMapper objectMapper = new ObjectMapper();
		stringEntity = objectMapper.writeValueAsString(payload);
		return stringEntity;
	}
	
	public static <T> String convertPojoObjectToXmlString(T payload) throws JsonMappingException, JsonProcessingException {
		String stringEntity = null;
		XmlMapper xmlMapper = new XmlMapper();
		stringEntity = xmlMapper.writeValueAsString(payload);
		return stringEntity;
	}
}
