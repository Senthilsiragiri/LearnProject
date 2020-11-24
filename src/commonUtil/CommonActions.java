package commonUtil;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;


public class CommonActions {
	public  WebDriver driver;
	public  int timeoutSec = 120;
	public  String timeout = "60000";
	public  long wait = 7000 ;
	public  long sleep = 1000;	
	public  int objectpresent = 2;
	public  long pageload = 3000;
	
	

	/**
	 * The enterValue method will enter values in the text box based on the locator specified
	 * @param text
	 * @param locator
	 * @param driver   
	 * @throws Exception 
	 */
	public void enterValue(String text,By locator,WebDriver driver) throws Exception{
		try {

			int attempts = 0;
		    while(attempts < 24 ) {
		        try {
					waitForElementPresent(locator, driver);
					driver.findElement(locator).clear();
					driver.findElement(locator).sendKeys(text);
		            break;
		            
		        } catch(StaleElementReferenceException  e) {
		        	
		        	sleepForGivenTime(5000);
				    attempts++;
		        	System.out.println("Stale element exception:" + attempts);
		        	 
		        }catch(Exception e){
		        	throw e;
		        }
		        
		       
		    }
		    
		} catch (Exception e) {
			 throw e;
		}
	}
	
	/**
	 * The enterValue method will enter values using javascript executor
	 * @param text
	 * @param locator
	 * @param driver   
	 * @throws Exception 
	 */
	public void enterValueJSE(String text,String id,WebDriver driver) throws Exception{
		try {
			String idvalue ="'" + id +"'";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("document.getElementByID(" + idvalue  + ").setAttribute('value','')");
			//js.executeScript("document.getElementByID('ProcessPickList:bp:Prefix').setAttribute('value','')");
		} catch (Exception e) {
			 throw e;
		}
	}

	/**
	 * The clickElement method - wait for the element and also visible and then proceed with click
	 * @param text
	 * @param locator
	 * @param driver
	 * @throws Exception 
	 */
	public  void clickElement(By locator, WebDriver driver) throws Exception  {
			
			    int attempts = 0;
			    while(attempts < 24 ) {
			        try {
			        	
			        	waitForElementPresent(locator, driver);
						waitForElementVisible(locator, driver);
						driver.findElement(locator).click();
			            break;
			            
			        } catch(StaleElementReferenceException  e) {
			        	
			        	sleepForGivenTime(5000);
					    attempts++;
			        	System.out.println("Stale element exception:" + attempts);
			        	 
			        }catch(Exception e){
			        	throw e;
			        }
			        
			       
			    }
}

	/**
	 * This function waits for a particular element on a page to be visible
	 * @param By locator
	 * @param driver
	 * @throws Exception 
	 *  
	 */
	public  boolean waitForElementVisible(final By locator, WebDriver driver) throws Exception {
	try {
		boolean exists = false;

			for(int i=0;i<timeoutSec;i=i+1)
			{
				FluentWait<WebDriver> wait = new WebDriverWait(driver, timeoutSec)
				.ignoring( NoSuchElementException.class ) 
				.ignoring( StaleElementReferenceException.class);
				
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			
				
				
				
				if(element!=null)
				{				
					exists = true;
					break;
				} 
				else{
					sleepForGivenTime(1000);
				}
			}
			
			return exists;
	} catch (Exception e) {
		throw e;
	}
	}	
	/**
	 * The waitForElementPresent function will wait for the element for a
	 * default duration of customized seconds To increase or decrease this time
	 * change the value of the integer 'timeoutSec' in "Common.java"
	 * 
	 * @param Locator
	 * @param driver
	 * @throws Exception 
	 */
	public boolean waitForElementPresent(final By locator,WebDriver driver) throws Exception {                

		try {
			boolean exists = false;

			for(int i=0;i<timeoutSec;i=i+1)
			{
				WebDriverWait wait = new WebDriverWait(driver, timeoutSec);
				WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				
				sleepForGivenTime(1000);
				
				if(element!=null)
				{				
					exists = true;
					break;
				} 
				else{
					sleepForGivenTime(1000);
				}
			}
			return exists;
		} catch (Exception e) {
			
			throw e;
		}
		
	}       



	/**
	 * The sleepForGivenTime method - Will pause the script for the specific time period
	 * @param time
	 * @throws Exception 
	 */
	
	public  void sleepForGivenTime(long time) throws Exception{
		try {
			Thread.sleep(time);
		
		} catch (Exception e) {
		
			throw e;
		}
	
	}	
	
	/**
	 * The waitForPageToLoad method - to wait for the page to get loaded
	 * @param driver
	 * @throws Exception 
	 */
	public  void waitForPageToLoad(WebDriver driver){
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
        @Override
		public Boolean apply(WebDriver driver) {
          return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
        }
      };
      WebDriverWait wait = new WebDriverWait(driver, 30);
      try {
              wait.until(expectation);
      } catch(Throwable error) {
    	  error.getMessage();
      }
      }
	
	/**
	 * The switchTOLatestWindow method - switch to the latest window that got opened
	 * @param text
	 * @param locator
	 * @param driver
	 * @throws Exception 
	 */
	public  void switchTOLatestWindow( WebDriver driver) throws Exception  {
		try {
			
			for(String winHandle: driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			
			
		} catch (Exception e) {
			throw e;
		}
	
	}


	/**
	 * This function to select the value from the drop down
	 * @param test
	 * @param locator
	 * @param driver
	 * @throws Exception 
	 */
	public  void selectOption(String text,By locator,WebDriver driver) throws Exception {
		
		int attempts = 0;
			    while(attempts < 24 ) {
			        try {
			        		waitForElementPresent(locator, driver);
			        		Select select = new Select(driver.findElement(locator));		
			        		select.selectByVisibleText(text);
			        		break;
			            
			        } catch(StaleElementReferenceException  e) {
			        	
			        	sleepForGivenTime(5000);
					    attempts++;
			        	System.out.println("Stale element exception:" + attempts);
			        	 
			        }catch(Exception e){
			        	throw e;
			        }
			    }
	}

	/**
	 * The getTheListOfFrames method - to display the frame names and id's in console window
	 * @param driver
	 * @throws Exception 
	 */	
public  void getTheListOfFrames(WebDriver driver){
	List<WebElement> fms = driver.findElements(By.tagName("iframe"));
 	System.out.println("Total Frames: " + fms.size());
 	for(WebElement el:fms) {System.out.println("Frame Name:"+ el.getAttribute("name") + " Frame ID:" + el.getAttribute("id"));}
}


/**
 * This function is to capture screeshots 
 * @param driver
 * @param screenshotname
 * @throws Exception 
 */
public String capture(WebDriver driver,String screenShotName) throws IOException
{
	 String dest ="";
	  try {
		  
		  String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		  String wsname  = "dccmWorkspace";
		  int pos = System.getProperty("user.dir").indexOf(wsname);
		  TakesScreenshot ts = (TakesScreenshot)driver;
		  File source = ts.getScreenshotAs(OutputType.FILE);
		  dest = System.getProperty("user.dir").substring(0,pos+wsname.length()) + "\\logs\\"+screenShotName + timeStamp + ".png";
		  File destination = new File(dest);
		  FileUtils.copyFile(source, destination);      
		  
	} catch (Exception e) {
			throw e;
	}
	  return dest;
}

	
}
