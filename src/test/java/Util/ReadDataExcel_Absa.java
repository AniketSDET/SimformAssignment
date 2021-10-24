package Util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataExcel_Absa {
	static File file;
	static FileInputStream fis ;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static XSSFRow row;
	
	public static void readData(String testcase) throws Exception{
		
		file = new File(System.getProperty("user.dir") + "\\TestData\\TestData.xlsx");
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		
//ABSA framework logic
		switch(testcase)
		{
		case "aniket":
			sheet = wb.getSheet("aniket");
			row = sheet.getRow(1);
			String URL = row.getCell(0).getStringCellValue();
			System.out.println(URL);
			String link = row.getCell(1).getStringCellValue();
			System.out.println(link);
			break;
		default:
		System.out.println("Wrong input");
		break;
		}
		
	}

	
	
	
	
	
}
