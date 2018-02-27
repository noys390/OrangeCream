package clinchPageTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import clinchPages.clinchLogin;
import clinchPages.clinchMyTodo;
import qa.base.clinchBase;

public class clinchMyTodoTest extends clinchBase {
	
	clinchLogin cl;
	clinchMyTodo cmt;
	
	public clinchMyTodoTest(){
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
   
   @Test(priority=1)
  	public void CreateTodoTest(){
	   cmt = new clinchMyTodo();
	 cmt.navigateToDo22(); 
	   cmt.CreateToDo();
    }
   
   @AfterMethod
 	public void closeBrowser(){
 		driver.quit();
 	}
   
  }
