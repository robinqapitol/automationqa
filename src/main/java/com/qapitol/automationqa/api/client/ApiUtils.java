package com.qapitol.automationqa.api.client;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;

public class ApiUtils {

	ApiDataLog apiDataLog = new ApiDataLog();
	ApiAllureLog allureLog = new ApiAllureLog();
	
	public void addLogAndAllure(HttpRequest httpRequest) throws IOException {
		apiDataLog.logApiRequest(httpRequest);
		allureLog.attachHttpRequestInAllure(httpRequest);
	}
	
	public void addLogAndAllure(HttpResponse httpResponse) throws ParseException, IOException {
		apiDataLog.logApiResponse(httpResponse);
		allureLog.attachHttpResponseInAllure(httpResponse);
	}
	
	public static String getEntityInString(HttpEntity entity) {
		String entityString = null;
		
		return entityString;
	}
	
	public File responseAsFile(HttpResponse response, String filePath) throws UnsupportedOperationException, IOException {
		File file = null;
		InputStream inputStream = response.getEntity().getContent();
		FileOutputStream fileOutpuStream = new FileOutputStream(new File(filePath));
		int inByte;
		while((inByte = inputStream.read()) != -1)
			fileOutpuStream.write(inByte);
		inputStream.close();
		fileOutpuStream.close();
		file = new File(filePath);
		return file;
	}
	
	public File responseAsFile_Method2(HttpResponse response, String filePath) throws UnsupportedOperationException, IOException {
		File file = null;
		InputStream inputStream = response.getEntity().getContent();
		FileUtils.copyInputStreamToFile(inputStream, new File(filePath));
		file = new File(filePath);
		return file;
	}
}
