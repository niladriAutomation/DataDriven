package testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import resources.Base;


public class LoginTest extends Base {
	public static WebDriver driver;
	//DataFormatter formatter = new DataFormatter();
	@Test(dataProvider="driveTest")
	public static void login(String username , String password) {
	driver = initializeBrowser();
	LoginPage lp = new LoginPage(driver);
	lp.enterUserName().sendKeys(username);
	lp.enterPassword().sendKeys(password);
	lp.clickSubmit().click();
	driver.close();
	
		
	}
	
	@DataProvider(name="driveTest")
	public Object[][] getData() throws IOException {
	DataFormatter formatter = new DataFormatter();
	FileInputStream fis = new FileInputStream("/Users/niladridas/eclipse-workspace/DatadrivenTesting/DataDrivenTestingFile.xlsx");
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sheet = wb.getSheetAt(0);
	int rowcount = sheet.getPhysicalNumberOfRows();
	XSSFRow row = sheet.getRow(0);
	int colcount = row.getLastCellNum();
	Object data [][] = new Object[rowcount -1][colcount] ;
	for (int i =0 ;i<rowcount -1 ;i++) {
		row = sheet.getRow(i+1);
		for (int j =0;j<colcount;j++) {
			XSSFCell cell = row.getCell(j);	
			
			data[i][j] = formatter.formatCellValue(cell);
			
		}
	}
	return data;
	
		
	}
	
}