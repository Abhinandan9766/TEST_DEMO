package readdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readdata1 {

	public static void main(String[] args) throws Exception {
		File src= new File("E:\\testmes_automation\\mestest.xlsx");
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb= new XSSFWorkbook(fis);

		XSSFSheet sheet1=wb.getSheetAt(0);
		
	int rowcount=sheet1.getLastRowNum();
	
		System.out.println("Total no of row is "+rowcount);
		for (int i=0;i<rowcount;i++)
		{
			String data0=sheet1.getRow(i).getCell(0).getStringCellValue();
			String data1=sheet1.getRow(i).getCell(1).getStringCellValue();
			sheet1.getRow(i).createCell(2).setCellValue("Pass");
			
		//	System.out.println("Row is = "+i);
		    System.out.println("Usre Name is = "+data0);
		   System.out.println("Password is = "+data1);
		
			}
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		
        wb.close();

	}

}









