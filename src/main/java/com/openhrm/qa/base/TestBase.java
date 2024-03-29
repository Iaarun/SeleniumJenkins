package com.openhrm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.openhrm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
public	static WebDriver driver;
public	static Properties prop;

	public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
					"\\src\\main\\java\\com\\openhrm\\qa\\config\\config.properties");
		  	prop.load(fis);
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browsername=prop.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome")) {
			System.out.println("browsr start");
			//System.setProperty("webdriver.chrome.driver", "E:\\browserdriver\\chrome80\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("browsr launch");
		}else if (browsername.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver", "E:\\browserdriver\\ff26\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("ie")) {

		//	System.setProperty("webdriver.ie.driver", "E:\\browserdriver\\IEDriver311\\IEDriverServer.exe");
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}else {
			System.out.println("Invalid Browser choice");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		System.out.println("app launch");
	}

}
