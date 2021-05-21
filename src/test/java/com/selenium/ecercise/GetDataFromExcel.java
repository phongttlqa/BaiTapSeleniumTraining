package com.selenium.ecercise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetDataFromExcel {
	public FileInputStream inputStream ;
	
	public ArrayList<DataGetTotal> getData() {
		ArrayList<DataGetTotal> dataList = new ArrayList<DataGetTotal>(); 
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(new File("C:\\Users\\LQA\\Desktop\\PhongTT\\GetTotalExercise.xlsx"));
//			HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
//			HSSFSheet sheet = workbook.getSheetAt(0);
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workbook.getSheetAt(0);
//			FormulaEvaluator formulaEvaluator=workbook.getCreationHelper().createFormulaEvaluator();  
			sheet.removeRow(sheet.getRow(sheet.getFirstRowNum())); // xoa hang dau tien
			for (Row row : sheet) {
				int a = 0, b = 0;
				for (Cell cell : row) {
					
//					System.out.print("cell.getRowIndex() "+cell.getRowIndex()); // theo hang
//					System.out.print(" - cell.getColumnIndex() "+cell.getColumnIndex()); // theo cot
					switch (cell.getColumnIndex()) {
					case 0:
						a = (int) cell.getNumericCellValue();
						break;
					case 1:
						b = (int) cell.getNumericCellValue();
						break;
					default:
						break;
					}
				}
				dataList.add(new DataGetTotal(a, b));
			}
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataList;
	}
	
}
