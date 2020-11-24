package pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import commonUtil.Constants;
import pageObjects.CommonObjects.CommonPageObjects;
import utility.excel.CommonInterface;
import utility.excel.GetDataSheet;
import utility.excel.MasterScript;

public class RightsManagement  implements CommonInterface{

	static boolean testCaseResult = true;
	public static int screenFlag=1;
	public static int testcasecount =0;
	
	
	public static void main(String[] args) throws Exception {

		objDataSheet.callGetExcelData();
		MasterScript.test = MasterScript.extent.createTest("Rights Management", "To perform action on all the controls in Rights management");
		MasterScript.test.log(Status.INFO, "Number of Testcases to be executed: "+ objDataSheet.excelRowCount());
	    
		
		for( GetDataSheet.testCaseRow=0; GetDataSheet.testCaseRow< objDataSheet.excelRowCount(); GetDataSheet.testCaseRow++){
			
		  try {
			  
			  navigateToRightsManagement();
			  addProfile();
			  /*searchAndDeleteProfile();
			  addUser();
			  searchAndDeleteUser();*/
						   
		  } catch (Exception e) {

				testCaseResult = false; 
				System.out.println(e);
				
			} finally {
				
				if (testCaseResult){
					MasterScript.test.log(Status.PASS, "Test case passed");
			   }else{
				    MasterScript.test.log(Status.FAIL, "Test case Failed");
				}
				System.out.println("Finally");
				MasterScript.extent.flush();
		}
		
		}
	}
	
	public static void searchAndDeleteUser() throws Exception {
		try {
			driver.switchTo().frame(Constants.BA_RIGHTSMGMTFRAME);
			//objaction.clickElement(CommonPageObjects.RM_USERTAB.byLocator(), driver);
			objaction.waitForElementVisible(CommonPageObjects.RM_USER_SEARCHUSERTXT.byLocator(), driver);
			objaction.sleepForGivenTime(2000);
			objaction.clickElement(CommonPageObjects.RM_USER_SEARCHUSERTXT.byLocator(), driver);
			objaction.sleepForGivenTime(2000);
			objaction.enterValue("Automationone", CommonPageObjects.RM_USER_SEARCHUSERTXT.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.RM_USER_SEARCHUSERBTN.byLocator(), driver);
			objaction.waitForElementVisible(CommonPageObjects.RM_USER_SELECTUSER.byLocator(), driver);
			objaction.sleepForGivenTime(2000);
			objaction.clickElement(CommonPageObjects.RM_USER_SELECTUSER.byLocator(), driver);
			objaction.waitForElementVisible(CommonPageObjects.RM_USER_SELECTUSER.byLocator(), driver);
			objaction.sleepForGivenTime(2000);
			objaction.clickElement(CommonPageObjects.RM_USER_DELETEUSER.byLocator(), driver);
			objaction.waitForElementVisible(CommonPageObjects.RM_USER_DELETEPOPUPNO.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.RM_USER_DELETEPOPUPNO.byLocator(), driver);
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			throw e;
		}

	}
	
