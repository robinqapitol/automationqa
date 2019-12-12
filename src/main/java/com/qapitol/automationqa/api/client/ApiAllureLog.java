package com.qapitol.automationqa.api.client;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.protocol.HttpContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.qameta.allure.attachment.AttachmentData;
import io.qameta.allure.attachment.AttachmentProcessor;
import io.qameta.allure.attachment.AttachmentRenderer;
import io.qameta.allure.attachment.DefaultAttachmentProcessor;
import io.qameta.allure.attachment.FreemarkerAttachmentRenderer;
import io.qameta.allure.attachment.http.HttpRequestAttachment;
import io.qameta.allure.attachment.http.HttpResponseAttachment;

public class ApiAllureLog implements HttpRequestInterceptor {

	Logger log = LogManager.getLogger(getClass());
	
	AttachmentRenderer<AttachmentData> renderer;
	AttachmentProcessor<AttachmentData> processor;

	public ApiAllureLog() {
		// TODO Auto-generated constructor stub
		this(new FreemarkerAttachmentRenderer("http-request.ftl"), new DefaultAttachmentProcessor());
	}

	public ApiAllureLog(AttachmentRenderer<AttachmentData> renderer, AttachmentProcessor<AttachmentData> processor) {
		this.renderer = renderer;
		this.processor = processor;
	}

	public void attachHttpRequestInAllure(HttpRequest httpRequest) throws ParseException, IOException {
		HttpRequestAttachment.Builder builder = HttpRequestAttachment.Builder.create("Request",
				httpRequest.getRequestLine().getUri());

		builder.setMethod(httpRequest.getRequestLine().getMethod());

		Map<String, String> attachHeaders = new HashMap<String, String>();
		Header[] headers = httpRequest.getAllHeaders();
		for (Header header : headers) {
			attachHeaders.put(header.getName(), header.getValue());
		}
		builder.setHeaders(attachHeaders);

		if (httpRequest instanceof HttpEntityEnclosingRequest) {
			HttpEntityEnclosingRequest httpEntityEnclosingRequest = (HttpEntityEnclosingRequest) httpRequest;
			HttpEntity entityBody = httpEntityEnclosingRequest.getEntity();

			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			entityBody.writeTo(outStream);
			String body = new String(outStream.toByteArray(), StandardCharsets.UTF_8);
			log.info(body);
			builder.withBody(body);
			// String entityStringBody = EntityUtils.toString(entityBody);
			// builder.setBody(entityStringBody);
		}
		HttpRequestAttachment httpRequestAttachment = builder.build();
		this.processor.addAttachment(httpRequestAttachment, renderer);
	}

	public void attachHttpResponseInAllure(HttpResponse httpResponse, String entityStringBody)
			throws ParseException, IOException {

		// HttpEntity entityBody = httpResponse.getEntity();
		// String entityStringBody = EntityUtils.toString(entityBody);

		HttpResponseAttachment.Builder builder = HttpResponseAttachment.Builder.create("Response");

		Integer statusCode = httpResponse.getStatusLine().getStatusCode();
		//builder.setResponseCode(httpResponse.getStatusLine().getStatusCode());

		Map<String, String> attachHeaders = new HashMap<String, String>();
		Header[] headers = httpResponse.getAllHeaders();
		attachHeaders.put("statusCode:", statusCode.toString());
		for (Header header : headers) {
			attachHeaders.put(header.getName(), header.getValue());
		}
		builder.setHeaders(attachHeaders);

		// ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		// entityBody.writeTo(outStream);
		// String body = new String(outStream.toByteArray(), StandardCharsets.UTF_8);
		// builder.withBody(body);
		builder.setBody(entityStringBody);

		HttpResponseAttachment httpResponseAttachment = builder.build();
		this.processor.addAttachment(httpResponseAttachment, renderer);
	}

	public void attachHttpResponseInAllure(HttpResponse httpResponse) throws ParseException, IOException {

		// HttpEntity entityBody = httpResponse.getEntity();
		// String entityStringBody = EntityUtils.toString(entityBody);

		HttpResponseAttachment.Builder builder = HttpResponseAttachment.Builder.create("Response");

		//builder.setResponseCode(httpResponse.getStatusLine().getStatusCode());

		Map<String, String> attachHeaders = new HashMap<String, String>();
		Integer statusCode = httpResponse.getStatusLine().getStatusCode();
		attachHeaders.put("statusCode:", statusCode.toString());
		Header[] headers = httpResponse.getAllHeaders();
		for (Header header : headers) {
			attachHeaders.put(header.getName(), header.getValue());
		}
		builder.setHeaders(attachHeaders);

		// ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		// entityBody.writeTo(outStream);
		// String body = new String(outStream.toByteArray(), StandardCharsets.UTF_8);
		// builder.withBody(body);

		HttpEntity entity = httpResponse.getEntity();
		if (entity != null) {
			InputStream inputStream = entity.getContent();
			InputStreamReader inReader = new InputStreamReader(inputStream);
			BufferedReader bufReader = new BufferedReader(inReader);
			StringBuffer contentString = new StringBuffer();
			String line = null;
			while ((line = bufReader.readLine()) != null) {
				contentString.append(line);
			}
			builder.setBody(contentString.toString());
		}
		HttpResponseAttachment httpResponseAttachment = builder.build();
		this.processor.addAttachment(httpResponseAttachment, renderer);
	}

	@Override
	public void process(HttpRequest httpRequest, HttpContext context) throws HttpException, IOException {
		HttpRequestAttachment.Builder builder = HttpRequestAttachment.Builder.create("Request",
				httpRequest.getRequestLine().getUri());

		builder.setMethod(httpRequest.getRequestLine().getMethod());

		Map<String, String> attachHeaders = new HashMap<String, String>();
		Header[] headers = httpRequest.getAllHeaders();
		for (Header header : headers) {
			attachHeaders.put(header.getName(), header.getValue());
		}
		builder.setHeaders(attachHeaders);

		if (httpRequest instanceof HttpEntityEnclosingRequest) {
			HttpEntityEnclosingRequest httpEntityEnclosingRequest = (HttpEntityEnclosingRequest) httpRequest;
			HttpEntity entityBody = httpEntityEnclosingRequest.getEntity();

			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			entityBody.writeTo(outStream);
			String body = new String(outStream.toByteArray(), StandardCharsets.UTF_8);
			builder.withBody(body);
			
		}
		HttpRequestAttachment httpRequestAttachment = builder.build();
		this.processor.addAttachment(httpRequestAttachment, renderer);
	}
}
