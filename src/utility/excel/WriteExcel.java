package utility.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class WriteExcel extends ReadExcel {

	/**
	 * Script Name : <b>WriteExcel</b> Description : Class file contains method
	 * to write data to the Master_Account_Investor file.
	 * 
	 * @since 2016/07/14
	 * @author 10613203
	 * @throws IOException
	 */
	StringWriter errors = new StringWriter();

	final String strbatchsheet = "Batch";
	final String strInvestorsheet = "Investor";
	final String strAccountsheet = "Account";
	final String strContractsheet = "Contract";
	final String strGIC_certificatesheet = "GIC_certificate";
	public String masterFilePath = masterDetailsFilePath;


	String[] arr_mastersheetlist = new String[] { strbatchsheet,
			strInvestorsheet, strAccountsheet, strContractsheet,
			strGIC_certificatesheet };
	//String[] arr_batchcolhdrs = new String[] { "BatchDate", "BatchType" };
	String[] arr_batchcolhdrs = new String[] {"Reference_Number_Batch","BatchId", "BatchCurrency","BatchDate","BatchType"};
	
	String[] arr_Investorcolhdrs = new String[] { "Reference_Number_Investor",
			"Investor_Number", "IVRDTL_InvestorType" };
	String[] arr_Accountcolhdrs = new String[] { "Reference_Number_Account",
			"ACCDTL_AccountNo", "ACCDTL_AccountType" };
	String[] arr_Contractcolhdrs = new String[] { "Reference_Number_Contract",
			"ACCCDTL_ContractNumber", "ACCCDTL_PolicyRefNo" };
	String[] arr_GIC_certificatecolhdrs = new String[] {
			"Reference_Number_GIC", "TRNGBUY_GICCertNo" };

	/**
	 * <h1>WriteData_to_masterfile</h1> This method is to write data to the file
	 * Master_Account_Investor.
	 * 
	 * @param objMastershtgs
	 *            Getter setter file object which contains the required sheet
	 *            and data to be written.
	 * @return Nothing.
	 * @author 10613203 - DineshRaja
	 * @version 1.0
	 * @since 2016-08-24
	 */
	public void WriteData_to_masterfile(MasterSheetGettersSetters objMastershtgs) {
		// System.out.println(test);
		String sheetname = objMastershtgs.getMasterSheetName();
		FileOutputStream fos = null;
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		XSSFSheet objsheet = null;
		try {
			fis = new FileInputStream(new File(
					objMastershtgs.getMasterFilePath()));
			workbook = new XSSFWorkbook(fis);
			objsheet = workbook.getSheet(sheetname);
			int totalNoOfRows = objsheet.getLastRowNum(); // To find last row no
			XSSFRow row1 = objsheet.createRow(totalNoOfRows + 1);
			for (int intcol_count = 0; intcol_count < objMastershtgs
					.getLstwritedata().size(); intcol_count++) {
				XSSFCell rno_cno = row1.createCell(intcol_count);
				rno_cno.setCellValue(objMastershtgs.getLstwritedata()
						.get(intcol_count).toString());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(new PrintWriter(errors));
			String strErr = (errors.toString());
			System.out.println("File: WriteExcel : Method[WriteData_to_masterfile]:"
							+ strErr);
			System.exit(0);
		} finally {
			try {
				fos = new FileOutputStream(new File(
						objMastershtgs.getMasterFilePath()));
				workbook.write(fos);
				fos.close();
			} catch (Exception e) {
				e.printStackTrace(new PrintWriter(errors));
				String strErr = (errors.toString());
				System.out.println("File: WriteExcel : Method[WriteData_to_masterfile]:"
								+ strErr);
				System.exit(0);
			}
		}

	}

	/**
	 * <h1>Verifymasterexcelfile</h1> This method is to verify the file
	 * Master_Account_Investor. <br>
	 * <br>
	 * If file not available - File will be created with all the
	 * sheets(Batch,Investor,Account,Contract,GIC_certificate) and also the
	 * respective header in it. <br>
	 * <br>
	 * If file available - Method will verify whether all the sheet exists. If a
	 * sheet doesnt exist it will create the sheet with its respective header. <br>
	 * <br>
	 * 
	 * @param objMastershtgs
	 *            Getter setter file object which contains the required sheet
	 *            and data to be written.
	 * @return Nothing.
	 * @author 10613203 - DineshRaja
	 * @version 1.0
	 * @since 2016-08-24
	 */
	public void Verifymasterexcelfile(MasterSheetGettersSetters objMastershtgs)
			throws IOException {
		ExcelUtility exlutility = new ExcelUtility();
		FileOutputStream fos = null;
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		String filepath = objMastershtgs.getMasterFilePath();
		// String sheetname=objMastershtgs.getMasterSheetName();
		try {
			// Verify file available
			Boolean bolfile_available = exlutility.verifyFileExists(filepath);
			// Create new file if its not available
			if (bolfile_available.equals(false)) {
				exlutility.createMasterExcelFile(filepath);
			}
			// Verify whether all the sheets exists
			fis = new FileInputStream(new File(filepath));
			workbook = new XSSFWorkbook(fis);
			for (int intshtlist = 0; intshtlist < arr_mastersheetlist.length; intshtlist++) {
				Boolean sheetexist = exlutility.verifyExcelSheetExists(
						workbook, arr_mastersheetlist[intshtlist]);
				if (sheetexist.equals(false)) {
					switch (arr_mastersheetlist[intshtlist]) {
					case strbatchsheet:
						exlutility.createExcelSheet(workbook, strbatchsheet,
								arr_batchcolhdrs);
						break;
					case strInvestorsheet:
						exlutility.createExcelSheet(workbook, strInvestorsheet,
								arr_Investorcolhdrs);
						break;
					case strAccountsheet:
						exlutility.createExcelSheet(workbook, strAccountsheet,
								arr_Accountcolhdrs);
						break;
					case strContractsheet:
						exlutility.createExcelSheet(workbook, strContractsheet,
								arr_Contractcolhdrs);
						break;
					case strGIC_certificatesheet:
						exlutility.createExcelSheet(workbook,
								strGIC_certificatesheet,
								arr_GIC_certificatecolhdrs);
						break;
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
				fos = new FileOutputStream(new File(filepath));
				workbook.write(fos);
				fos.close();
			} catch (Exception e) {
				e.printStackTrace(new PrintWriter(errors));
				String strErr = (errors.toString());
				System.out.println("File: WriteExcel : Method[Verifymasterexcelfile]:"
								+ strErr);
				System.exit(0);

			}

		}

	}

}
