package DDtesting;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Meslogin {

	WebDriver driver;

	@Test(dataProvider = "MesData")
	public void loginMes(String userNmae, String password) throws InterruptedException

	{

		System.setProperty("webdriver.gecko.driver", "E://geckodriver-v0.24.0-win64//geckodriver.exe");
		Thread.sleep(20000);

		driver = new FirefoxDriver();
		driver.get("http://192.168.10.242/mes-web-app");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(userNmae);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

		Thread.sleep(5000);
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("homePage"));
		System.out.println("User is able to login Successfully");

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

	@DataProvider(name = "MesData")
	public Object[][] passData() {
		Object[][] data = new Object[3][2];

		data[0][0] = "Admin";
		data[0][1] = "Usit@1234";

		data[1][0] = "Admi";
		data[1][1] = "usit1";

		data[2][0] = "Admin";
		data[2][1] = "Usit@";

		return data;

	}

}
