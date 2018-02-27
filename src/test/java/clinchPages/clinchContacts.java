package clinchPages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.base.clinchBase;

public class clinchContacts extends clinchBase{
	
	// Page OR
	@FindBy(xpath = "//li/a[contains(text(),'More')]")
	WebElement MoreLink;
	
	@FindBy(xpath = "//li/a[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	@FindBy(xpath = "(.//*[@id='import-contacts'])[2]")
	WebElement ImportContactsBtn;
	
	@FindBy(xpath = "(.//*[@id='import-contacts']/ul/li[1]/a)[2]")
	WebElement fromCsvFile;
	
	@FindBy(xpath = "//button[contains(text(),'Pick File')]")
	WebElement pickFileBtn;
	
	@FindBy(xpath = ".//*[@id='fileUploadInput']")
	WebElement fileUploadInput;


public clinchContacts() {
	PageFactory.initElements(driver, this);
  }

public void navigateContacts() {
	
	 System.out.println("stated navigate"); 	
	 Actions action = new Actions(driver);	 
   	action.moveToElement(MoreLink).build().perform();
   	ContactsLink.click();	
   	System.out.println("we have navigated");
   	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) { } 
}

public void importContactCsv() throws IOException{
	ImportContactsBtn.click();
	fromCsvFile.click();
 	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) { } 
 	pickFileBtn.click();
 	
 	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) { } 
 	
 	driver.switchTo().frame("filepicker_dialog");
 	fileUploadInput.click();
 	
 	try {
		Thread.sleep(1000);
 	} catch (InterruptedException e) { } 
 	
Runtime.getRuntime().exec("D:\\seleniumwork\\OrangeFramework\\workspace\\clinchPad\\CSVfiles\\contactUpload.exe");
 	
}

}
