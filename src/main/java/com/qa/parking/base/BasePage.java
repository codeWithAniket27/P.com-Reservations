package com.qa.parking.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.parking.utils.ElementUtil;

public class BasePage {
	public static WebDriver driver;
	public Properties prop;
	public ElementUtil elementUtil;
	public static String TEST_DATA_SHEET_PATH;
	
	private WebDriver driver() {
		return driver;
	}
	
	public WebDriver init_driver(Properties prop) {
		String browserName = prop.getProperty("browser");

		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			System.out.println("chrome created");
		} else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			System.out.println("firefox created");
		} else if(browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
			System.out.println("safari created");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//		getDriver().manage().window().fullscreen();
		//		getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

		return driver();
		
	}
	public Properties init_prop() {
		prop = new Properties();
		String path = null;
		String env = null;

		try {
			env = System.getProperty("env");
			System.out.println("env value is---> "+env);
			if(env == null) {
				TEST_DATA_SHEET_PATH = ".\\src\\main\\java\\com\\qa\\parking\\testdata\\QATestData.xlsx";
				path = "./src/main/java/com/qa/parking/config/config.properties";
			} else {
				switch(env) {
				case "dev":
					TEST_DATA_SHEET_PATH = ".\\src\\main\\java\\com\\qa\\parking\\testdata\\QATestData.xlsx";
					path = "./src/main/java/com/qa/parking/config/config.properties";
					break;

				case "qa":
					TEST_DATA_SHEET_PATH = ".\\src\\main\\java\\com\\qa\\parking\\testdata\\QATestData.xlsx";
					path = "./src/main/java/com/qa/parking/config/config.properties";
					break;

				case "prod":
					path = "./src/main/java/com/qa/parking/config/config.properties";
					break;

				default: 
					System.out.println("Please pass the correct env value----> "+env);
					break;
				}
			}
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public static void takeScreenshot(String filename) {
		try {
		String path="C:\\Users\\banka_9t92sgc\\OneDrive\\Documents\\Personal\\Automation\\Parking.com\\screenshots\\";
		TakesScreenshot ss=(TakesScreenshot)driver;
		File src=ss.getScreenshotAs(OutputType.FILE);
		File des=new File(path+filename+".png");
		FileHandler.copy(src, des);
	} 
	catch (IOException e) {
		e.printStackTrace();
	}
}
}
