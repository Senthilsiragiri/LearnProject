package utility.excel;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.security.auth.login.LoginException;



/**
 * Description : Master file to handle excel files
 * 
 * @author 10613203
 */
public class MasterSheetController {

	MasterSheetGettersSetters objMastershtgs = new MasterSheetGettersSetters();
	WriteExcel objWriteExcel = new WriteExcel();
	StringWriter errors = new StringWriter();

	// for reading
	public MasterSheetController() {
	}

	/**
	 * <h1>MasterSheetController</h1> Constructor to get the array list and
	 * update MasterSheetGettersSetters
	 * 
	 * @param lstwritedata
	 *            specifies the data to write
	 * @return Nothing.
	 * @author 10613203 - DineshRaja
	 * @version 1.0
	 * @since 2016-08-24
	 */
	public MasterSheetController(ArrayList<String> lstwritedata) {
		try {
			objMastershtgs.setLstwritedata(lstwritedata);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(new PrintWriter(errors));
			String strErr = (errors.toString());
			System.out.println("File:MasterSheetController : Method[constructor MasterSheetController]:"
							+ strErr);
			System.exit(0);
		}
	}

	/**
	 * <h1>writeBatchData</h1> This Method to write data to the batch sheet in
	 * Master_Account_Investor file
	 * 
	 * @return Nothing.
	 * @author 10613203 - DineshRaja
	 * @version 1.0
	 * @since 2016-08-24
	 */
	public void writeBatchData() {
		try {
			String writeSheetname = objWriteExcel.strbatchsheet;
			this.startWriteToExcel(writeSheetname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(new PrintWriter(errors));
			String strErr = (errors.toString());
			System.out.println("File:MasterSheetController : Method[writeBatchdata]:"
							+ strErr);
			System.exit(0);
		}
	}

	/**
	 * <h1>writeInvestorData</h1> This Method to write data to the investor
	 * sheet in Master_Account_Investor file
	 * 
	 * @return Nothing.
	 * @author 10613203 - DineshRaja
	 * @version 1.0
	 * @since 2016-08-24
	 */
	public void writeInvestorData() {
		try {
			String writeSheetname = objWriteExcel.strInvestorsheet;
			this.startWriteToExcel(writeSheetname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(new PrintWriter(errors));
			String strErr = (errors.toString());
			System.out.println("File:MasterSheetController : Method[writeInvestordata]:"
							+ strErr);
			System.exit(0);
		}
	}

	/**
	 * <h1>writeAccountData</h1> This Method to write data to the account sheet
	 * in Master_Account_Investor file
	 * 
	 * @return Nothing.
	 * @author 10613203 - DineshRaja
	 * @version 1.0
	 * @since 2016-08-24
	 */
	public void writeAccountData() {
		try {
			String writeSheetname = objWriteExcel.strAccountsheet;
			this.startWriteToExcel(writeSheetname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(new PrintWriter(errors));
			String strErr = (errors.toString());
			System.out.println("File:MasterSheetController : Method[writeAccountdata]:"
							+ strErr);
			System.exit(0);
		}
	}

	/**
	 * <h1>writeContractData</h1> This Method to write data to the contract
	 * sheet in Master_Account_Investor file
	 * 
	 * @return Nothing.
	 * @author 10613203 - DineshRaja
	 * @version 1.0
	 * @since 2016-08-24
	 */
	public void writeContractData() {
		try {
			String writeSheetname = objWriteExcel.strContractsheet;
			this.startWriteToExcel(writeSheetname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(new PrintWriter(errors));
			String strErr = (errors.toString());
			System.out.println("File:MasterSheetController : Method[writeContractdata]:"
							+ strErr);
			System.exit(0);
		}
	}

	/**
	 * <h1>writeGICData</h1> This Method to write data to the GIC_certificate
	 * sheet in Master_Account_Investor file
	 * 
	 * @return Nothing.
	 * @author 10613203 - DineshRaja
	 * @version 1.0
	 * @since 2016-08-24
	 */
	public void writeGICData() {
		try {
			String writeSheetname = objWriteExcel.strGIC_certificatesheet;
			this.startWriteToExcel(writeSheetname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(new PrintWriter(errors));
			String strErr = (errors.toString());
			System.out.println("File:MasterSheetController : Method[writeGIC_certificatedata]:"
							+ strErr);
			System.exit(0);
		}
	}

	/**
	 * <h1>startWriteToExcel</h1> This Method to write data to
	 * Master_Account_Investor file.
	 * 
	 * @param writeSheetname
	 *            - Specifies the sheet name in Master_Account_Investor file
	 * @return Nothing.
	 * @author 10613203 - DineshRaja
	 * @version 1.0
	 * @since 2016-08-24
	 */
	public void startWriteToExcel(String writeSheetname) {
		try {
			objMastershtgs.setMasterFilePath(objWriteExcel.masterFilePath);
			objMastershtgs.setMasterSheetName(writeSheetname);
			objWriteExcel.Verifymasterexcelfile(objMastershtgs);
			objWriteExcel.WriteData_to_masterfile(objMastershtgs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(new PrintWriter(errors));
			String strErr = (errors.toString());
			System.out.println("File:MasterSheetController : Method[startWriteToExcel]:"
							+ strErr);
			System.exit(0);
		}

	}

	/**
	 * <h1>getInvestorData</h1> This Method to get the value of investor from
	 * Master_Account_Investor file
	 * 
	 * @param invReference
	 *            - Reference string of the investor mentioned in
	 *            Master_Account_Investor file
	 * @return Returns the investor number for the reference mentioned in
	 *         parameter invReference
	 * @author 10613203 - DineshRaja
	 * @version 1.0
	 * @since 2016-08-24
	 */
	public String getInvestorData(String invReference) {
		ReadMasterExcel objReadMasterExcel = new ReadMasterExcel();
		objMastershtgs.setMasterFilePath(objWriteExcel.masterFilePath);
		objMastershtgs.setMasterSheetName(objWriteExcel.strInvestorsheet);
		objMastershtgs.setReadRefColumn(0);
		objMastershtgs.setReadSourceColumn(1);
		objMastershtgs.setReadRefValue(invReference);
		String invno = objReadMasterExcel.ReadMasterFile(objMastershtgs);
		return invno;
	}

	/**
	 * <h1>getBatchData</h1> This Method to get the value of batch from
	 * Master_Account_Investor file
	 * 
	 * @param batchReference
	 *            - Reference string of the batch mentioned in
	 *            Master_Account_Investor file
	 * @return Returns the batch number for the reference mentioned in parameter
	 *         batchReference
	 * @author 10613203 - DineshRaja
	 * @version 1.0
	 * @since 2016-08-24
	 */
	public String getBatchData(String batchReference,int sourcecolumn) {
		ReadMasterExcel objReadMasterExcel = new ReadMasterExcel();
		objMastershtgs.setMasterFilePath(objWriteExcel.masterFilePath);
		objMastershtgs.setMasterSheetName(objWriteExcel.strbatchsheet);
		objMastershtgs.setReadRefColumn(0);
		objMastershtgs.setReadSourceColumn(sourcecolumn);
		objMastershtgs.setReadRefValue(batchReference);
		String batchno = objReadMasterExcel.ReadMasterFile(objMastershtgs);
		return batchno;
	}

	/**
	 * <h1>getAccountData</h1> This Method to get the value of account from
	 * Master_Account_Investor file
	 * 
	 * @param accountReference
	 *            - Reference string of the account mentioned in
	 *            Master_Account_Investor file
	 * @return Returns the account number for the reference mentioned in
	 *         parameter accountReference
	 * @author 10613203 - DineshRaja
	 * @version 1.0
	 * @since 2016-08-24
	 */
	public String getAccountData(String accountReference) {
		ReadMasterExcel objReadMasterExcel = new ReadMasterExcel();
		objMastershtgs.setMasterFilePath(objWriteExcel.masterFilePath);
		objMastershtgs.setMasterSheetName(objWriteExcel.strAccountsheet);
		objMastershtgs.setReadRefColumn(0);
		objMastershtgs.setReadSourceColumn(1);
		objMastershtgs.setReadRefValue(accountReference);
		String accntno = objReadMasterExcel.ReadMasterFile(objMastershtgs);
		return accntno;
	}

	/**
	 * <h1>getContractData</h1> This Method to get the value of contract from
	 * Master_Account_Investor file
	 * 
	 * @param contractReference
	 *            - Reference string of the contract mentioned in
	 *            Master_Account_Investor file
	 * @return Returns the contract number for the reference mentioned in
	 *         parameter contractReference
	 * @author 10613203 - DineshRaja
	 * @version 1.0
	 * @since 2016-08-24
	 */
	public String getContractData(String contractReference) {
		ReadMasterExcel objReadMasterExcel = new ReadMasterExcel();
		objMastershtgs.setMasterFilePath(objWriteExcel.masterFilePath);
		objMastershtgs.setMasterSheetName(objWriteExcel.strContractsheet);
		objMastershtgs.setReadRefColumn(0);
		objMastershtgs.setReadSourceColumn(1);
		objMastershtgs.setReadRefValue(contractReference);
		String cntrctno = objReadMasterExcel.ReadMasterFile(objMastershtgs);
		return cntrctno;
	}

	/**
	 * <h1>getGICData</h1> This Method to get the value of
	 * GICcertificate from Master_Account_Investor file
	 * 
	 * @param gicReference
	 *            - Reference string of the GICcertificate mentioned in
	 *            Master_Account_Investor file
	 * @return Returns the GICcertificate number for the reference mentioned in
	 *         parameter gicReference
	 * @author 10613203 - DineshRaja
	 * @version 1.0
	 * @since 2016-08-24
	 */
	public String getGICData(String gicReference) {
		ReadMasterExcel objReadMasterExcel = new ReadMasterExcel();
		objMastershtgs.setMasterFilePath(objWriteExcel.masterFilePath);
		objMastershtgs
				.setMasterSheetName(objWriteExcel.strGIC_certificatesheet);
		objMastershtgs.setReadRefColumn(0);
		objMastershtgs.setReadSourceColumn(1);
		objMastershtgs.setReadRefValue(gicReference);
		String gicCertificate = objReadMasterExcel
				.ReadMasterFile(objMastershtgs);
		return gicCertificate;
	}
}
