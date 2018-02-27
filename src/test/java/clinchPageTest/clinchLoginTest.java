package clinchPageTest;



import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import clinchPages.clinchLogin;
import qa.base.clinchBase;
import qa.base.clinchUtilities;




public class clinchLoginTest extends clinchBase{
	
	clinchLogin cl;
	clinchUtilities cU;
	SoftAssert softas = new SoftAssert(); 
	//Logger log = Logger.getLogger(clinchLoginTest.class);
	
		
	public clinchLoginTest(){
		initProp();
	}
	
   @BeforeMethod
	public void setUp(){
	initBrowser();
	driver.get("https://clinchpad.com");
	cl = new clinchLogin();	
	cU = new clinchUtilities();
		
	}
   
    @Test(priority=1)
	public void loginPageTitleTest(){
		cl.LoginPageTitle();
		System.out.println(cl.title);		
	}
    
    // added the scr-shot function
    @Test(priority=2)
    public void signinToClinchTest(){
    	cl.goToLoginPage();
    	cl.signinToClinch(prop.getProperty("username"), prop.getProperty("password"));
    	//cU.takingScr();
    	//cU.takingScr("signingIn");    	
    }
    
    @AfterMethod
	public void closeBrowser(){
		driver.quit();
	}
}
