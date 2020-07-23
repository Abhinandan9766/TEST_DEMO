package readdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Getdata {

	public static void main(String[] args) throws Exception {
		
		File src= new File("E:\\testmes_automation\\mestest.xlsx");
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet1=wb.getSheetAt(0);
		
		String data0=sheet1.getRow(1).getCell(0).getStringCellValue();// to read from excel
		System.out.println("UserName is ="+data0 );// to read from excel
		sheet1.getRow(0).createCell(2).setCellValue("Status");// to write from excel
		sheet1.getRow(1).createCell(2).setCellValue("Pass");// to write in excel
		
		
		String data1=sheet1.getRow(1).getCell(1).getStringCellValue();// to read from excel
		System.out.println("Password is="+data1 );// to read from excel
	
		
		FileOutputStream fout=new FileOutputStream(src);// to write in excel
		wb.write(fout);// to write in excel
		System.out.println("***" );// to read from excel
	
        wb.close();
	}

}
