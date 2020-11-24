package pages;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import commonUtil.Constants;
import pageObjects.CommonObjects.CommonPageObjects;
import utility.excel.CommonInterface;
import utility.excel.GetDataSheet;
import utility.excel.MasterScript;

public class UserManagement  implements CommonInterface{

	static boolean testCaseResult = true;
	public static int screenFlag=1;
	public static int testcasecount =0;
	
	
	public static void main(String[] args) throws Exception {

		objDataSheet.callGetExcelData();
		MasterScript.test = MasterScript.extent.createTest("User Management", "To perform add,modify and delete operation in user management");
		MasterScript.test.log(Status.INFO, "Number of Testcases to be executed: "+ objDataSheet.excelRowCount());
	    
		
		for( GetDataSheet.testCaseRow=0; GetDataSheet.testCaseRow< objDataSheet.excelRowCount(); GetDataSheet.testCaseRow++){
			
		  try {
			  navigateToUserManagement();
			  addToQueue();
			  setDiversions();
			  setWorkAudit();
			  workAuditDetails();
			  
			   
		  } catch (Exception e) {

				testCaseResult = false; 
				System.out.println(e);
				
			} finally {
				
				if (testCaseResult){
					MasterScript.test.log(Status.PASS, "Test case passed");
					MasterScript.test.log(Status.PASS, "Snapshot:Test case passed" +  MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "UserManagement_TestcasePassed")));
			   }else{
				    MasterScript.test.log(Status.FAIL, "Test case Failed");
				}
				System.out.println("Finally");
				MasterScript.extent.flush();
		}
		
		}
	}
	public static void addToQueue() throws Exception{
		try {
			MasterScript.test.log(Status.INFO, "Handle controls in Add to Queue window");
			String queueName = objDataSheet.getDataValue("searchQueue").trim();
			String day = objDataSheet.getDataValue("Day").trim();
			String month = objDataSheet.getDataValue("month").trim();
			String year = objDataSheet.getDataValue("year").trim();
			
			driver.switchTo().frame(Constants.BA_USERMGMTFRAME);
			objaction.clickElement(CommonPageObjects.UM_SELECTAUTOMATIONTWO.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.UM_ADDTOQUEUEBTN.byLocator(), driver);
			
//		if (objaction.waitForElementPresent(CommonPageObjects.UM_ERRORPOPUP1.byLocator(), driver)){
//			String errorMsg = driver.findElement(CommonPageObjects.UM_ERRORPOPUP1.byLocator()).getText();
//			throw new Exception ("Error message:"+errorMsg);
//		}
				String winHandleBefore = driver.getWindowHandle();
				objaction.switchTOLatestWindow(driver);
				objaction.clickElement(CommonPageObjects.UM_ADD_SEARCHPOPUP.byLocator(), driver);
				driver.switchTo().frame(Constants.UM_POPUPFRAME);
				objaction.clickElement(CommonPageObjects.UM_ADD_SEARCHPROCESS.byLocator(), driver);
				objaction.enterValue(queueName, CommonPageObjects.UM_ADD_SEARCHPROCESS.byLocator(), driver);
				objaction.clickElement(CommonPageObjects.UM_ADD_SEARCHBTN.byLocator(), driver);
				objaction.clickElement(CommonPageObjects.UM_ADD_SELECTPROCESS.byLocator(), driver);
				objaction.enterValue("Test data for filter text box", CommonPageObjects.UM_ADD_FILTERYTXT.byLocator(), driver);
				objaction.clickElement(CommonPageObjects.UM_ADD_TEMPASSIGNMTRADIO.byLocator(), driver);
				objaction.selectOption(day, CommonPageObjects.UM_ADD_DAY.byLocator(), driver);
				objaction.selectOption(month, CommonPageObjects.UM_ADD_MONTH.byLocator(), driver);
				objaction.selectOption(year, CommonPageObjects.UM_ADD_YEAR.byLocator(), driver);
				objaction.clickElement(CommonPageObjects.UM_ADD_ADDBTN.byLocator(), driver);
				objaction.clickElement(CommonPageObjects.UM_ADD_CLOSEBTN.byLocator(), driver);
			/*	if (objaction.waitForElementPresent(CommonPageObjects.UM_ADD_ERRORMSG.byLocator(), driver)){
						String errorMsg = driver.findElement(CommonPageObjects.UM_ADD_ERRORMSG.byLocator()).getText();
						throw new Exception ("Error message:"+errorMsg);
				}*/
				driver.switchTo().window(winHandleBefore);
				MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "UserManagement_AddToQueuePassed"));
		} catch (Exception e) {
			  MasterScript.test.log(Status.FAIL, "Snapshot below :Failed to Add Queue");
			  MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "UserManagement_AddQueueFailed"));
			
			throw e;
		}
	}
	
	public static void setDiversions() throws Exception{
		
		 try {
			 MasterScript.test.log(Status.INFO, "Navigation to  set Diversions ");
			 String username = objDataSheet.getDataValue("SelectUser").trim();
			 driver.switchTo().frame(Constants.BA_USERMGMTFRAME);
			 objaction.clickElement(CommonPageObjects.UM_SETDIVERSIONBTN.byLocator(), driver);
			 String winHandleBefore = driver.getWindowHandle();
			 objaction.switchTOLatestWindow(driver);
			 objaction.clickElement(CommonPageObjects.UM_SETDIV_SEARCHPOPUP.byLocator(), driver);
			 driver.switchTo().frame(Constants.QM_UM_USER);
			 objaction.clickElement(CommonPageObjects.UM_SETDIV_FILTERONNAME.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.UM_SETDIV_FILTERONNAMEUSERID.byLocator(), driver);
			 objaction.enterValue(username, CommonPageObjects.UM_SETDIV_FILTERONNAMEUSERID.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.UM_SETDIV_FILTERONNAMESEARBTN.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.UM_SETDIV_FILTERONNAMESELECT.byLocator(), driver);
			 objaction.selectOption("1", CommonPageObjects.UM_SETDIV_FROMDAY.byLocator(), driver);
			 objaction.selectOption("Jan", CommonPageObjects.UM_SETDIV_FROMMONTH.byLocator(), driver);
			 objaction.selectOption("2021", CommonPageObjects.UM_SETDIV_FROMYEAR.byLocator(), driver);
			 objaction.selectOption("1", CommonPageObjects.UM_SETDIV_TODAY.byLocator(), driver);
			 objaction.selectOption("Jan", CommonPageObjects.UM_SETDIV_TOMONTH.byLocator(), driver);
			 objaction.selectOption("2024", CommonPageObjects.UM_SETDIV_TOYEAR.byLocator(), driver);
			 objaction.selectOption("2024", CommonPageObjects.UM_SETDIV_TOYEAR.byLocator(), driver);
			 objaction.selectOption("10", CommonPageObjects.UM_SETDIV_FROMHOURS.byLocator(), driver);
			 objaction.selectOption("10", CommonPageObjects.UM_SETDIV_FROMMINS.byLocator(), driver);
			 objaction.selectOption("12", CommonPageObjects.UM_SETDIV_TOHOURS.byLocator(), driver);
			 objaction.selectOption("10", CommonPageObjects.UM_SETDIV_TOMINS.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.UM_SETDIV_WORKITEMRADIO.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.UM_SETDIV_CLOSEBTN.byLocator(), driver);
			 driver.switchTo().window(winHandleBefore);
			 MasterScript.test.log(Status.PASS, "Navigation to set Diversions ");
			 
		} catch (Exception e) {
			  MasterScript.test.log(Status.FAIL, "Snapshot below :navigate To UserManagement");
			  MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "UserManagem"));
			throw e;
		}
		 
		 
	}
	public static void setWorkAudit() throws Exception{
		
		 try {
			
			 MasterScript.test.log(Status.INFO, "Navigation to  set work audit ");
			 driver.switchTo().frame(Constants.BA_USERMGMTFRAME);
			 objaction.clickElement(CommonPageObjects.UM_SETWORKAUDITBTN.byLocator(), driver);
			 String winHandleBefore = driver.getWindowHandle();
			 objaction.switchTOLatestWindow(driver);
			 objaction.clickElement(CommonPageObjects.UM_SETWA_ADDBTN.byLocator(), driver);
			 String subwinHandleBefore = driver.getWindowHandle();
			 objaction.switchTOLatestWindow(driver);
			 objaction.clickElement(CommonPageObjects.UM_SETWA_SEARCHPOPUPBTB.byLocator(), driver);
			 driver.switchTo().frame(Constants.BA_POPUPFRAME);	 
			 objaction.clickElement(CommonPageObjects.UM_SETWA_SEARCHPROCESS.byLocator(), driver);
			 //objaction.enterValue("CIBCMellon_TA_V1", CommonPageObjects.UM_SETWA_SEARCHPROCESS.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.UM_SETWA_SEARCHPROCESSBTN.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.UM_SETWA_SELECTPROCESS.byLocator(), driver);
			 driver.switchTo().defaultContent();
			 objaction.clickElement(CommonPageObjects.UM_SETWA_ANPOPUPBTB.byLocator(), driver);
			 driver.switchTo().frame(Constants.QM_UM_USER);	
			 objaction.clickElement(CommonPageObjects.UM_SETWA_ANFLTONNAME.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.UM_SETWA_ANFLTONNAMEUSERID.byLocator(), driver);
			 objaction.enterValue("Automationone", CommonPageObjects.UM_SETWA_ANFLTONNAMEUSERID.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.UM_SETWA_ANFLTONNAMESEARBTN.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.UM_SETWA_ANFLTONNAMESELECTVALUE.byLocator(), driver);
			 driver.switchTo().defaultContent();
			 objaction.selectOption("30%", CommonPageObjects.UM_SETWA_PERCENTAGEAUDIT.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.UM_SETWA_SETAUDIT_CLOSEBTN.byLocator(), driver);
			 driver.switchTo().window(subwinHandleBefore);
			 objaction.clickElement(CommonPageObjects.UM_SETWA_CLOSEBTN.byLocator(), driver);
			 driver.switchTo().window(winHandleBefore);
			 MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "UserManagement_setWorkAuditPassed"));
			 
		} catch (Exception e) {
			
		 	MasterScript.test.log(Status.FAIL, "Snapshot below :UserManagement_setWorkAudit Failed");
			MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "UserManagement_setWorkAuditFailed"));
			throw e;
		}
	}
	public static void workAuditDetails() throws Exception{
		
		 try {
			MasterScript.test.log(Status.INFO, "Navigation to  work audit details ");
			 driver.switchTo().frame(Constants.BA_USERMGMTFRAME);
			 objaction.clickElement(CommonPageObjects.UM_WORKAUDITBTN.byLocator(), driver);
			 String winHandleBefore = driver.getWindowHandle();
			 objaction.switchTOLatestWindow(driver);
			 objaction.clickElement(CommonPageObjects.UM_WADETAILS_CLOSEBTN.byLocator(), driver);
			 MasterScript.test.log(Status.INFO, "Navigation to  work audit details ");
			 MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "UserManagement_workAuditDetails"));
		
		 } catch (Exception e) {
				
			 	MasterScript.test.log(Status.FAIL, "Snapshot below :UserManagement_workAuditDetails");
				MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "UserManagement_workAuditDetailsFailed"));
				throw e;
		}
		 
	}
	public static void navigateToUserManagement() throws Exception{
		
		 try {
			 
			 MasterScript.test.log(Status.INFO, "Navigation to user management ");
			 objaction.clickElement(CommonPageObjects.HOME_MENU.byLocator(), driver);
			 objaction.waitForElementVisible(CommonPageObjects.HOME_MENUBA.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.HOME_MENUBA.byLocator(), driver);
			 objaction.waitForPageToLoad(driver);
			 objaction.waitForElementVisible(CommonPageObjects.HOME_DCCMIMG.byLocator(), driver);
			 objaction.sleepForGivenTime(5000);
			 driver.switchTo().frame(Constants.BA_USERMGMTFRAME);
			 objaction.waitForElementVisible(CommonPageObjects.UM_ADDTOQUEUEBTN.byLocator(), driver);
			 driver.switchTo().defaultContent();
			 objaction.clickElement(CommonPageObjects.UM_POPOUTBTN.byLocator(), driver);
			 MasterScript.test.log(Status.PASS, "Navigation to user management ");
			 MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "UserManagement_NavigationPASSED"));
			 
		} catch (Exception e) {
			  MasterScript.test.log(Status.FAIL, "Snapshot below :navigate To UserManagement");
			  MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "UserManagement_NavigationFailed"));
			  throw e;
		}	
	}
}


