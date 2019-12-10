package com.qapitol.automationqa.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public String getValue(String path, String sheetName, int rowNum, int colNum) throws IOException {
		String value = null;
		File excelFile = new File(path);
		InputStream inputStream = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(rowNum);
		XSSFCell cell = row.getCell(colNum);
		DataFormatter dataFormater = new DataFormatter();
		value = dataFormater.formatCellValue(cell);
		return value;
	}
}
