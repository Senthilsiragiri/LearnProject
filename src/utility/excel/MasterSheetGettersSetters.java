package utility.excel;

import java.util.ArrayList;
/**
 * Description   : Getter setter file for handling master excel file.
 * @author 10613203
 */
public class MasterSheetGettersSetters {

	private String masterFilePath;
	private String masterSheetName;
	private ArrayList<String> lstwritedata = new ArrayList<String>();

	private String readrefvalue;
	private int readrefColumn;
	private int readsourceColumn;

	/*********** Getter setter to write data *****************************/

	public ArrayList<String> getLstwritedata() {
		return lstwritedata;
	}

	public void setLstwritedata(ArrayList<String> lstwritedata) {
		this.lstwritedata = lstwritedata;
	}

	public String getMasterFilePath() {
		return masterFilePath;
	}

	public void setMasterFilePath(String masterFilePath) {
		this.masterFilePath = masterFilePath;
	}

	public String getMasterSheetName() {
		return masterSheetName;
	}

	public void setMasterSheetName(String masterSheetName) {
		this.masterSheetName = masterSheetName;
	}

	/******************** Getter setter to read data *******************/

	public int getReadRefColumn() {
		return readrefColumn;
	}

	public void setReadRefColumn(int readrefColumn) {
		this.readrefColumn = readrefColumn;
	}

	public int getReadSourceColumn() {
		return readsourceColumn;
	}

	public void setReadSourceColumn(int readsourceColumn) {
		this.readsourceColumn = readsourceColumn;
	}

	public String getReadRefValue() {
		return readrefvalue;
	}

	public void setReadRefValue(String readrefvalue) {
		this.readrefvalue = readrefvalue;
	}

}