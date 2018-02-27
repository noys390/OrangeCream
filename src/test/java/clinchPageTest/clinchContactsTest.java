package clinchPageTest;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import clinchPages.clinchContacts;
import clinchPages.clinchLogin;
import clinchPages.clinchMyTodo;
import qa.base.clinchBase;

public class clinchContactsTest extends clinchBase {

	clinchLogin cl;
	clinchContacts ccn;	
	
	public clinchContactsTest(){
		initProp();
	}
	

@BeforeMethod
	public void setUp(){
	initBrowser();
	driver.get("https://clinchpad.com");
	cl = new clinchLogin();	
   	cl.goToLoginPage();
	cl.signinToClinch(prop.getProperty("username"), prop.getProperty("password"));	
	}
   
// CSV import
   @Test(priority=1)
 	public void ImportContacts(){
	   ccn = new clinchContacts();
	   ccn.navigateContacts();
	   try {
		ccn.importContactCsv();
	} catch (IOException e) {}
   }
   
   @AfterMethod
	public void closeBrowser(){
		driver.quit();
	}
}
