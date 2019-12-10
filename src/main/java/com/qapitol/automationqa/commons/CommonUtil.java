package com.qapitol.automationqa.commons;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class CommonUtil {

	public static String getRandomString() {
		String randomString = null;
		String pattern = "yyyyMMMddEHHmmssSSS";  // "HHmmssSSS"
		DateTimeFormatter dateTime = DateTimeFormatter.ofPattern(pattern);
		LocalDateTime now = LocalDateTime.now();
		randomString = dateTime.format(now);
		return randomString;
	}
	
	public static String giveStringOfPdf(File pdfFile) throws IOException {
		String pdfTxt = null;
		PDDocument pdDoc = PDDocument.load(pdfFile);
		PDFTextStripper stripper = new PDFTextStripper();
		pdfTxt = stripper.getText(pdDoc);
		return pdfTxt;
	}
	
}
