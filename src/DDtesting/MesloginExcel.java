package DDtesting;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Excellib.ExcelDataConfig;


public class MesloginExcel {

	WebDriver driver;

	@Test(dataProvider = "MesData")
	public void loginMes(String userNmae, String password) throws InterruptedException

	{

		System.setProperty("webdriver.gecko.driver", "E://geckodriver-v0.24.0-win64//geckodriver.exe");
		Thread.sleep(20000);

		driver = new FirefoxDriver();
		driver.get("http://192.168.10.242");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(userNmae);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		      

		Thread.sleep(5000);
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("homePage"), "User login Unsccessfully");
		System.out.println("User is able to login Successfully");

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

	@DataProvider(name = "MesData")
	public Object[][] passData() {

		ExcelDataConfig config = new ExcelDataConfig("E:\\testmes_automation\\InputM.xlsx");

		int row = config.getRowcount(0);

		Object[][] data = new Object[row][2];

		for (int i = 0; i < row; i++) {
			data[i][0] = config.getData(0, i, 0);
			data[i][1] = config.getData(0, i, 1);
		}

		return data;
	 
	
	}

}
