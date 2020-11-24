package utility.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.format.CellDateFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/**
 * Description : Class file to read data from master excel file.
 * 
 * @author 10613203
 */
public class ReadMasterExcel {

	ExcelUtility objEu = new ExcelUtility();
	StringWriter errors = new StringWriter();

	/**
	 * <h1>ReadMasterFile</h1> This method is to read data from
	 * Master_Account_Investor.
	 * 
	 * @param objMastershtgs
	 *            object for the getter setter file MasterSheetGettersSetters
	 * @return Returns a string value for the reference getReadrefvalue
	 *         mentioned in getter setter file(MasterSheetGettersSetters)
	 * @author 10613203 - DineshRaja
	 * @version 1.0
	 * @since 2016-08-24
	 */
	public String ReadMasterFile(MasterSheetGettersSetters objMastershtgs) {
		String value = "";
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		XSSFSheet objsheet = null;

		try {
			fis = new FileInputStream(new File(objMastershtgs.getMasterFilePath()));
			workbook = new XSSFWorkbook(fis);
			objsheet = workbook.getSheet(objMastershtgs.getMasterSheetName());
			int totalNoOfRows = objsheet.getLastRowNum();
			for (int i = 1; i <= totalNoOfRows; i++) {
				Cell cell1 = (objsheet.getRow(i).getCell(objMastershtgs
						.getReadRefColumn()));
				Cell cell = (objsheet.getRow(i).getCell(objMastershtgs
						.getReadSourceColumn()));
				String expctdValue = objMastershtgs.getReadRefValue()
						.toUpperCase().trim();
				if (cell1 != null
						&& (cell1.getStringCellValue().toUpperCase().trim()
								.equals(expctdValue))) {
					if (cell != null) {
						value = objEu.getCellValue(cell, workbook);
					}
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace(new PrintWriter(errors));
			String strErr = (errors.toString());
			System.out.println("File: WriteExcel : Method[Verifymasterexcelfile]:"
							+ strErr);
			System.exit(0);

		} catch (IOException e) {
			e.printStackTrace(new PrintWriter(errors));
			String strErr = (errors.toString());
			System.out.println("File: WriteExcel : Method[Verifymasterexcelfile]:"
							+ strErr);
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace(new PrintWriter(errors));
			String strErr = (errors.toString());
			System.out.println("File: WriteExcel : Method[Verifymasterexcelfile]:"
							+ strErr);
			System.exit(0);
		}

		finally {
			try {
				fis.close();
				workbook.close();
			} catch (Exception e) {
				e.printStackTrace(new PrintWriter(errors));
				String strErr = (errors.toString());
				System.out.println("File: WriteExcel : Method[ReadMasterFile]:"
								+ strErr);
				System.exit(0);

			}
		}
		return value;
	}

}
