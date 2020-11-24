/*package pages;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonUtil.Webdriver;
import utility.excel.CommonInterface;


public class UpdateTestCase implements Webdriver,CommonInterface{

	static boolean testCaseResult = true;


	public static void main(String[] args) throws Exception {

			objDataSheet.callGetExcelData();
			UpdateTestCase objmain = new UpdateTestCase();
			int screenFlag=1;
			int testcasecount =0;
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\10613203\\Desktop\\selne\\dccmWorkspace\\dccm\\Libs\\drivers\\chromedriver.exe");
			System.out.println("Number of Testcases to be updated: "+ objDataSheet.excelRowCount());
					
			for(int tcCounter=0; tcCounter< objDataSheet.excelRowCount(); tcCounter++){//objDataSheet.excelRowCount()
				
			  try {
				  	 testcasecount = tcCounter +1;
				     System.out.println("Execution started for Testcase no :" + testcasecount); 
				  	 o1.testcasedesc = objDataSheet.getDataValue("Test Case Name", tcCounter, screenFlag).trim();
					 o1.devid1 =  objDataSheet.getDataValue("Development Items", tcCounter, screenFlag).trim();
					 o1.reqid1 =  objDataSheet.getDataValue("Requirement Links", tcCounter, screenFlag).trim();
					 
					  
				  	if (tcCounter==0){
				  		objmain.login();
						objmain.navigatetoconstrucion();
				  	}
				  	
				  	objmain.searchandnavigatetestcase(tcCounter);
				  	objmain.updatedevitem();
				  	objmain.updatereqitem();
										
				} catch (Exception e) {

					testCaseResult = false; // TestCase Failed
					System.out.println(e);
					
				} finally {
					if (testCaseResult){
						System.out.println("Testcase no :" +  testcasecount + "Passed:" +o1.testcasedesc  );
						System.out.println("\n");
					}else{
						System.out.println("Testcase no :" + testcasecount  + "Failed:" +o1.testcasedesc  );
						System.out.println("\n");
					}
					testCaseResult = true;
					try {
						objmain.gobacktotestcase();
					} catch (Exception e) {
						
						WebElement elmtuserid = driver.findElement(By.id(o1.userid_ID));
						if(elmtuserid.isDisplayed()){
							try {
								driver.findElement(By.id(o1.userid_ID)).sendKeys(o1.userid);
								driver.findElement(By.id(o1.pwd_ID)).sendKeys(o1.pwd);
								driver.findElement(By.xpath(o1.login_xpath)).click();
							} catch (Exception e1) {
								System.out.println("Error: Unable to navigate to Construction --> Test cases");
								System.out.println(e);
								System.exit(0);
							}
						}
						System.out.println("Unable to navigate to Construction --> Test cases");
						System.out.println(e);
						System.exit(0);
					}

				}
				
			}
			

			
	}
	public void gobacktotestcase() throws Exception{
		try {
			//driver.navigate().refresh();
			sync();
		
			//to click construction menu
			WebElement constmainmenu = driver.findElement(By.id("jazz_ui_MenuPopup_8"));
			constmainmenu.click();
			//to click test cases sub menu
			driver.findElement(By.id("jazz_ui_menu_MenuItem_0_text")).click();	
		
			
			//to click construction menu
			clickElementWithJSE("id","jazz_ui_MenuPopup_8");
			//to click test cases sub menu
			clickElementWithJSE("id","jazz_ui_menu_MenuItem_0_text");
			sync();
			
			//Verify filter arrow
			WebElement elmt = driver.findElement(By.name(o1.clearfilter_name));
			if(!elmt.isDisplayed()){
				Thread.sleep(2000);
				clickElementWithJSE("xpath",o1.filterarrow_xpath);
			}
			
			driver.findElement(By.name(o1.clearfilter_name)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(o1.runbtn_xpath)).click();
			sync();
			Thread.sleep(2000);
		} catch (Exception e) {
			 throw e;
		}
	}
	public void updatedevitem() throws Exception
	{
		//Refersh the page	
			driver.navigate().refresh();
			
		//Accept if alert found for to refresh page
			if(isAlertPresent()){
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
			sync();
			
			
		//Click develeopmet items link	
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Development Items")));
			clickElementWithJSE("linktext","Development Items");
			String Parentwindow  = driver.getWindowHandle();
		
		//Wait and clik for devadd button	
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(o1.devitemaddbtn_xpath))));
			clickElementWithJSE("xpath",o1.devitemaddbtn_xpath);
			//clickElementWithJSE("xpath","//img[@class='button-img add-icon-image'][@alt='Add Development Items']");
		//Switch to adddev item frame	
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
			try {
				driver.findElement(By.xpath(o1.devworkitemtxtbox_xpath)).sendKeys(o1.devid1);
				driver.findElement(By.xpath(o1.devselectworkitem_xpath)).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(o1.devwrkitemok_xpath)));
				clickElementWithJSE("xpath",o1.devwrkitemok_xpath);
			} catch (Exception e) {
				clickElementWithJSE("xpath",o1.devwrkitemcancel_xpath);
				driver.switchTo().window(Parentwindow); 
				throw new Exception("Error: Development work item frame : ID " + o1.devid1);
				
			}
	    //swtich back to parent window					
			driver.switchTo().window(Parentwindow); 
					
			// to click the save button
			Thread.sleep(3000);
			WebElement savecancelelement = driver.findElement(By.xpath("//div[@class='actions-area-right'][@dojoattachpoint='actionsAreaRight']"));
			WebElement saveelement=savecancelelement.findElement(By.xpath("//button[@class='right-action'][@title='Save']"));
			//saveelement.click();
			//System.out.println("save btn chk " + saveelement.isEnabled());
			sync();
			//System.out.println("Done with dev");
		
		
	}
	public void updatereqitem() throws Exception
	{
		try {
			//Click the requirement link
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Requirement Links")));
			clickElementWithJSE("linktext","Requirement Links");
			String Parentwindow  = driver.getWindowHandle();
		
			//To click add button in req
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(o1.reqitemaddbtn_xpath))));
			clickElementWithJSE("xpath",o1.reqitemaddbtn_xpath);
			//clickElementWithJSE("xpath","//img[@class='button-img add-icon-image'][@alt='Add new links']");
			
			//wait for req frmame and switch to it
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
			
						
			//to select details from req frame
			try {
				driver.findElement(By.xpath(o1.reqtxtbox_xpath)).sendKeys(o1.reqid1);
				driver.findElement(By.xpath(o1.reqselectworkitem_xpath)).click();
				driver.findElement(By.xpath(o1.reqok_xpath)).click();
			} catch (Exception e) {
				clickElementWithJSE("xpath",o1.reqcancel_xpath);
				driver.switchTo().window(Parentwindow); 
				throw new Exception("Error: Requirement frame : ID " + o1.reqid1);
			}
			
			
			driver.switchTo().window(Parentwindow);
		
			// to save the data
			WebElement savecancelelement = driver.findElement(By.xpath("//div[@class='actions-area-right'][@dojoattachpoint='actionsAreaRight']"));
			WebElement saveelement=savecancelelement.findElement(By.xpath("//button[@class='right-action'][@title='Save']"));
			wait.until(ExpectedConditions.elementToBeClickable(saveelement));
			Thread.sleep(500);
			//saveelement.click();
			Thread.sleep(3500);
			//System.out.println("save btn chk in reqlink" + saveelement.isEnabled());
		} catch (Exception e) {
			 throw e;
		}
		
	}
	public void searchandnavigatetestcase(int count) throws Exception{

		try {
			
			if(count==0){ 
				//click filter arrrow for first time
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(o1.filterarrow_xpath))));
				driver.findElement(By.xpath(o1.filterarrow_xpath)).click();
			}
			
			if ((o1.devid1.equals("")) || (o1.reqid1.equals(""))){
				throw new Exception("Error no data: Development work item=" + o1.devid1 + " Requirement frame =" + o1.reqid1);
			}
			
				driver.findElement(By.xpath(o1.testcasedesc_xpath)).sendKeys(o1.testcasedesc);
				Thread.sleep(2000);
				driver.findElement(By.xpath(o1.runbtn_xpath)).click();
				
				//Click the test case description link
				String regularexp ="\"";
			    String value =o1.testcasedesc;
	            String tagvalue = "//div[contains(text(),";
	            String path1 = tagvalue + regularexp + value + regularexp + ")]";
                WebElement testcaseelm =driver.findElement(By.xpath(path1));
	            wait.until(ExpectedConditions.elementToBeClickable(testcaseelm));
	            Thread.sleep(2000);
                testcaseelm.click();
                sync();
               
               //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(o1.clicktestcase_xpath))));
               //driver.findElement(By.xpath(o1.clicktestcase_xpath)).click();
			
		} catch (Exception e) {
			  throw e;
		}
		
	}
	public void navigatetoconstrucion() throws Exception{
			try {
				//click on home button
				driver.findElement(By.xpath(o1.home_xpath)).click();
				sync();
				//System.out.println("0");
				//wait.until(ExpectedConditions.elementToBeClickable(By.linkText("POC (QM)")));
				//System.out.println("1");
				//driver.findElement(By.linkText("POC (QM)")).click(); //click link with text POC (QM)
				
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Transfer Agency System (QM)")));
				driver.findElement(By.linkText("Transfer Agency System (QM)")).click();
				sync();	
				
				//Navigate to construction -> test cases
				WebElement  element = driver.findElement(By.xpath(o1.construction_xpath)); 
				Thread.sleep(10000);
				waitforelement(element);			
				element.click();
			
				wait.until(ExpectedConditions.elementToBeClickable(By.id("jazz_ui_menu_MenuItem_0_text")));
				driver.findElement(By.id("jazz_ui_menu_MenuItem_0_text")).click();	
				Thread.sleep(2000);
				sync();
				
			} catch (Exception e) {
				throw e;
			}	
	}
	public  void login() throws Exception{	//open URL and login
		try {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\10613203\\Desktop\\selne\\dccmWorkspace\\dccm\\Libs\\drivers\\chromedriver.exe");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(o1.baseUrl);
			driver.manage().window().maximize();
			driver.findElement(By.id(o1.userid_ID)).sendKeys(o1.userid);
			driver.findElement(By.id(o1.pwd_ID)).sendKeys(o1.pwd);
			driver.findElement(By.xpath(o1.login_xpath)).click();
			sync();	
			//wait until home button exist
			WebElement hmebtnexist  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(o1.home_xpath)));
			
		} catch (Exception e) {
			throw e;
		}
}
	//Method to click using DOM with JSE
	public void clickElementWithJSE(String elementType,String elementValue)
	{
		try {
			WebElement  element = null;

			if(elementType.equalsIgnoreCase("id")){
				  element= driver.findElement(By.id(elementValue));
			}
			else if(elementType.equalsIgnoreCase("xpath")){	
				  element= driver.findElement(By.xpath(elementValue));
			}
			else if(elementType.equalsIgnoreCase("css")){	
				  element= driver.findElement(By.cssSelector(elementValue));
			}
			else if(elementType.equalsIgnoreCase("linktext")){	
				  element= driver.findElement(By.linkText(elementValue));
			}
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			throw e;
		}
			}
	//Method to wait until page gets loaded
	public void sync() throws Exception {
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 try {
			while (true) {
			        Thread.sleep(1000);
			        if(js.executeScript("return document.readyState").toString().equals("complete")){
			    	   Thread.sleep(2000);
			    	   break; 
			       }
			}
		} catch (Exception e) {
			throw e;
		}
       
	}
	

	//Method to wait for an element to be clickable
	public void waitforelement(WebElement elmnt){
		try {
			WebDriverWait wait1 = new WebDriverWait(driver, 120);
			wait1.until(ExpectedConditions.elementToBeClickable(elmnt));
		} catch (Exception e) {
			throw e;
		}
	}
	public boolean isAlertPresent(){
	try{
		driver.switchTo().alert();
		return true;
	}catch(NoAlertPresentException ex){
		return false;
	}
	}
	
}




















WebElement constmenu = driver.findElement(By.xpath(o1.construction_xpath));
WebElement constsubmenu = driver.findElement(By.xpath(o1.Testcases_xpath));
Actions action = new Actions(driver);
action.moveToElement(constmenu).click().moveToElement(constsubmenu).click().build().perform();

//----------------------------old--------------------------------------------------------
		UpdateTestCase objmain = new UpdateTestCase();
		objmain.login();
		objmain.navigatetoconstrucion();
		objmain.searchandnavigatetestcase();
		objmain.updatedevitem();
		//objmain.updatereqitem();		
	//------------------------------------------------------------------------------------
	*/