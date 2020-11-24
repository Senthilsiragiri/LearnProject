package utility.excel;

import java.util.Arrays;
import utility.excel.ReadExcel;


public class GetDataSheet extends ReadExcel {

	public static Object[] obj1;
	public static String [] arrExcelHeader;
	public static String [][] arrExcelData;
	public static int rowCount;
	public static int testCaseRow;
	
	public void callGetExcelData(){
		
		obj1  =  (Object[]) getExcelData();
		arrExcelHeader = (String[])obj1[0];
		arrExcelData = (String[][])obj1[1];
		rowCount = (int) obj1[2];
		
	}
	
	public String testScriptName(){
		return rqmTestScriptName;
	}
	
	public int excelHeaderColumnCount(){
		return arrExcelHeader.length;		
	}
	
	public int excelRowCount(){
		return rowCount;
	}
	
	public String[] excelHeaderArray(){
		return arrExcelHeader;
	}	
	
	public String[][] excelDataArray(){
		return arrExcelData;
	}
	
	public String getDataValue(String strColumnName) throws Exception{
		//System.out.println("came inside");
		String getTextValue = null;
		 int screenFlag=1;
		
		try {
			
			int indexnbr = (Arrays.asList(arrExcelHeader).indexOf(strColumnName));
			
			if (indexnbr == -1 && screenFlag == 0){
				//getTextValue = "skip";
				getTextValue = "";
				//getTextValue = null;
			} else if (indexnbr == - 1 && screenFlag == 1){
				throw new ArrayIndexOutOfBoundsException("Column name " + strColumnName + " not available in Datasheet");
				
			} else {
				getTextValue = arrExcelData[testCaseRow][indexnbr];
			}
			
		} catch (Exception e) {

			throw e;
		}
		
		return getTextValue;
		
	}

	public String getDataValue(String strColumnName, int testCaseRow, int screenFlag) throws Exception{
		//System.out.println("came inside");
		String getTextValue = null;
		
		try {
			
			int indexnbr = (Arrays.asList(arrExcelHeader).indexOf(strColumnName));
			
			if (indexnbr == -1 && screenFlag == 0){
				//getTextValue = "skip";
				getTextValue = "";
				//getTextValue = null;
			} else if (indexnbr == - 1 && screenFlag == 1){
				throw new ArrayIndexOutOfBoundsException("Column name " + strColumnName + " not available in Datasheet");
				
			} else {
				getTextValue = arrExcelData[testCaseRow][indexnbr];
			}
			
		} catch (Exception e) {

			throw e;
		}
		
		return getTextValue;
		
	}
}

















