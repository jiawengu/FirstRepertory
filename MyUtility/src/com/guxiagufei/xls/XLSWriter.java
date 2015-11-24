package com.guxiagufei.xls;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class XLSWriter {
	private HSSFWorkbook book;
	private HSSFSheet sheet;
	
	public XLSWriter() {
		book = new HSSFWorkbook();
		sheet = book.createSheet();
	}
	public void writeTwoLines(String firstColumn, String secondColumn, int lineNum){
		HSSFRow row = sheet.createRow(lineNum);
		HSSFCell firstCell = row.createCell(0);
		firstCell.setCellValue(firstColumn);
		HSSFCell secondCell = row.createCell(1);
		secondCell.setCellValue(secondColumn);
	}
	public void commit(String resultPath){
		File file = new File(resultPath);
		try {
			OutputStream os = new FileOutputStream(file);
			book.write(os);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
