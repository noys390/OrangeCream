package qa.base;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class clinchUtilities extends clinchBase  {

	
//Taking screen shots ******************************************
	
	public void takingScr(){
		 
		  // Take screenshot and store as a file format
		  File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		  // now copy the  screenshot to desired location using copyFile method
		 
		 FileUtils.copyFile(src, new File("D:\\seleniumwork\\OrangeFramework\\workspace\\clinchPad\\screenShots\\"+System.currentTimeMillis()+".png"));
		       }
		 
		catch (Exception e)
		 
		{
		 
		System.out.println(e.getMessage());
		 
		    }
		 
		}
		 


  public void takingScr(String scrName){
			 
			  // Take screenshot and store as a file format
			  File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
			  // now copy the  screenshot to desired location using copyFile method
			 
			 FileUtils.copyFile(src, new File("D:\\seleniumwork\\OrangeFramework\\workspace\\clinchPad\\screenShots\\"+scrName+".png"));
			       }
			 
			catch (Exception e)
			 
			{
			 
			System.out.println(e.getMessage());
			 
			    }
			 
			}


//User defined wait ******************************************

public boolean isElementPresnt(WebDriver driver,WebElement ele,int time)
{

//WebElement ele = null;
	boolean elePresence = false ;

   for(int i=0;i<time;i++) {
  try{
//ele=driver.findElement(By.xpath(xpath));
	elePresence = ele.isDisplayed();
    break;
     }
  catch(Exception e)
    {
      try 
      {
        Thread.sleep(500);
      } catch (InterruptedException e1) 
         {
            System.out.println("Waiting for element to appear");
           }
     }

   }
   return elePresence;

   }


}









