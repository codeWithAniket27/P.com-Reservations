package com.qa.parking.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	String path;
	File file;
	FileInputStream fis;
	XSSFWorkbook workbook;
	
	public ExcelUtil() throws IOException{
		path="C:\\Users\\banka_9t92sgc\\OneDrive\\Documents\\Personal\\Automation\\Parking.com\\src\\main\\java\\com\\qa\\parking\\testdata\\QATestData.xlsx";
		file=new File(path);
		fis=new FileInputStream(file);
		workbook=new XSSFWorkbook(fis);
	}
	
	public String ExcelutilsReadData(String sheetname,int rownum,int cellnum)
	{
		XSSFSheet sheet=workbook.getSheet(sheetname);
		XSSFRow row=sheet.getRow(rownum);
		XSSFCell cell=row.getCell(cellnum);
		DataFormatter df=new DataFormatter();
		String data=df.formatCellValue(cell);
		return data;
	}
	
	public int getrowcount(String sheetname)
	{
		XSSFSheet sheet=workbook.getSheet(sheetname);
		int rowcount=sheet.getLastRowNum();
		return rowcount;
	}
	
	public int getcellcount(String sheetname,int rownum)
	{
		XSSFSheet sheet=workbook.getSheet(sheetname);
		int cellcount=sheet.getRow(rownum).getLastCellNum();
		return cellcount;
	}

}
