package qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import org.apache.log4j.Logger;



public class clinchBase {
	
	public static WebDriver driver;
	public static Properties prop;
	

	
	public void initProp(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\seleniumwork\\OrangeFramework\\workspace\\clinchPadWork\\src\\main\\java\\qa\\base\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initBrowser(){
		
		String browserName = prop.getProperty("browser");
				
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\seleniumwork\\OrangeFramework\\drivers\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "D:\\seleniumwork\\OrangeFramework\\drivers\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		
		

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);		
		
		//driver.get("https://clinchpad.com");;
		
		
	}
	
	

}