	public static void addUser() throws Exception {
		try {

			//Usertab
			String userName = objDataSheet.getDataValue("userName").trim();
			MasterScript.test.log(Status.INFO, "User tab - Add a User ");
			
			String screenShotPath = objaction.capture(driver, "screenShotName");
//			MasterScript.test.log(Status.PASS, "Snapshot below: " + MasterScript.test.CA\("C:\\Users\\10613203\\Desktop\\SCREEN1"));
			driver.switchTo().frame(Constants.BA_RIGHTSMGMTFRAME);
			objaction.clickElement(CommonPageObjects.RM_USERTAB.byLocator(), driver);
			objaction.waitForElementVisible(CommonPageObjects.RM_USER_SEARCHUSERTXT.byLocator(), driver);
			objaction.sleepForGivenTime(5000);
			objaction.clickElement(CommonPageObjects.RM_USER_ADD.byLocator(), driver);
			String winHandleBefore = driver.getWindowHandle();
			objaction.switchTOLatestWindow(driver);
			objaction.enterValue(userName, CommonPageObjects.RM_USER_USRNAME.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.RM_USER_DOMAINUSERCHKBOX.byLocator(), driver);
			objaction.enterValue("Sample data", CommonPageObjects.RM_USER_COMMENTS.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.RM_USER_DOMAINUSERCHKBOX.byLocator(), driver);
			objaction.enterValue("TestFirstname", CommonPageObjects.RM_USER_FNAME.byLocator(), driver);
			objaction.enterValue("TestLastname", CommonPageObjects.RM_USER_LNAME.byLocator(), driver);
			objaction.enterValue("Dinesh.R@lntinfotech.com", CommonPageObjects.RM_USER_EMAILID.byLocator(), driver);
			objaction.enterValue("0123456789", CommonPageObjects.RM_USER_MBLNBR.byLocator(), driver);
			objaction.enterValue("AutomatedUser@123", CommonPageObjects.RM_USER_PWD.byLocator(), driver);
			objaction.enterValue("AutomatedUser@123", CommonPageObjects.RM_USER_CNFMPWD.byLocator(), driver);
			objaction.selectOption("2", CommonPageObjects.RM_USER_EXPDAY.byLocator(), driver);
			objaction.selectOption("Jan", CommonPageObjects.RM_USER_EXPMTH.byLocator(), driver);
			objaction.selectOption("2025", CommonPageObjects.RM_USER_EXPYR.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.RM_USER_PARNTGRPPOPUP.byLocator(), driver);
			driver.switchTo().frame(Constants.RM_POPUPFRAME);
			objaction.clickElement(CommonPageObjects.RM_USER_PARNTGRPSEARCH.byLocator(), driver);
			objaction.enterValue("Business Admin", CommonPageObjects.RM_USER_PARNTGRPSEARCH.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.RM_USER_PARNTGRPSELECT.byLocator(), driver);
			driver.switchTo().defaultContent();
			//profiletab
			objaction.clickElement(CommonPageObjects.RM_USER_PRFLTAB.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.RM_USER_PRFL_SEARCHPRFL.byLocator(), driver);
			objaction.enterValue("bbb", CommonPageObjects.RM_USER_PRFL_SEARCHPRFL.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.RM_USER_PRFL_SEARCHPRFLBTN.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.RM_USER_PRFL_ASSGNMTTILLDATE.byLocator(), driver);
			//Object right tab
			objaction.clickElement(CommonPageObjects.RM_USER_ORTAB.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.RM_USER_ORSEARCHPOPUP.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.RM_USER_ORSELECTVALUE.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.RM_USER_ORSELECTGENREPORT.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.RM_USER_ORADDBTN.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.RM_USER_ORCLOSEBTN.byLocator(), driver);
			driver.switchTo().window(winHandleBefore);
			MasterScript.test.log(Status.PASS, "User tab - Add a User ");

		} catch (Exception e) {
			throw e;
		}
	}
	
	public static void searchAndDeleteProfile() throws Exception {
	
		try {
			
			MasterScript.test.log(Status.INFO, "Profile tab - Search profile and perform delete operation");
			String profileName = objDataSheet.getDataValue("profileName").trim();
			driver.switchTo().frame(Constants.BA_RIGHTSMGMTFRAME);
			objaction.waitForElementVisible(CommonPageObjects.RM_PRFL_SEARCHPROFILETXT.byLocator(), driver);
			objaction.sleepForGivenTime(2000);
			objaction.clickElement(CommonPageObjects.RM_PRFL_SEARCHPROFILETXT.byLocator(), driver);
			objaction.sleepForGivenTime(2000);
			objaction.enterValue(profileName, CommonPageObjects.RM_PRFL_SEARCHPROFILETXT.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.RM_PRFL_SEARCHPROFILEBTN.byLocator(), driver);
			objaction.waitForElementVisible(CommonPageObjects.RM_PRFL_SElECTPROFILE.byLocator(), driver);
			objaction.sleepForGivenTime(2000);
			objaction.clickElement(CommonPageObjects.RM_PRFL_SElECTPROFILE.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.RM_PRFL_DELETEBTN.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.RM_PRFL_DELETECONFIRMYES.byLocator(), driver);
			objaction.waitForElementVisible(CommonPageObjects.RM_USERTAB.byLocator(), driver);
			driver.switchTo().defaultContent();
			MasterScript.test.log(Status.PASS, "Profile tab - Search profile and perform delete operation");
			
		} catch (Exception e) {
			throw e;
		}
		
		
		
	}
	public static void addProfile() throws Exception {

		try {

			String profileName = objDataSheet.getDataValue("profileName").trim();
			String profileDesc = objDataSheet.getDataValue("profileDesc").trim();
			
			MasterScript.test.log(Status.INFO, "Profile tab - Add a profile ");
			driver.switchTo().frame(Constants.BA_RIGHTSMGMTFRAME);
			objaction.clickElement(CommonPageObjects.RM_PRFL_ADDBTN.byLocator(), driver);
			String winHandleBefore = driver.getWindowHandle();
			objaction.switchTOLatestWindow(driver);
			objaction.enterValue(profileName, CommonPageObjects.RM_PRFL_PRFLNAME.byLocator(), driver);
			objaction.enterValue(profileDesc, CommonPageObjects.RM_PRFL_PRFLDESC.byLocator(), driver);
			
			String d1 = "14";
			String m1 ="May";
					
			
			objaction.clickElement(CommonPageObjects.RM_PRFL_UGROLES.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.RM_PRFL_UNAMERADIO.byLocator(), driver);
			
			Thread.sleep(8000);
			driver.findElement(By.xpath("//table[@id='profile:typeselectRadio']/tbody/tr[2]")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='profile:FieldBrowseDataBtn1']")).click();

			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id='calender']/thead/tr[1]/th/div/a[2]")).click();

			Thread.sleep(5000);

			WebElement ele =driver.findElement(By.xpath("//*[@id='calContainer_nav_month']"));

			Select select =new Select(ele);
			select.selectByVisibleText("December");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='calContainer_nav_year']")).clear();

