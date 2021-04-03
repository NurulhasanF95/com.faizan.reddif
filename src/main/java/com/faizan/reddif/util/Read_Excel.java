package com.faizan.reddif.util;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Excel
{
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sh;
	
	public Read_Excel(String excelpath)
	{
		try 
		{
		fis=new FileInputStream(excelpath);
		wb=new XSSFWorkbook(fis);
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	//TO GET HOW MANY ROWS
	public int TotalRow(String Sheetname)
	{
		sh=wb.getSheet(Sheetname);
		int last_row_number=sh.getLastRowNum();
		last_row_number=last_row_number+1;
		return last_row_number;
	}
	
	//TO GET HOW MANY COLUMNS
	public Short Totalcolumn(String Sheetname)
	{
		Short last_column_number=0;
		sh=wb.getSheet(Sheetname);
		for(int i=0;i<sh.getLastRowNum();i++)
		{
			last_column_number=sh.getRow(i).getLastCellNum();
		}
		return last_column_number;
	}
	
	//TO GET DATA
	public String getdata(String Sheetname, int row,int col)
	{
		String entering_data= wb.getSheet(Sheetname).getRow(row).getCell(col).getStringCellValue();
		return entering_data;
	}

}
