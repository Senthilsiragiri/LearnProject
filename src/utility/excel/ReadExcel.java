package utility.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;


import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Description : Class file to read data from the datasheet.
 * @author 10613203
 */
public class ReadExcel {//implements ObjectsInterface {

	public static String masterDetailsFilePath = null;

	//int rowCount = 0;
	ExcelUtility objEu = new ExcelUtility();
	StringWriter errors = new StringWriter();
	//protected String strTestScriptName;
	
	public static String rqmTestCaseName;
	public static String rqmTestScriptName;
	public static String rqmConfigurationName;
	public static String rqmApplicationLevel;
	public static String rqmTeamName;
	public static String rqmLanguage;
	InputStream istream;
	InputStream errIstream;
	
	Properties props = new Properties();
	Properties errorProps = new Properties();
	
	/**
	* <h1>getExcelData</h1>
	* This method is to read all the data from the test case file and to store it in a hashmap
	* @param Vm Ivariables manager contains RQM execution variables
	* @return Array and a hashmap. Array - contains headers mentioned in row1.Hashmap - Contains all the data from row2
	* @author 10613203 -  DineshRaja
	* @version 1.0
	* @since   2016-08-24 
	*/	
	public Object getExcelData() {
		int rowCount = 0;
		String fileName = null;
		String sheetName = null;
		String[] arrayExcelhdr = null;
		String [][] arrayExcelData = null;
		Workbook wkb = null;
		

		//String dataPackagePath = "\\com\\lnt\\fsti\\dataSheet\\";

		String dataPackagePath = "\\dataSheet\\";
		//D:\RQM Workspace\RQM_version1\dataSheet
		//Iterator<IParameter> iParVm = Vm.getAllInputParameters();

		try {
			

			/*if (iParVm.hasNext()) {

				rqmTestCaseName = Vm.getInputParameter(propRqm.getProperty("rqmTestCaseName")).getValue();
				rqmTestScriptName = Vm.getInputParameter(propRqm.getProperty("rqmTestScriptName")).getValue();
				rqmConfigurationName = Vm.getInputParameter(propRqm.getProperty("rqmConfigurationName")).getValue();
				rqmApplicationLevel = Vm.getInputParameter(propRqm.getProperty("rqmApplicationLevel")).getValue();
				rqmTeamName = Vm.getInputParameter(propRqm.getProperty("rqmTeamName")).getValue();
				
				rqmLanguage = Vm.getInputParameter(propRqm.getProperty("rqmLanguage")).getValue();
				
				istream = getClass().getClassLoader().getResourceAsStream(
						"resources/labels/" + rqmLanguage + "/common.properties");
				
				errIstream = getClass().getClassLoader().getResourceAsStream(
						"resources/labels/" + rqmLanguage + "/ErrMessages.properties");
				
				props.load(istream);
				errorProps.load(errIstream);

				langProp = props;

				
			}*/

			sheetName = rqmTestScriptName;
			fileName = System.getProperty("user.dir");

			String[] arrTempTestCaseName = rqmTestCaseName.split("_");
			masterDetailsFilePath = fileName + dataPackagePath + rqmApplicationLevel + "\\" + rqmTeamName + "\\" + rqmConfigurationName
					+ "\\Master_Account_Investor.xlsx";
			//System.out.println(masterDetailsFilePath);
			if (arrTempTestCaseName.length == 3) {

				if (arrTempTestCaseName[arrTempTestCaseName.length - 1]
						.equalsIgnoreCase("screen")) {
					/*fileName = fileName + dataPackagePath + rqmApplicationLevel + "\\" + rqmTeamName + "\\" + rqmConfigurationName + "\\screenDataSheets\\"
						+ arrTempTestCaseName[0] + "\\"
							+ arrTempTestCaseName[1] + ".xlsx";
					RationalTestScript.logInfo("DataSheet path: " + fileName);
					RationalTestScript.logInfo("Sheet name: " + rqmTestScriptName);*/
				}
			} else {
				/*fileName = fileName + dataPackagePath
						+ rqmApplicationLevel + "\\" + rqmTeamName + "\\" + rqmConfigurationName
						+ "\\functionalDataSheets\\" + rqmTestCaseName
						+ ".xlsx";
				RationalTestScript.logInfo("DataSheet path: " + fileName);
				RationalTestScript.logInfo("Sheet name: " + rqmTestScriptName);*/
			}
			
			//System.out.println("rqmTestCaseName:" + rqmTestCaseName);
			fileName = fileName + dataPackagePath +  rqmTestCaseName	+ ".xlsx";
			/*D:\RQM Workspace\RQM_version1\com\lnt\fsti\dataSheet\UpdateTestCase.xlsx
			D:\RQM Workspace\RQM_version1\dataSheet*/
			System.out.println("fileName::: " + fileName);
			
			
			File file = new File(fileName);
			FileInputStream inputStream = null;
			inputStream = new FileInputStream(file);

			wkb = new XSSFWorkbook(inputStream);
			Sheet sht = wkb.getSheet(sheetName);
			int totalNoOfRows = sht.getLastRowNum(); // To find last row no
			
			
			//System.out.println("row in re" + totalNoOfRows);
			
			int totalNoOfCols = sht.getRow(0).getLastCellNum();// To find last  col no
			arrayExcelhdr = new String[totalNoOfCols];
		 	arrayExcelData = new String[totalNoOfRows][totalNoOfCols];
/*		 	System.out.println("arrayExcelhdr " + arrayExcelhdr.length);
		 	System.out.println("arrayExcelData " + arrayExcelData.length);
		 	System.out.println("rows " + totalNoOfRows );
		 	System.out.println("cols " + totalNoOfCols );*/
			int colCount = 0;
			String value1 = "";

			for (int rowCtr = 0; rowCtr <= totalNoOfRows; rowCtr++) {
				colCount = 0;
				for (int colCtr = 0; colCtr < totalNoOfCols; colCtr++) {

					Cell cell = (sht.getRow(rowCtr).getCell(colCtr));
					if (rowCtr == 0) {
						if (cell == null || cell.equals("")) {
							arrayExcelhdr[colCtr] = "";
						} else {
							arrayExcelhdr[colCtr] = cell.getStringCellValue();
						}
					} else {
						  // if (!sht.getRow(rowCtr).getCell(1).getStringCellValue().toUpperCase().equals("")) {
							if (sht.getRow(rowCtr).getCell(1).getStringCellValue().toUpperCase().equals("YES")) {
							if (cell == null || cell.equals("")) {
								value1 = "";
							} else {
								value1 = objEu.getCellValue(cell, wkb);
							}
							arrayExcelData[rowCount][colCount]= value1;
							//Hm.put(r1c1, value1);
							colCount++;
						}
					}
				}
				if (colCount > 0) {
					rowCount++;
				}
			}

			wkb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace(new PrintWriter(errors));
			String strErr = (errors.toString());
			System.out.println(strErr);
		} catch (IOException e) {
			e.printStackTrace(new PrintWriter(errors));
			String strErr = (errors.toString());
			System.out.println(strErr);
		} catch (Exception e) {
			e.printStackTrace(new PrintWriter(errors));
			String strErr = (errors.toString());
			System.out.println(strErr);
		}

		finally {
			try {
				wkb.close();
				//System.out.println("Number of records to be executed : " + Integer.toString(rowCount));
			} catch (Exception e) {
				e.printStackTrace(new PrintWriter(errors));
				String strErr = (errors.toString());
				System.out.println(strErr);
			}
		}
		
		return (new Object[] { arrayExcelhdr,arrayExcelData, rowCount });
	}

}
