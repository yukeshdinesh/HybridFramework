package org.yukesh;



import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	static Properties  properties = new Properties();
	static WebDriver driver;
	
	@BeforeMethod
	public static WebDriver setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 //driver.manage().window().maximize();
		 try {
			initProp();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}
	
	
	public static  void initProp() throws IOException {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\prop.properties");
			System.out.println(System.getProperty("user.dir"));
			properties.load(fis);
			
	}
	
	public static String getProp(String propValue) {
		return properties.getProperty(propValue);		
	}
	
	//@AfterMethod
	public static void closeBrowser() {
		driver.close();
		
	}
	
	@AfterSuite
	public void afterSuite(){
		driver.quit();
	}

}
