package com.guxiagufei.xls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class XLSReader {
	
	@SuppressWarnings("unused")
	private HSSFWorkbook book;
	private HSSFSheet sheet;
	
	public XLSReader(HSSFWorkbook book, HSSFSheet sheet) {
		super();
		this.book = book;
		this.sheet = sheet;
	}

	/**
	 * 获得XLS文件中的数据
	 * @param filePath
	 * @param startRow
	 * @param firstColumn
	 * @param secondColumn
	 * @param sheetOrder
	 * @return
	 */
	public Map<Integer,String> getData(String filePath, int startRow, int firstColumn, int secondColumn, int sheetOrder){
		File file = new File(filePath);
		Map<Integer,String> map = new HashMap<Integer, String>();
		try {
			@SuppressWarnings("resource")
			HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(file));
			HSSFSheet sheet = book.getSheetAt(sheetOrder);
			int rowTotal = sheet.getLastRowNum() + 1;
			for (int i = startRow - 1; i < rowTotal; i++) {
				HSSFRow row = sheet.getRow(i);
				HSSFCell firstCell = row.getCell(firstColumn);
				int firstValue = (int)firstCell.getNumericCellValue();
				HSSFCell secondCell = row.getCell(secondColumn);
				String secondValue = secondCell.getStringCellValue();
				map.put(firstValue, secondValue);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 读五行String数据，flag表示是否从第一行开始读
	 * @param flag
	 * @return
	 */
	public List<String[]> readFiveLines(boolean flag){
		List<String[]> list = new ArrayList<String[]>();
		int rowTotal = sheet.getLastRowNum() + 1;
		int isFirst = 0;
		if(flag == false){
			isFirst = 1;
		}
		for (int i = isFirst; i < rowTotal; i++) {
			String[] strings = new String[5];
			HSSFRow row = sheet.getRow(i);
			for (int j = 0; j < strings.length; j++) {
				System.out.println(j);
				HSSFCell cell = row.getCell(j);
				if(cell.getCellType() == Cell.CELL_TYPE_STRING){
					strings[j] = cell.getStringCellValue();
				}else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
					strings[j] = cell.getNumericCellValue() + "";
				}
			}
			list.add(strings);
		}
		return list;
	}
}
