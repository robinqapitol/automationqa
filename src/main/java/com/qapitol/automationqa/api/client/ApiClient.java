package com.qapitol.automationqa.api.client;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.status.StatusLogger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class ApiClient {

	Logger log = LogManager.getLogger(getClass());
	
	static ApiUtils apiUtils = new ApiUtils();

	public void check() throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet getCall = new HttpGet("http://reqres.in/api/users?page=2");
		CloseableHttpResponse response = client.execute(getCall);
		HttpEntity entity = response.getEntity();
		String res = EntityUtils.toString(entity);
		log.info("response111111:"+res);
		StringEntity sten = new StringEntity(res);
		response.setEntity(sten);
		log.info("response22222:"+EntityUtils.toString(response.getEntity()));
	}
	
	public void check2() throws ClientProtocolException, IOException {
		HttpClient client = HttpClients.createDefault();
		HttpPost postRequest = new HttpPost("http://dummy.restapiexample.com/api/v1/create");
		HttpEntity entity = new StringEntity("{\"name\":\"tes6778585t\",\"salary\":\"123\",\"age\":\"23\"}");
		postRequest.setEntity(entity);
		postRequest.setHeader("Content-Type","application/json");
		HttpResponse response = client.execute(postRequest);
		log.info("Response:"+response.getStatusLine().getStatusCode());
		log.info("Response:"+EntityUtils.toString(response.getEntity()));
	}
	
	public static HttpResponse httpExecute(String hostName, Map<String, String> headers, ApiMethod method, String endPoint,
			Map<String, String> pathParams, Map<String, String> queryParams, String payload, Map<String, Object> form,
			ContentType contentType, Accept accept) throws ClientProtocolException, IOException {

		HttpResponse httpResponse = null;
		HttpClient client = HttpClients.createDefault();

		if (endPoint != null && pathParams != null && pathParams.size() > 0) {
			for (Map.Entry<String, String> pathParam : pathParams.entrySet()) {
				endPoint = endPoint.replace("{" + pathParam.getKey() + "}", pathParam.getValue());
			}
		}

		String uri = hostName;
		if (endPoint != null)
			uri = uri + endPoint;

		if (headers == null && contentType != null) {
			headers = new HashMap<String, String>();
			headers.put("Content-Type", contentType.getValue());
		}else if(contentType != null) {
			headers.put("Content-Type", contentType.getValue());
		}

		if ( headers == null && accept != null) {
			headers = new HashMap<String, String>();
			headers.put("Accept", accept.getValue());
		}else if(accept != null){
			headers.put("Accept", accept.getValue());
		}

		if (queryParams != null && queryParams.size() > 0) {
			uri = uri + "?";
			for (Map.Entry<String, String> param : queryParams.entrySet()) {
				if (!uri.endsWith("?"))
					uri = uri + "&";
				uri = uri + param.getKey() + "=" + param.getValue();
			}
		}

		switch (method) {
		case GET: {
			HttpGet getRequest = new HttpGet(uri);
			if (headers != null && headers.size() > 0) {
				for (Map.Entry<String, String> head : headers.entrySet()) {
					getRequest.addHeader(head.getKey(), head.getValue());
				}
			}
			apiUtils.addLogAndAllure(getRequest);
			httpResponse = client.execute(getRequest);
			apiUtils.addLogAndAllure(httpResponse);
			break;
		}
		case POST: {
			HttpPost postRequest = new HttpPost(uri);
			if (headers != null && headers.size() > 0) {
				for (Map.Entry<String, String> head : headers.entrySet()) {
					postRequest.addHeader(head.getKey(), head.getValue());
				}
			}
			if (payload != null) {
				HttpEntity entity = new StringEntity(payload);
				postRequest.setEntity(entity);
			}

			if (form != null && form.size() > 0) {
				if (contentType == ContentType.MULTIPART_FORM) {
					postRequest.removeHeaders("Content-Type"); // below method will add correct Content-Type
					MultipartEntityBuilder multipart = MultipartEntityBuilder.create();
					multipart.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
					for (Map.Entry<String, Object> eachForm : form.entrySet()) {
						if (eachForm.getValue() instanceof File) {
							multipart.addBinaryBody(eachForm.getKey(), (File) eachForm.getValue());
						} else {
							multipart.addTextBody(eachForm.getKey(), eachForm.getValue().toString());
						}
					}
					HttpEntity formEntity = multipart.build();
					postRequest.setEntity(formEntity);
				} else if (contentType == ContentType.URL_ENCODED_FORM) {
					List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
					for (Map.Entry<String, Object> eachForm : form.entrySet()) {
						nameValuePairs.add(new BasicNameValuePair(eachForm.getKey(), eachForm.getValue().toString()));
					}
					UrlEncodedFormEntity urlEncodedForm = new UrlEncodedFormEntity(nameValuePairs, "utf-8");
					urlEncodedForm.setContentType(contentType.getValue());
					postRequest.setEntity(urlEncodedForm);
				}
			}
			apiUtils.addLogAndAllure(postRequest);
			httpResponse = client.execute(postRequest);
			apiUtils.addLogAndAllure(httpResponse);
			break;
		}
		case PUT: {
			HttpPut putRequest = new HttpPut(uri);
			if (headers != null && headers.size() > 0) {
				for (Map.Entry<String, String> head : headers.entrySet()) {
					putRequest.addHeader(head.getKey(), head.getValue());
				}
			}
			if (payload != null) {
				HttpEntity entity = new StringEntity(payload);
				putRequest.setEntity(entity);
			}
			apiUtils.addLogAndAllure(putRequest);
			httpResponse = client.execute(putRequest);
			apiUtils.addLogAndAllure(httpResponse);
			break;
		}
		case DELETE: {
			HttpDelete deleteRequest = new HttpDelete(uri);
			if (headers != null && headers.size() > 0) {
				for (Map.Entry<String, String> head : headers.entrySet()) {
					deleteRequest.addHeader(head.getKey(), head.getValue());
				}
			}
			apiUtils.addLogAndAllure(deleteRequest);
			httpResponse = client.execute(deleteRequest);
			apiUtils.addLogAndAllure(httpResponse);
			break;
		}
		}
		return httpResponse;
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
