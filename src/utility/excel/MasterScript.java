package utility.excel;

	import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ResourceCDN;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utility.excel.ExcelUtility;
import utility.excel.ReadExcel;

public class MasterScript   implements CommonInterface
	{
		public static  ExtentHtmlReporter  htmlReporter;
		public static ExtentReports extent;
		public static  ExtentTest test;
		
		public static void main(String[] args)

		{
			
		  String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		  String wsname  = "dccmWorkspace";
		  int pos = System.getProperty("user.dir").indexOf(wsname);
		  String reportPath = System.getProperty("user.dir").substring(0,pos+wsname.length()) + "\\logs\\ExecutionReport"+timeStamp + ".html";
		  
		  htmlReporter =new ExtentHtmlReporter(reportPath);
		  htmlReporter.config().setResourceCDN(ResourceCDN.EXTENTREPORTS);
	      extent = new ExtentReports();
		  extent.attachReporter(htmlReporter);
	      htmlReporter.config().getResourceCDN(); 
		  htmlReporter.config().setChartVisibilityOnOpen(true);
		  htmlReporter.config().setDocumentTitle("Execution report");
		  htmlReporter.config().setReportName("Execution report");
		  htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		  htmlReporter.config().setTheme(Theme.STANDARD);
			
			
			XSSFWorkbook workBook = null; 
			XSSFSheet execVarSheet = null;
			XSSFSheet bpcListSheet = null;
		
			String testCaseName;
			//C:\Users\10637217\Desktop\DCCM\dccmWorkspace\dccm\Libs\drivers
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\10637217\\Desktop\\DCCM\\dccmWorkspace\\dccm\\Libs\\drivers\\chromedriver.exe");
			ExcelUtility objexcUtility = new ExcelUtility();
			String fileName = System.getProperty("user.dir") + "\\dataSheet\\MasterFile.xlsx";

			if (objexcUtility.verifyFileExists(fileName)) {
				
				try { 
					
					workBook = new XSSFWorkbook(fileName);
					execVarSheet = workBook.getSheet("ExecVariables");
					bpcListSheet = workBook.getSheet("BPCList");
					int totalNoOfRows = bpcListSheet.getLastRowNum();
					
					String rqmlangCode = execVarSheet.getRow(1).getCell(1).toString();
		
					
					ReadExcel.rqmConfigurationName = execVarSheet.getRow(2).getCell(1).toString();
					ReadExcel.rqmApplicationLevel = execVarSheet.getRow(3).getCell(1).toString();
					ReadExcel.rqmTeamName = execVarSheet.getRow(4).getCell(1).toString();
					
					System.out.println(rqmlangCode );
					System.out.println(totalNoOfRows );
					for (int rowCtr = 1; rowCtr <= totalNoOfRows; rowCtr++) {
						
						try {
							
							if (bpcListSheet.getRow(rowCtr).getCell(1).toString().equalsIgnoreCase("yes")){
								
								testCaseName = bpcListSheet.getRow(rowCtr).getCell(2).toString();
								ReadExcel.rqmTestCaseName = testCaseName ;
								ReadExcel.rqmTestScriptName = bpcListSheet.getRow(rowCtr).getCell(3).toString();
					        	Object xyz = Class.forName("pages." + testCaseName ).newInstance();
								Method m = xyz.getClass().getMethod("main", String[].class);
								String[] params = null; // init params accordingly
    							m.invoke(null, (Object) params);
    				
								
							} 
							
						} catch (Exception e) {

							e.printStackTrace();
						}
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}		
			
			System.out.println("end f master");
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*working to call method other than main
	Object xyz = Class.forName("pkg1." + testCaseName ).newInstance();
	Method m = xyz.getClass().getMethod("main");
	m.invoke(xyz);working end */
	
	/*working for  mainworking end */
