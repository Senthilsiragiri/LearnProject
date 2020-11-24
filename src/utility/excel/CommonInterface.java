package utility.excel;

import java.util.ArrayList;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import commonUtil.CommonActions;



public interface CommonInterface {
	
	
	public static GetDataSheet objDataSheet = new GetDataSheet();
	public static ArrayList<String> arrlWriteExcel = new ArrayList<String>();
	public static WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
	public static CommonActions objaction = new CommonActions();
	

}
