package pages;


import com.aventstack.extentreports.Status;

import commonUtil.Constants;
import pageObjects.CommonObjects.CommonPageObjects;
import utility.excel.CommonInterface;
import utility.excel.GetDataSheet;
import utility.excel.MasterScript;

public class Login implements CommonInterface{

	static boolean testCaseResult = true;
	public static int screenFlag=1;
	public static int testcasecount =0;
	
	private void sysout() {

	}
	public static void main(String[] args) throws Exception {

		objDataSheet.callGetExcelData();
		MasterScript.test = MasterScript.extent.createTest("Login", "Login in to the application ");
		MasterScript.test.log(Status.INFO, "Number of Testcases to be executed: "+ objDataSheet.excelRowCount());
	    
		for( GetDataSheet.testCaseRow=0; GetDataSheet.testCaseRow< objDataSheet.excelRowCount(); GetDataSheet.testCaseRow++){
			
		  try {
			  	login();
			    verifyLogin();
			    
		    } catch (Exception e) {

				testCaseResult = false; 
				System.out.println(e);
				
			} finally {
				
				if (testCaseResult){
					MasterScript.test.log(Status.PASS, "Test case passed");
					MasterScript.test.log(Status.PASS, "Snapshot:Test case passed" +  MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "TestcasePassed")));
			   }else{
				    MasterScript.test.log(Status.FAIL, "Test case Failed");
				    
				}
				
				MasterScript.extent.flush();
		}
		
	}
}

	public static void login() throws Exception{	//open URL and login
		try {
		    
			 String testCaseDesc  = objDataSheet.getDataValue("TestCaseDescription").trim();
		  	 String url  = objDataSheet.getDataValue("URL").trim();
		  	 String userName  = objDataSheet.getDataValue("UserID").trim();
		  	 String password =  objDataSheet.getDataValue("Password").trim();
		 	 testcasecount = GetDataSheet.testCaseRow +1;
		  	 MasterScript.test.log(Status.INFO, testcasecount + ":"+ testCaseDesc);
		  	 driver.get(url);
		     objaction.waitForPageToLoad(driver);
		     driver.manage().window().maximize();
		     //Enter user name,pwd and click login
		     objaction.enterValue(userName, CommonPageObjects.LOGIN_USERNAME.byLocator(), driver);
		     objaction.enterValue(password, CommonPageObjects.LOGIN_PASSWORD.byLocator(), driver);
		     MasterScript.test.log(Status.PASS, "Entered username and password");
		     MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "Login"));
		     objaction.clickElement(CommonPageObjects.LOGIN_BUTTON.byLocator(), driver);
	  		 MasterScript.test.log(Status.PASS, "Login button clicked");
		
		} catch (Exception e) {
			 MasterScript.test.log(Status.FAIL, "Snapshot below :Login failed");
			 MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "Login_Fail"));
			 throw e;
		}
		
	}
	
		public static void verifyLogin() throws Exception{
			
			 try {
				 	objaction.waitForPageToLoad(driver);
				 	objaction.waitForElementVisible(CommonPageObjects.HOME_DCCMIMG.byLocator(), driver);
				 	objaction.sleepForGivenTime(5000);
				 	driver.switchTo().frame(Constants.USERREPORTVIEW);
				 	objaction.waitForElementVisible(CommonPageObjects.HOME_USERREPORTVIEW_GENREP.byLocator(), driver);
				 	driver.switchTo().defaultContent();
				 	MasterScript.test.log(Status.PASS, "Logged in success.Navigated to home page");
				 	MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "Logged in"));
				 	
			} catch (Exception e) {
				 MasterScript.test.log(Status.FAIL, "Snapshot below :Login failed");
				 MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "Navigationtohomepage_Failed"));
				throw e;
				
				
			}	
		}

	

	
}
