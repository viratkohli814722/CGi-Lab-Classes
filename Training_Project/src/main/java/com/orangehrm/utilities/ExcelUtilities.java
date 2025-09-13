package com.orangehrm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	public static Object[][] getData(String excelpath, String sheetname) throws IOException {
		  
		  String[][] data=new String[2][2];
		  
			String projectpath=System.getProperty("user.dir");
			//File file1=new File(projectpath+"\\src\\test\\resources\\Orangehrm_TestData\\Data.xlsx");
			
			File file1=new File(excelpath);
			System.out.println("project path:"+projectpath);
			FileInputStream fs=new FileInputStream(file1);
			XSSFWorkbook workbook=new XSSFWorkbook(fs);
			XSSFSheet worksheet=workbook.getSheet(sheetname);
			int rowcount=worksheet.getPhysicalNumberOfRows();
			System.out.println("rows:"+rowcount);
			for(int i=0;i<rowcount;i++)
			{
				data[i][0]=worksheet.getRow(i).getCell(0).getStringCellValue();
				data[i][1]=worksheet.getRow(i).getCell(1).getStringCellValue();
			}
		    return data;
	  }
}
