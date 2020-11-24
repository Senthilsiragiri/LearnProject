package utility.excel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.format.CellDateFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/**
 * Description : Class file having com.lnt.fsti.utility functions to handle excel files
 * 
 * @author 10613203
 */
public class ExcelUtility {
	// Object create to printstacktrace in the report
	StringWriter errors = new StringWriter();
	// Workbook object for xlsx files
	XSSFWorkbook workbook = null;

	/**
	 * <h1>verifyExcelSheetExists</h1> This method is to verify whether an sheet
	 * exists
	 * 
	 * @param wkb
	 *            Workbook object needs to be passed for this parameter
	 * @param strsheetname
	 *            Sheet name to be verified should be passed for this parameter
	 * @return Nothing.
	 * @author 10613203 - DineshRaja
	 * @version 1.0
	 * @since 2016-08-24
	 */
	public boolean verifyExcelSheetExists(XSSFWorkbook wkb, String strsheetname)

	{
		try {
			// Getting sheets counts
			int numberOfSheets = wkb.getNumberOfSheets();
			strsheetname = strsheetname.toUpperCase();
			// Looping through the list of sheets
			for (int int_sheets = 0; int_sheets < numberOfSheets; int_sheets++) {
				XSSFSheet objSheet = wkb.getSheetAt(int_sheets);
				String stravlsheet = objSheet.getSheetName().toUpperCase();
				if (strsheetname.equals(stravlsheet)) {
					return true; // Return true if sheet exists
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace(new PrintWriter(errors));
			String strErr = (errors.toString());
			System.out.println("File: Excelutility : Method[Method:VerifyExcelSheetExists]:"
							+ strErr);
			return false;
		}

	}

	/**
	 * <h1>createExcelSheet</h1> This method is to create an excel sheet and
	 * write header in to it.
	 * 
	 * @param wkb
	 *            Workbook object needs to be passed for this parameter
	 * @param sheetname
	 *            Specifies the sheet name to be created
	 * @param arr_colnames
	 *            specifies the string array having the data to write headers
	 * @return Returns True - If sheet exists, False - If sheet not exists
	 * @author 10613203 - DineshRaja
	 * @version 1.0
	 * @since 2016-08-24
	 */
	public void createExcelSheet(XSSFWorkbook wkb, String sheetname,
			String[] arr_colnames) {
		try {
			// specifyin cell style
			CellStyle style = wkb.createCellStyle();
			XSSFFont font = wkb.createFont();
			font.setColor(IndexedColors.BLUE.getIndex());
			font.setBold(true);
			style.setFont(font);
			// Creating the sheet
			XSSFSheet objsheet = wkb.createSheet(sheetname);
			XSSFRow row1 = objsheet.createRow(0);
			// Writing the headers to the file
			for (int intcol_count = 0; intcol_count < arr_colnames.length; intcol_count++) {
				XSSFCell rno_cno = row1.createCell(intcol_count);
				rno_cno.setCellValue(arr_colnames[intcol_count]);
				rno_cno.setCellStyle(style);
				objsheet.autoSizeColumn(intcol_count);
			}
		} catch (Exception e) {
			e.printStackTrace(new PrintWriter(errors));
			String strErr = (errors.toString());
			System.out.println("File: Excelutility : Method[CreateExcelSheet]:"
							+ strErr);
			System.exit(0);
		}
	}

	/**
	 * <h1>verifyFileExists</h1> This method is to verify whether a file exists.
	 * 
	 * @param Filename
	 *            specifies the file path to be verified
	 * @return Returns True - If File exists, False - If File not exists
	 * @author 10613203 - DineshRaja
	 * @version 1.0
	 * @since 2016-08-24
	 */
	public boolean verifyFileExists(String filename) {
		try {
			File objfile = new File(filename);
			if (objfile.exists() == true) {
				return true;
			} else {
				System.out.println("Method[verifyFileExists]: File not found "
						+ filename);
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace(new PrintWriter(errors));
			String strErr = (errors.toString());
			System.out.println("File: Excelutility : Method[verifyFileExists]:"
							+ strErr);
			return false;
		}
	}

	/**
	 * <h1>createMasterExcelFile</h1> This method is to Create a master file
	 * named Master_Account_Investor. Creates sheets named
	 * Batch,Investor,Account,Contract,GIC_certificate
	 * 
	 * @param Filename
	 *            specifies the path where file needs to be created.
	 * @return Nothing.
	 * @author 10613203 - DineshRaja
	 * @version 1.0
	 * @since 2016-08-24
	 */
	public void createMasterExcelFile(String filepath) {
		FileOutputStream fos = null;
		WriteExcel objwriteexl = new WriteExcel();
		try {
			// Creating the new workbook
			workbook = new XSSFWorkbook();
			// Creating the batch sheet and writing the headers(with array
			// arr_batchcolhdrs) using method
			// write_headers_createmasterexcelfile
			XSSFSheet sheet1_Batch = workbook
					.createSheet(objwriteexl.strbatchsheet);
			writeHeadersCreateMasterExcelFile(sheet1_Batch,
					objwriteexl.arr_batchcolhdrs);

			// Creating the investor sheet and writing the headers(with array
			// arr_Investorcolhdrs) using method
			// write_headers_createmasterexcelfile
			XSSFSheet sheet2_Investor = workbook
					.createSheet(objwriteexl.strInvestorsheet);
			writeHeadersCreateMasterExcelFile(sheet2_Investor,
					objwriteexl.arr_Investorcolhdrs);

			// Creating the account sheet and writing the headers(with array
			// arr_Accountcolhdrs) using method
			// write_headers_createmasterexcelfile
			XSSFSheet sheet3_Account = workbook
					.createSheet(objwriteexl.strAccountsheet);
			writeHeadersCreateMasterExcelFile(sheet3_Account,
					objwriteexl.arr_Accountcolhdrs);

			// Creating the contract sheet and writing the headers(with array
			// arr_Contractcolhdrs) using method
			// write_headers_createmasterexcelfile
			XSSFSheet sheet4_Contract = workbook
					.createSheet(objwriteexl.strContractsheet);
			writeHeadersCreateMasterExcelFile(sheet4_Contract,
					objwriteexl.arr_Contractcolhdrs);

			// Creating the GIC_certificate sheet and writing the headers(with
			// array arr_GIC_certificatecolhdrs) using method
			// write_headers_createmasterexcelfile
			XSSFSheet sheet4_GIC_certificate = workbook
					.createSheet(objwriteexl.strGIC_certificatesheet);
			writeHeadersCreateMasterExcelFile(sheet4_GIC_certificate,
					objwriteexl.arr_GIC_certificatecolhdrs);

		} catch (Exception e) {
			e.printStackTrace(new PrintWriter(errors));
			String strErr = (errors.toString());
			System.out.println("File: Excelutility : Method[create_masterexcelfile]:"
							+ strErr);

		} finally {

			try {
				fos = new FileOutputStream(new File(filepath));
				workbook.write(fos);
				fos.close();
			} catch (Exception e) {
				e.printStackTrace(new PrintWriter(errors));
				String strErr = (errors.toString());
				System.out.println("File: Excelutility : Method[create_masterexcelfile]:"
								+ strErr);

			}
		}
	}

	/**
	 * <h1>writeHeadersCreateMasterExcelFile</h1> This method is to write
	 * headers to each sheet of master file. Method will be called from
	 * create_masterexcelfile method to write headers.
	 * 
	 * @param objsht
	 *            specifies the sheet name.
	 * @param arrcolhdrs
	 *            specifies the string array having the data to write as header.
	 * @return Nothing.
	 * @author 10613203 - DineshRaja
	 * @version 1.0
	 * @since 2016-08-24
	 */
	public void writeHeadersCreateMasterExcelFile(XSSFSheet objsht,
			String[] arrcolhdrs) {
		try {
			CellStyle style = null;
			XSSFFont font = null;
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setColor(IndexedColors.BLUE.getIndex());
			font.setBold(true);

			style.setFont(font);
			XSSFRow row1 = objsht.createRow(0);
			// row1.setRowStyle(style);

			for (int intcol_count = 0; intcol_count < arrcolhdrs.length; intcol_count++) {

				XSSFCell rno_cno = row1.createCell(intcol_count);
				rno_cno.setCellValue(arrcolhdrs[intcol_count]);
				rno_cno.setCellStyle(style);
				objsht.autoSizeColumn(intcol_count);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(new PrintWriter(errors));
			String strErr = (errors.toString());
			System.out.println("File: Excelutility : Method[write_headers_createmasterexcelfile]:"
							+ strErr);

		}

	}

	/**
	 * <h1>getCellValue</h1> This method is to return the value of a specific
	 * cell in String format
	 * 
	 * @param cell
	 *            cell object to read
	 * @param wkb
	 *            workbook object of the excel file
	 * @return string value of the cell
	 * @author 10613203 - DineshRaja
	 * @version 1.0
	 * @since 2016-08-24
	 */
	public String getCellValue(Cell cell, Workbook wkb) {
		String value = "";

		switch (cell.getCellType()) {

		case XSSFCell.CELL_TYPE_NUMERIC:
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				java.util.Date date = cell.getDateCellValue();
				String dateFmt = "";
				if (cell.getCellStyle().getDataFormat() == 14) { // default
																	// short
																	// date
																	// without
																	// explicit
																	// formatting
					dateFmt = "dd/mm/yyyy"; // default date format for this
				
				} else { // other data formats with explicit formatting
					dateFmt = cell.getCellStyle().getDataFormatString();
				}
				value = new CellDateFormatter(dateFmt).format(date);
			} else {
				cell.setCellType(Cell.CELL_TYPE_STRING);
				value = cell.getStringCellValue();
			}
			break;

		case XSSFCell.CELL_TYPE_STRING:
			value = cell.getStringCellValue();
			break;

		case XSSFCell.CELL_TYPE_BLANK:
			value = "";
			break;

		case XSSFCell.CELL_TYPE_FORMULA:
			FormulaEvaluator evaluator = wkb.getCreationHelper()
					.createFormulaEvaluator();
			CellValue cellValue = evaluator.evaluate(cell);
			switch (cellValue.getCellType()) {
			case Cell.CELL_TYPE_BOOLEAN:
				value = String.valueOf(cellValue.getBooleanValue());
				break;
			case Cell.CELL_TYPE_NUMERIC:
				double dv = cellValue.getNumberValue();
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					java.util.Date date = HSSFDateUtil.getJavaDate(dv);
					String dateFmt = "";
					if (cell.getCellStyle().getDataFormat() == 14) { // default
																		// short
																		// date
																		// without
																		// explicit
																		// formatting
						dateFmt = "dd/mm/yyyy"; // default date format for this
					} else { // other data formats with explicit formatting
						dateFmt = cell.getCellStyle().getDataFormatString();
						
					}
					value = new CellDateFormatter(dateFmt).format(date);
				} else {
					cell.setCellType(Cell.CELL_TYPE_STRING);
					value = cell.getStringCellValue();
				}
				break;
			case Cell.CELL_TYPE_STRING:
				value = (cellValue.getStringValue());
				break;
			case Cell.CELL_TYPE_BLANK:
				value = "";
				break;
			case Cell.CELL_TYPE_ERROR:
				System.out.println("coming2");
				value = "";
				break;

			// CELL_TYPE_FORMULA will never happen
			case Cell.CELL_TYPE_FORMULA:
				break;
			}
			break;
		default:
			break;
		}
		return value;
	}

}