			driver.findElement(By.xpath("//*[@id='calContainer_nav_year']")).sendKeys("2010");
			Thread.sleep(1000);

			driver.findElement(By.xpath("//*[@id='calContainer_nav_submit']")).click();
			
			//table[@id='calender']/tbody/tr/td[contains(@class,'calcell wd')]
			
			Thread.sleep(4000);
			List<WebElement> days=driver.findElements(By.xpath("//table[@id='calender']/tbody/tr/td[contains(@class,'calcell wd')]"));
			System.out.println(days.size());
			for(WebElement a:days)
			{
				String day=a.getText();
				System.out.println(day);
				if(day.equals("7")) {
					a.click();
					break;
				}
				
			}
			/*	objaction.enterValue("Automationone", CommonPageObjects.RM_PRFL_UNAMERADIOSEARCH.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.RM_PRFL_UNAMERADIOSEARCHBTN.byLocator(), driver);
			
			
			objaction.waitForElementVisible(CommonPageObjects.RM_PRFL_ERRORMSG1.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.RM_PRFL_PROPTAB.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.RM_PRFL_OBJECTTYPEPOPUPBTN.byLocator(), driver);
			objaction.waitForElementVisible(CommonPageObjects.RM_PRFL_OBJECTTYPESELECT.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.RM_PRFL_OBJECTTYPESELECT.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.RM_PRFL_SELECTGENREPORT.byLocator(), driver);
			objaction.waitForElementVisible(CommonPageObjects.RM_PRFL_PRFLADDBTN.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.RM_PRFL_PRFLADDBTN.byLocator(), driver);
			objaction.waitForPageToLoad(driver);
			objaction.waitForElementVisible(CommonPageObjects.RM_PRFL_ADDEDOBJECT.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.RM_PRFL_SAVEPRFLBTN.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.RM_PRFL_ADDSUCCESSPOPUP.byLocator(), driver);
			driver.switchTo().window(winHandleBefore);
			MasterScript.test.log(Status.PASS, "Profile tab - Add a profile ");*/

		} catch (Exception e) {
			throw e;
		}
	}

	public static void navigateToRightsManagement() throws Exception {

		try {

			MasterScript.test.log(Status.INFO, "Navigation to Rights management ");
			objaction.clickElement(CommonPageObjects.HOME_MENU.byLocator(), driver);
			objaction.waitForElementVisible(CommonPageObjects.HOME_MENUBA.byLocator(), driver);
			objaction.clickElement(CommonPageObjects.HOME_MENUBA.byLocator(), driver);
			objaction.waitForPageToLoad(driver);
			objaction.waitForElementVisible(CommonPageObjects.HOME_DCCMIMG.byLocator(), driver);
			objaction.sleepForGivenTime(5000);
			driver.switchTo().frame(Constants.BA_RIGHTSMGMTFRAME);
			objaction.waitForElementVisible(CommonPageObjects.RM_USERTAB.byLocator(), driver);
			driver.switchTo().defaultContent();
			objaction.clickElement(CommonPageObjects.RM_POPUPBTN.byLocator(), driver);
			MasterScript.test.log(Status.PASS, "Navigation to Rights management ");

		} catch (Exception e) {
			throw e;
		}
	}

}
















/*	objaction.sleepForGivenTime(1000);
Actions action=new Actions(driver);
WebElement element  = driver.findElement(By.id("profilemgmt:Prefix"));
action.moveToElement(element).click().perform();
objaction.sleepForGivenTime(3000);
*/