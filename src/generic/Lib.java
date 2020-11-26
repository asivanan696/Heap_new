package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class Lib implements IAutoConstant{

	private static final WebElement WebElement = null;

public WebDriver driver;



//Error
//	public static  String getCellData(String ExcelFilename,String sheetname,int row,int column) {
//
//		FileInputStream fis=new FileInputStream(EXCEL_FILE_PATH + ExcelFilename +".xlsx");
//		
//		
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sheet = wb.getSheet(sheetname);
//		Row row2 = sheet.getRow(row);
//		Cell c = row2.getCell(column);
//		cellvalue = c.toString();
//
//	}

	public static String getPropertyValue(String propertyName) {

		String propertyValue="";

		try {
			FileInputStream fis=new FileInputStream(CONFIGFILEPATH);
			Properties prop = new Properties();
			//Load the prperty file

			prop.load(fis);
			//Fetch the value
			propertyValue = prop.getProperty(propertyName);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return propertyValue;
	}

	
	public static void getlist(WebDriver driver, String exp)
	{
	 WebElement elements1 = driver.findElement(By.xpath(exp));
		Select s1=new Select(elements1);
		List<WebElement> options = s1.getOptions();
		int size = options.size();
		for (WebElement webElement : options) {
			String text = webElement.getText();
			System.out.println(text);
		}
		
	}
	
	public static void Listbox(String s,WebElement WebElement) {
	
	Select list=new Select (WebElement);
	
	List<WebElement> options =list.getOptions();
//int size=	options.size();
list.selectByVisibleText(s);
	
	}
	
	
	
	
	
	
	
	public static String  getcelldata(String ExcelFilename,String sheetname,int row,int column) {
		
		String cellvalue="";
		
		
		
		try {
			FileInputStream fis=new FileInputStream(EXCEL_FILE_PATH + ExcelFilename +".xlsx");
			
			
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet(sheetname);
			Row row2 = sheet.getRow(row);
			Cell c = row2.getCell(column);
			cellvalue = c.toString();
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cellvalue;
		
		
	}
	
	
	
	
	
	
//	
	public static int getrowcount(String ExcelFilename,String sheetname) throws EncryptedDocumentException, IOException {
		
		
		try {
			FileInputStream fis1=new FileInputStream(EXCEL_FILE_PATH + ExcelFilename +".xlsx");
			
			Workbook wb = WorkbookFactory.create(fis1);
			
			Sheet sh = wb.getSheet(sheetname);
			int lastRowNum = sh.getLastRowNum();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
		
	}
//	
	public static void captureScreenshot(WebDriver driver, String testMethodName) {

		try {

			TakesScreenshot ts= (TakesScreenshot) driver;
			File srcFile=	ts.getScreenshotAs(OutputType.FILE);
			String currentDATEAndTime = new Date().toString().replaceAll(":","_");

			File desFile= new File(SCREENSHOTS_PATH + testMethodName + "_"+ currentDATEAndTime +".png");
			Files.copy(srcFile, desFile);
		} catch (IOException e) {

		}

	}

}
