package clinchPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.base.clinchBase;
import qa.base.clinchUtilities;

public class clinchLogin extends clinchBase{
	
	// variables
	public String title;
	clinchUtilities cu;
	
	// Page OR
	
	@FindBy(xpath=".//a/div[contains(text(),'LOGIN' )]")
	WebElement loginLn;
   
	@FindBy(id="user_email")
	WebElement username; 
	
	@FindBy(id="user_password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Sign in']")
	WebElement SigninBtn;
	
	@FindBy(id="lookup-lead")
	WebElement searchIcon; 
	
	//Initializing the Page Objects:
	public clinchLogin(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void LoginPageTitle(){
		title= driver.getTitle();
	}
	
	public void goToLoginPage(){
		loginLn.click();
	}
	
	public void signinToClinch(String uname, String passwd){
		username.sendKeys(uname);
		password.sendKeys(passwd);
		SigninBtn.click();
		cu = new clinchUtilities();
		if (cu.isElementPresnt(driver, searchIcon, 5)){
			searchIcon.sendKeys("reached");			
		}
		cu.takingScr("enteringHome");
		
	}
	
	
	
}

