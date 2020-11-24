package pages;


import com.aventstack.extentreports.Status;

import commonUtil.Constants;
import pageObjects.CommonObjects.CommonPageObjects;
import utility.excel.CommonInterface;
import utility.excel.GetDataSheet;
import utility.excel.MasterScript;

public class QueueManagement implements CommonInterface{

	
	static boolean testCaseResult = true;
	public static int screenFlag=1;
	public static int testcasecount =0;
	
	
	public static void main(String[] args) throws Exception {

		objDataSheet.callGetExcelData();
		MasterScript.test = MasterScript.extent.createTest("Queue Management", "To perform add,modify and delete operation in queue management");
		MasterScript.test.log(Status.INFO, "Number of Testcases to be executed: "+ objDataSheet.excelRowCount());
	    
		
		for( GetDataSheet.testCaseRow=0; GetDataSheet.testCaseRow< objDataSheet.excelRowCount(); GetDataSheet.testCaseRow++){
			
		  try {
				  
			   navigateToQueueManagement();
			   performActionOnDifferentTabs();
			   performSearchOperation();
			   performDeleteOperation();
			  
			   
		  } catch (Exception e) {

				testCaseResult = false; 
				System.out.println(e);
				
			} finally {
				
				if (testCaseResult){
					MasterScript.test.log(Status.PASS, "Test case passed");
					MasterScript.test.log(Status.PASS, "Snapshot:Test case passed" +  MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "QueueManagement_TestcasePassed")));
			   }else{
				    MasterScript.test.log(Status.FAIL, "Test case Failed");
		        }
				

				MasterScript.extent.flush();
		}
		
	}
}
	
	public static void performDeleteOperation() throws Exception{
		
		 try {
			 
			String queueName = objDataSheet.getDataValue("QueueName").trim();
			MasterScript.test.log(Status.INFO, "Delete option started");
			driver.switchTo().frame(Constants.BA_QUEMGMTFRAME);
			objaction.clickElement(CommonPageObjects.QM_SEARCHQUEUETXT.byLocator(), driver);
			objaction.enterValue(queueName, CommonPageObjects.QM_SEARCHQUEUETXT.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.QM_SEARCHQUEUEBTN.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.QM_SELECTAUTOMATIONQUEUE.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.QM_DELETEBTN.byLocator(), driver);
			driver.switchTo().defaultContent();
			driver.switchTo().frame(Constants.QM_POPUPCOMMENT);
			objaction.enterValue("Delete automation data queue", CommonPageObjects.QM_DELETECMMNTBOX.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.QM_DELETECMMNTOK.byLocator(), driver);
			driver.switchTo().defaultContent();
			MasterScript.test.log(Status.PASS, "To delete a valid data");
			MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "QueueManagement_DeletePassed"));
	
		} catch (Exception e) {
				  MasterScript.test.log(Status.FAIL, "Snapshot below :Failed to delete data");
				  MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "QueueManagement_DeleteFailed"));
				  
			throw e;
		}
	}
	public static void performSearchOperation() throws Exception{
		
		 try {
			MasterScript.test.log(Status.INFO, "Search option started");
			driver.switchTo().frame(Constants.BA_QUEMGMTFRAME);
			objaction.clickElement(CommonPageObjects.QM_SEARCHPOPUPBTN.byLocator(), driver);
			driver.switchTo().defaultContent();
			driver.switchTo().frame(Constants.BA_POPUPFRAME);
			objaction.clickElement(CommonPageObjects.QM_SEARCHPROCESS.byLocator(), driver);
			//driver.findElement(CommonPageObjects.QM_SEARCHPROCESS.byLocator()).sendKeys("");
			//objaction.enterValue(searchQueue, CommonPageObjects.QM_SEARCHPROCESS.byLocator(), driver);
			//objaction.clickElement(CommonPageObjects.QM_SERCHBTN.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.QM_SELECTFRMLIST.byLocator(), driver);
			driver.switchTo().defaultContent();
			MasterScript.test.log(Status.PASS, "Enter text in search box and click search button");
			MasterScript.test.log(Status.PASS, "click the required result");
			MasterScript.test.log(Status.PASS, "Search window handled");
			MasterScript.test.log(Status.PASS, "To search a valid data");
			MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "QueueManagement_Search"));
			
		} catch (Exception e) {
			MasterScript.test.log(Status.FAIL, "Snapshot below :Failed to search data");
			MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "QueueManagement_SearchFailed"));
			throw e;
		}
	}
	
	public static void performActionOnDifferentTabs() throws Exception{
		
		 try {
			 MasterScript.test.log(Status.INFO, "Perform action on different tabs");
			 String searchQueue = objDataSheet.getDataValue("searchQueue").trim();
			 String queueName = objDataSheet.getDataValue("QueueName").trim();
			 String queueDesc = objDataSheet.getDataValue("QueueDesc").trim();
			 String workItemValue = objDataSheet.getDataValue("workItem").trim();
			 String addUser = objDataSheet.getDataValue("addUser").trim();
			 
			 MasterScript.test.log(Status.INFO, "To add data in Queue Management");
			 driver.switchTo().frame(Constants.BA_QUEMGMTFRAME);
			 
			 // to handle stale element exception for add buttton
			    boolean result = false;
			    int attempts = 0;
			    while(attempts < 24 ) {
			        try {
			        	objaction.clickElement(CommonPageObjects.QM_ADDBTN.byLocator(), driver);
			            result = true;
			            break;
			        } catch(Exception e) {
			        }
			        objaction.sleepForGivenTime(5000);
			        attempts++;
			    }
			    

			 if(!result) {
				 throw new Exception("Unable to click add button");
			 }
			 

			 objaction.waitForPageToLoad(driver);
			 String winHandleBefore = driver.getWindowHandle();
			 //Switch to add window --  General tab 
			 objaction.switchTOLatestWindow(driver);
			 MasterScript.test.log(Status.PASS, "Switch to add window");
			 objaction.enterValue(queueName, CommonPageObjects.QM_QUEUENAME.byLocator(), driver);
			 objaction.enterValue(queueDesc, CommonPageObjects.QM_QUEUEDESC.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.QM_PROCESSQUEUECHK.byLocator(), driver);
			//objaction.enterValue("Sample data", CommonPageObjects.QM_PROCESSQUEUE_ENTERPROCESSNAME.byLocator(), driver);
			 
			 objaction.clickElement(CommonPageObjects.QM_PROCESSQUEUESEARCHPOPUP.byLocator(), driver); 
			 driver.switchTo().frame(Constants.BA_POPUPFRAME);
			 objaction.clickElement(CommonPageObjects.QM_PROCESSQUEUE_PROCESSNAME.byLocator(), driver);
			 objaction.enterValue(searchQueue, CommonPageObjects.QM_PROCESSQUEUE_PROCESSNAME.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.QM_PROCESSQUEUE_SEARCHROCESSBTN.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.QM_PROCESSQUEUE_SELECTPROCESS.byLocator(), driver);
		 	 driver.switchTo().defaultContent();	
			 
			 objaction.clickElement(CommonPageObjects.QM_WIPCHK.byLocator(), driver);
			 objaction.enterValue("Test data for filter1 text box", CommonPageObjects.QM_FILTER1.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.QM_FILTER2SEARCHRADIOBTN.byLocator(), driver);
			 objaction.enterValue("Test data for filter2 text box", CommonPageObjects.QM_FILTER2.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.QM_WORKITEMRADIOBTN.byLocator(), driver);
			 objaction.selectOption(workItemValue, CommonPageObjects.QM_ADDDRPDWN_WRKITM.byLocator(), driver);
			 MasterScript.test.log(Status.PASS, "Add tab - Able to perform action in all the controls");
			 MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "QueueMgmt_addTab"));
			 //----------------------------------------- User tab-----------------------------------------------------------------------------------------
			 objaction.clickElement(CommonPageObjects.QM_USERTAB.byLocator(), driver);
			 MasterScript.test.log(Status.PASS, "Navigation to user tab");
			 objaction.clickElement(CommonPageObjects.QM_USER_USERRADIO.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.QM_USER_SEARCHPOPUP.byLocator(), driver);
			 driver.switchTo().frame(Constants.QM_UM_USER);
			 objaction.clickElement(CommonPageObjects.QM_USER_FILTERONNAME.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.QM_USER_FILTERONNAMESEARCH.byLocator(), driver);
			 objaction.enterValue(addUser, CommonPageObjects.QM_USER_FILTERONNAMESEARCH.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.QM_USER_FILTERONNAMESEARCHbtn.byLocator(), driver);
			 objaction.sleepForGivenTime(3000);
			 objaction.clickElement(CommonPageObjects.QM_USER_FILTERONNAME_SELECTVALUE.byLocator(), driver);
			 objaction.sleepForGivenTime(3000);
			 objaction.clickElement(CommonPageObjects.QM_USER_FILTERONNAME_SELECTOK.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.QM_USER_ADDBTN.byLocator(), driver);
			 objaction.enterValue(addUser, CommonPageObjects.QM_USER_SEARCHBOX.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.QM_USER_SEARCHBTN.byLocator(), driver);
             MasterScript.test.log(Status.PASS, "User tab - Able to perform action in all the controls");
             MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "QueueMgmt_UserTab"));
             //----------------------------------------- Acitivity  tab-----------------------------------------------------------------------------------------
             objaction.clickElement(CommonPageObjects.QM_ACTIVITYTAB.byLocator(), driver);
			 MasterScript.test.log(Status.PASS, "Navigation to Activity tab");
			 objaction.clickElement(CommonPageObjects.QM_ACTIVITY_SEARCHPOPUP.byLocator(), driver);
			 driver.switchTo().frame(Constants.BA_POPUPFRAME);
			 objaction.enterValue(searchQueue, CommonPageObjects.QM_ACTIVITY_SEARCHBOX.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.QM_ACTIVITY_SELECTVALUE.byLocator(), driver);
			 driver.switchTo().defaultContent();
			 MasterScript.test.log(Status.PASS, "Activity tab - Able to perform action in all the controls");
			 MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "QueueMgmt_ActivityTab"));
			 //----------------------------------------- workconfig  tab-----------------------------------------------------------------------------------------
			 objaction.clickElement(CommonPageObjects.QM_WRKLSTCONFIGTAB.byLocator(), driver);
			 MasterScript.test.log(Status.PASS, "Navigation to worklist configuration tab");
			 objaction.clickElement(CommonPageObjects.QM_WRKLSTCONFIG_ACTNAMERADIO.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.QM_WRKLSTCONFIG_ACTNAMERADIO.byLocator(), driver);
			 objaction.enterValue("Activity name", CommonPageObjects.QM_WRKLSTCONFIG_ACTNAMETXT.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.QM_WRKLSTCONFIG_FINALOKBTN.byLocator(), driver);
			 MasterScript.test.log(Status.PASS, "worklist tab - Able to perform action in all the controls");
			 driver.switchTo().frame(Constants.QM_POPUPCOMMENT);
			 objaction.enterValue("sample data", CommonPageObjects.QM_ADD_COMMENT.byLocator(), driver);	
			 objaction.clickElement(CommonPageObjects.QM_COMMENTOKBTN.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.QM_ADDEDSUCESS_OKBTN.byLocator(), driver);
			 MasterScript.test.log(Status.PASS, "To add queue with valid data");
		     MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "QueueMgmt_Add queue"));
			 //driver.switchTo().defaultContent();
			 // driver.close();
			 driver.switchTo().window(winHandleBefore);
		} catch (Exception e) {
			MasterScript.test.log(Status.FAIL, "Snapshot below :Failed to perform action on all the tabs");
			MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "QueueManagement_TabsFailed"));
			throw e;
		}
	}


	
	public static void navigateToQueueManagement() throws Exception{
		
		 try {
			 MasterScript.test.log(Status.INFO, "Navigation to Queue management ");
			 objaction.clickElement(CommonPageObjects.HOME_MENU.byLocator(), driver);
			 objaction.waitForElementVisible(CommonPageObjects.HOME_MENUBA.byLocator(), driver);
			 objaction.clickElement(CommonPageObjects.HOME_MENUBA.byLocator(), driver);
			 objaction.waitForPageToLoad(driver);
			 objaction.waitForElementVisible(CommonPageObjects.HOME_DCCMIMG.byLocator(), driver);
			 objaction.sleepForGivenTime(5000);
			 
			 driver.switchTo().frame(Constants.BA_USERMGMTFRAME);
			 objaction.waitForElementVisible(CommonPageObjects.QM_ADDBTN.byLocator(), driver);
			 driver.switchTo().defaultContent();
			 objaction.clickElement(CommonPageObjects.QM_POPOUTBTN.byLocator(), driver);
			 MasterScript.test.log(Status.PASS, "Navigation to Queue management ");
			 MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "Navigate_QueueMgmt"));
			 
		} catch (Exception e) {
			MasterScript.test.log(Status.FAIL, "Snapshot below :Navigation to Queue management");
			MasterScript.test.addScreenCaptureFromPath(objaction.capture(driver, "Navigate_QueueMgmtFailed"));
			throw e;
		}	
	}

}


