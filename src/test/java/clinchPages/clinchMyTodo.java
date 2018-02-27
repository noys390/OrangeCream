package clinchPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qa.base.clinchBase;

public class clinchMyTodo extends clinchBase {
	
	// Page OR
	
	@FindBy(xpath="//li[@class='has-dropdown']/a[contains(text(),'Todo' )]")
	WebElement TodoLink;
	
	@FindBy(xpath="//li/a[contains(text(),'My Todos' )]")
	WebElement MyTodoLink;
	
	
	@FindBy(id="show-create-todos-modal")
	WebElement CreateTodoBtn; 
	
	@FindBy(id="todo-name")
	WebElement HaveToDo; 
	
	@FindBy(id="lead-name")
	WebElement leadName; 
	
	@FindBy(id="todo-datepicker")
	WebElement TodoDatePicket; 
	
	@FindBy(id="todo-timepicker")
	WebElement TodoTimePicker;
	
	@FindBy(id="todo-type")
	WebElement TodoTypeSelect; 
	
	@FindBy(xpath="//a/i[@class='icon icon-plus']")
	WebElement TodoSubmit;
	
	@FindBy(xpath="//strong[text()='joss']")
	WebElement dynPrmt;
	
	
 public clinchMyTodo() {
	 PageFactory.initElements(driver, this);
 }

	//Actions
 public void navigateToDo() {
	 
	 System.out.println("stated navigate"); 	
	 Actions action = new Actions(driver);	 
    	action.moveToElement(TodoLink).build().perform();
    	MyTodoLink.click();	
    	System.out.println("we have navigated");
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) { } 
 }
 
 public void navigateToDo22() {
	 JavascriptExecutor js = (JavascriptExecutor) driver;  
	 js.executeScript("arguments[0].click();", MyTodoLink);
 }
 
 public void CreateToDo() {
	 CreateTodoBtn.click();
	 HaveToDo.sendKeys("insane work");
	 leadName.sendKeys("joss");
	 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) { } 
	 
	 //enter lead name --------
	 List<WebElement> namelist = driver.findElements(By.xpath("//ul[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']//li/a"));
	 System.out.println("total no. of suggestion: "+namelist.size());
	 for (int i=0; i<namelist.size();i++) {
		 System.out.println(namelist.get(i).getText() );
	 }
	 
	 for (int i=0; i<namelist.size();i++) {
		 if (namelist.get(i).getText().equals("joss lescaf") ){
			 namelist.get(i).click();
			 break;
		 }		
	 }	 
	 // enter date ------------
	 TodoDatePicket.click();
	 List<WebElement> CalCells = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td/a"));
	 /*
	 for (int i=0; i<CalCells.size();i++) {
		 //System.out.println(CalCells.get(i).getText() );
		 if (CalCells.get(i).getText().equals("8") ){
			 CalCells.get(i).click();
			 break;
	        }
	 } */
	 			
	 for (WebElement dateN : CalCells) {
				System.out.println(dateN.getText());
				if (dateN.getText().equals("10")) {
					dateN.click();
					break;
				  }
			} 	  	
		
	 //enter time
	 JavascriptExecutor js = ((JavascriptExecutor) driver); 
	  	js.executeScript("arguments[0].value='8:20 AM';", TodoTimePicker);
    	//js.executeScript("arguments[0].click();", dynPrmt);
    	//js.executeScript("arguments[0].click();", TodoSubmit);
    	TodoSubmit.click(); 
	 
	 
 }
 
 
}
