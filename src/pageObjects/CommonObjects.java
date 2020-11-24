
package pageObjects;
import org.openqa.selenium.By;

public class CommonObjects {

	
	
public enum CommonPageObjects{		
	
/*------------------------------------------------Login page----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
		LOGIN_USERNAME(By.id("oaloginform:userid"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		LOGIN_PASSWORD(By.id("oaloginform:password"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		LOGIN_BUTTON(By.id("oaloginform:loginbtn"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		LOGIN_LOGINAGN_BUTTON(By.id(""),By.cssSelector(""),By.xpath("/html/body/table/tbody/tr[5]/td/table/tbody/tr/td[2]/span/a/span"),By.name(""), By.linkText("")),
/*------------------------------------------------Home page----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
		HOME_LNKCM(By.id("form:selectedUserViewName"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		HOME_MYQUEUECHECKALL(By.id("wlf:checkBoxAll"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		HOME_USERREPORTVIEW_GENREP(By.id("mainpage:category"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		HOME_MYQUEUEFRAME(By.id("iframe_Int43"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		HOME_DCCMIMG(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"form\"]/table[1]/tbody/tr/td[1]/table/tbody/tr/td/img"),By.name(""), By.linkText("")),
		HOME_MENU(By.id("form:selectedUserViewName"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		HOME_MENUBA(By.id("form:dataTable:0:userViewName1"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
/*------------------------------------------------Queue Management page--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
		QM_ADDBTN(By.id("QueueListForm:BtnAdd"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_UPDATEBTN(By.id("QueueListForm:BtndisUpdate"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_DELETEBTN(By.id("QueueListForm:BtnDelete"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_DELETECMMNTBOX(By.id("CommentForm:bp:comments"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_DELETECMMNTOK(By.id("CommentForm:bp:cmdOk"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_POPOUTBTN(By.id("blankp1:bp_Int10:popoutImg"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_SEARCHPOPUPBTN(By.id("QueueListForm:pidBtn"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_SEARCHPROCESS(By.id("ProcessPickList:bp:Prefix"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_SERCHBTN(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"ProcessPickList:bp:s3\"]/tbody/tr/td/div/input[3]"),By.name(""), By.linkText("")),
		QM_SEARCHQUEUETXT(By.id("QueueListForm:Prefix"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_SEARCHQUEUEBTN(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"QueueListForm:s1\"]/tbody/tr/td/div/input[3]"),By.name(""), By.linkText("")),
		QM_SELECTFRMLIST(By.id("ProcessPickList:bp:j_idt32:0:pname"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_SELECTAUTOMATIONQUEUE(By.id("QueueListForm:queueLists:2:chkBoxQueue"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_QUEUENAME(By.id("QueueMgmtForm:txtQueueName"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_QUEUEDESC(By.id("QueueMgmtForm:txtDescription"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_PROCESSQUEUECHK(By.id("QueueMgmtForm:chkProce"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_FETCHWISEARCHPOPUP(By.id("QueueMgmtForm:cmd_ProcessVar"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_SEARCHVALUE(By.id("dataRow2"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_WIPCHK(By.id("QueueMgmtForm:optWip:0"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_FILTER1(By.id("QueueMgmtForm:queuefilter"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_FILTER2(By.id("QueueMgmtForm:searchfilter"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_FILTER2SEARCHRADIOBTN(By.id("QueueMgmtForm:optWipfetch4:0"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_SELECTDRPDWN(By.id("QueueMgmtForm:cmbEqualTo"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_PROCESSQUEUESEARCHPOPUP(By.id("QueueMgmtForm:cmdPicklist_Proc"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_PROCESSQUEUE_PROCESSNAME(By.id("ProcessPickList:bp:Prefix"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_PROCESSQUEUE_ENTERPROCESSNAME(By.id("QueueMgmtForm:txtProcName"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_PROCESSQUEUE_SEARCHROCESSBTN(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"ProcessPickList:bp:s3\"]/tbody/tr/td/div/input[3]"),By.name(""), By.linkText("")),
		QM_PROCESSQUEUE_SELECTPROCESS(By.id("ProcessPickList:bp:j_idt32:0:pname"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_WORKITEMRADIOBTN(By.id("QueueMgmtForm:optWorkitem_Equal:0"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_ADDDRPDWN_WRKITM(By.id("QueueMgmtForm:cmbEqualTo"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		/****************User tab************/  
		QM_USERTAB(By.id("QueueMgmtForm:userTab"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_USER_USERRADIO(By.id("QueueMgmtForm:optGroup:1"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_USER_ADDBTN(By.id("QueueMgmtForm:cmdAdd"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_USER_SEARCHBOX(By.id("QueueMgmtForm:Prefix"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_USER_SEARCHBTN(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"QueueMgmtForm:s3\"]/tbody/tr/td/div/input[3]"),By.name(""), By.linkText("")),
		QM_USER_ENDOKBTN(By.id("QueueMgmtForm:cmdSetUsr"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_USER_SEARCHPOPUP(By.id("QueueMgmtForm:cmdPicklist_User"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_USER_FILTERONNAME(By.id("UserPickList:blankpanel:bp:plus"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_USER_FILTERONNAMESEARCH(By.id("UserPickList:blankpanel:bp:Prefix"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_USER_FILTERONNAMESEARCHbtn(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"UserPickList:blankpanel:bp:s1\"]/tbody/tr/td/div/input[3]"),By.name(""), By.linkText("")),
		QM_USER_FILTERONNAME_SELECTVALUE(By.id("UserPickList:blankpanel:bp:userlisttable:0:chkboxMultiple"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_USER_FILTERONNAME_SELECTOK(By.id("UserPickList:blankpanel:bp:cmd_OK"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		/**************Activity tab ************/
		QM_ACTIVITYTAB(By.id("QueueMgmtForm:activityTab"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_ACTIVITY_SEARCHPOPUP(By.id("QueueMgmtForm:cmdPicklist_Queue"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_ACTIVITY_SEARCHBOX(By.id("ProcessPickList:bp:Prefix"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_ACTIVITY_SEARCHBTN(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"ProcessPickList:bp:s3\"]/tbody/tr/td/div/input[3]"),By.name(""), By.linkText("")),
		QM_ACTIVITY_SELECTVALUE(By.id("ProcessPickList:bp:j_idt40:0:pname"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_ACTIVITY_ADDBTN(By.id("QueueMgmtForm:cmdAddBtn"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		/**************Worklist config tab ************/
		QM_WRKLSTCONFIGTAB(By.id("QueueMgmtForm:mobileConfTab"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_WRKLSTCONFIG_ACTNAMERADIO(By.id("QueueMgmtForm:sysVariables:0:checkBox"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_WRKLSTCONFIG_ACTNAMETXT(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"QueueMgmtForm:sysVariables\"]/tbody/tr[1]/td[3]/input"),By.name(""), By.linkText("")),
		QM_WRKLSTCONFIG_FINALOKBTN(By.id("QueueMgmtForm:cmdSetMobileConf"),By.cssSelector(""),By.xpath("//*[@id=\"QueueMgmtForm:sysVariables\"]/tbody/tr[1]/td[3]/input"),By.name(""), By.linkText("")),
		QM_ADD_OKBTN(By.id("CommentForm:bp:comments"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_ADD_COMMENT(By.id("CommentForm:bp:comments"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_COMMENTOKBTN(By.id("CommentForm:bp:cmdOk"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		QM_ADDEDSUCESS_OKBTN(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"AddSuccessDiv\"]/div/div/div/div/div/div/div/div/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[2]/input"),By.name(""), By.linkText("")),
/*----------------------------------------------------------User management page----------------------------------------------------------------------------------------------------------------------------------------------------------------------*/		
		UM_ADDTOQUEUEBTN(By.id("userview:BtnDelete"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETDIVERSIONBTN(By.id("userview:BtnDiversion"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETWORKAUDITBTN(By.id("userview:BtnAddTab"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_WORKAUDITBTN(By.id("userview:BtnUpdateTab"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_POPOUTBTN(By.id("blankp1:bp_Int18:popoutImg"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SELECTAUTOMATIONTWO(By.id("userview:userLists:6:chkUser"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_ERRORPOPUP1(By.id("dhtmlx_message_area"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		/**************AddtoQueue ************/
		UM_ADD_SEARCHPOPUP(By.id("addtoqueue:queuePicklist"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_ADD_SEARCHPROCESS(By.id("QueuePickList:bp:Prefix"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_ADD_SELECTPROCESS(By.id("QueuePickList:bp:dataTable:0:qname"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_ADD_SEARCHBTN(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"QueuePickList:bp:s3\"]/tbody/tr/td/div/input[3]"),By.name(""), By.linkText("")),
		UM_ADD_FILTERYTXT(By.id("addtoqueue:filterText"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_ADD_PERASSIGNMTRADIO(By.id("addtoqueue:selectAssignment:0"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_ADD_TEMPASSIGNMTRADIO(By.id("addtoqueue:selectAssignment:1"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_ADD_DAY(By.id("addtoqueue:comboDate"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_ADD_MONTH(By.id("addtoqueue:comboMonth"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_ADD_YEAR(By.id("addtoqueue:comboYear"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_ADD_ADDBTN(By.id("addtoqueue:adddbut"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_ADD_CLOSEBTN(By.id("addtoqueue:closeBut"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_ADD_ERRORMSG(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"addtoqueue\"]/table[2]/tbody/tr[1]/td/div/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr/td/table/tbody/tr/td[2]/span"),By.name(""), By.linkText("")),
		/**************Set diversions ************/
		UM_SETDIV_SEARCHPOPUP(By.id("setdiversion:userPicklist"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETDIV_FILTERONNAME(By.id("UserPickList:blankpanel:bp:plus"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETDIV_FILTERONNAMEUSERID(By.id("UserPickList:blankpanel:bp:Prefix"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETDIV_FILTERONNAMESEARBTN(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"UserPickList:blankpanel:bp:s1\"]/tbody/tr/td/div/input[3]"),By.name(""), By.linkText("")),
		UM_SETDIV_FILTERONNAMESELECT(By.id("UserPickList:blankpanel:bp:userlisttable:0:userName"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETDIV_FROMDAY(By.id("setdiversion:fromDay"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETDIV_FROMMONTH(By.id("setdiversion:fromMonth"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETDIV_FROMYEAR(By.id("setdiversion:fromYear"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETDIV_TODAY(By.id("setdiversion:toDay"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETDIV_TOMONTH(By.id("setdiversion:toMonth"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETDIV_TOYEAR(By.id("setdiversion:toYear"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETDIV_FROMHOURS(By.id("setdiversion:fromHours"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETDIV_FROMMINS(By.id("setdiversion:fromMinutes"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETDIV_TOHOURS(By.id("setdiversion:toHours"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETDIV_TOMINS(By.id("setdiversion:toMinutes"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETDIV_WORKITEMRADIO(By.id("setdiversion:booleanIncludeCurrentWorkitems"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETDIV_ASSIGNBTN(By.id("setdiversion:assignBut"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETDIV_CLOSEBTN(By.id("setdiversion:closeBut"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		/**************Set work audit ************/
		UM_SETWA_ADDBTN(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"setworkaudit\"]/table[2]/tbody/tr[2]/td/table/tbody/tr/td[2]/input"),By.name(""), By.linkText("")),
		UM_SETWA_SEARCHPOPUPBTB(By.id("addmodifyworkaudit:processPicklist"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETWA_SEARCHPROCESS(By.id("ProcessPickList:bp:Prefix"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETWA_SEARCHPROCESSBTN(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"ProcessPickList:bp:s3\"]/tbody/tr/td/div/input[3]"),By.name(""), By.linkText("")),
		UM_SETWA_SELECTPROCESS(By.id("ProcessPickList:bp:j_idt40:0:pname"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETWA_WRKSTPPOPUPBTB(By.id("addmodifyworkaudit:activityPicklist"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETWA_SEARCHWRKSTP(By.id("WorkStepPickList:bp:Prefix"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETWA_SEARCHWRKSTPBTN(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"WorkStepPickList:bp:s3\"]/tbody/tr/td/div/input[3]"),By.name(""), By.linkText("")),
		UM_SETWA_SELECTWRKSTP(By.id(""),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETWA_WRKSTPCLOSEBTN(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"WorkStepPickList:bp:bluepanel\"]/tbody/tr/td[3]/span"),By.name(""), By.linkText("")),
		UM_SETWA_ANPOPUPBTB(By.id("addmodifyworkaudit:userPicklist"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETWA_ANFLTONNAME(By.id("UserPickList:blankpanel:bp:plus"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETWA_ANFLTONNAMEUSERID(By.id("UserPickList:blankpanel:bp:Prefix"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETWA_ANFLTONNAMESEARBTN(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"UserPickList:blankpanel:bp:s1\"]/tbody/tr/td/div/input[3]"),By.name(""), By.linkText("")),
		UM_SETWA_ANFLTONNAMESELECTVALUE(By.id("UserPickList:blankpanel:bp:userlisttable:0:userName"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETWA_PERCENTAGEAUDIT(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"addmodifyworkaudit\"]/div/table/tbody/tr[10]/td/table/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/select"),By.name(""), By.linkText("")),
		UM_SETWA_SETAUDIT_ADDBTN(By.id("addmodifyworkaudit:addbut"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETWA_SETAUDIT_CLOSEBTN(By.id("addmodifyworkaudit:adddonebut"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		UM_SETWA_CLOSEBTN(By.id("setworkaudit:closeBut"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		/**************Work audit detAILS ************/
		UM_WADETAILS_CLOSEBTN(By.id("viewworkaudithistory:closeBut"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
/*----------------------------------------------------------Rights management page----------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
		RM_POPUPBTN(By.id("blankp1:bp_Int34:popoutImg"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		/**************Profiles ************/
		RM_PRFL_PROPTAB(By.id("profile:lblProperiesTab"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_PRFL_SEARCHPROFILETXT(By.id("profilemgmt:Prefix"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_PRFL_SEARCHPROFILEBTN(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"profilemgmt:s1\"]/tbody/tr/td/div/input[3]"),By.name(""), By.linkText("")),
		RM_PRFL_SElECTPROFILE(By.id("profilemgmt:profilelist:0:profilechkBox"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_PRFL_ADDBTN(By.id("profilemgmt:BtnAdd"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_PRFL_PROFILEASSOCIATION(By.id(""),By.cssSelector(""),By.xpath(""),By.name("//*[@id=\"profilemgmt:tab9\"]/table/tbody/tr/td[1]/label"), By.linkText("")),
		RM_PRFL_MGPWDPOLICY(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"profilemgmt:tab10\"]/table/tbody/tr/td[1]/label"),By.name(""), By.linkText("")),
		RM_PRFL_CABINETPROP(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"profilemgmt:tab11\"]/table/tbody/tr/td/label"),By.name(""), By.linkText("")),
		RM_PRFL_PRFLNAME(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"profile:grid1\"]/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[1]/td[2]/input"),By.name(""), By.linkText("")),
		RM_PRFL_PRFLDESC(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"profile:grid1\"]/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td[2]/textarea"),By.name(""), By.linkText("")),
		RM_PRFL_OBJECTTYPEPOPUPBTN(By.id("profile:cmdPicklist_ObjectType"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_PRFL_OBJECTTYPESELECT(By.id("profile:picklistPanel:bp:dataTable:1:objectTypeName"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_PRFL_SELECTGENREPORT(By.id("profile:rightList:0:rightCheck"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_PRFL_ADDEDOBJECT(By.id("profile:objectListSelected:0:objlistchk"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_PRFL_PRFLADDBTN(By.id("profile:cmdAdd"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_PRFL_PRFLSAVEBTN(By.id("profile:btnSaveProfile"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_PRFL_UGROLES(By.id("profile:lblUGRTab"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_PRFL_UNAMERADIO(By.id("profile:userselectRadio:1"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_PRFL_UNAMERADIOSEARCH(By.id("profile:userPrefix"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_PRFL_UNAMERADIOSEARCHBTN(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"profile:users1\"]/tbody/tr/td/div/input[3]"),By.name(""), By.linkText("")),
		RM_PRFL_ERRORMSG1(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"userlistDiv\"]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[2]/span"),By.name(""), By.linkText("")),
		RM_PRFL_ADDSUCCESSPOPUP(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"AddSuccessDiv\"]/div/div/div/div/div/div/div/div/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[2]/input"),By.name(""), By.linkText("")),
		RM_PRFL_SAVEPRFLBTN(By.id("profile:btnSaveProfile"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),														 
		RM_PRFL_DELETEBTN(By.id("profilemgmt:cmddeleteenable"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_PRFL_DELETECONFIRMYES(By.id("profilemgmt:panelfordelete:confirmdelete1"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
	
		/**************USER TAB *************/
		RM_USERTAB(By.id("profilemgmt:j_idt40"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_SEARCHUSERTXT(By.id("profilemgmt:Prefix"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_SEARCHUSERBTN(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"profilemgmt:s1\"]/tbody/tr/td/div/input[3]"),By.name(""), By.linkText("")),
		RM_USER_SELECTUSER(By.id("profilemgmt:userlist:0:chkUser"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_ADD(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"profilemgmt:tab5\"]/table/tbody/tr/td[1]/label"),By.name(""), By.linkText("")),
														
		RM_USER_USRNAME(By.id("usermgmt:txtUserName"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_DOMAINUSERCHKBOX(By.id("usermgmt:domainUserChk"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_COMMENTS(By.id("usermgmt:txtcomments"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_FNAME(By.id("usermgmt:txtPersonalName"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_LNAME(By.id("usermgmt:txtFamilyName"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_EMAILID(By.id("usermgmt:txtEmailId"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_MBLNBR(By.id("usermgmt:txtPhoneNumber"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_EXPDAY(By.id("usermgmt:comboDate"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_EXPMTH(By.id("usermgmt:comboMonth"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_EXPYR(By.id("usermgmt:comboYear"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_PARNTGRPPOPUP(By.id("usermgmt:parentgrouppicklist"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_PARNTGRPSEARCH(By.id("GroupPickList:blankpanel:bp:PGPrefix"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_PARNTGRPSEARBTN(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"GroupPickList:blankpanel:bp:PGs1\"]/tbody/tr/td/div/input[3]"),By.name(""), By.linkText("")),
		RM_USER_PARNTGRPSELECT(By.id("GroupPickList:blankpanel:bp:dataTable:0:qname"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_PWD(By.id("usermgmt:txtPassword"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_CNFMPWD(By.id("usermgmt:txtConfirmPassword"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_PRFLTAB(By.id("usermgmt:tab2A"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_PRFL_SEARCHPRFL(By.id("usermgmt:PPPrefix"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_PRFL_SEARCHPRFLBTN(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"usermgmt:PPs1\"]/tbody/tr/td/div/input[3]"),By.name(""), By.linkText("")),
		RM_USER_PRFL_PMASSGNMT(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"usermgmt:typeselectRadio:0\"]"),By.name(""), By.linkText("")),
		RM_USER_PRFL_ASSGNMTTILLDATE(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"usermgmt:typeselectRadio:0\"]"),By.name(""), By.linkText("")),
		RM_USER_PRFL_PMASSGNMTDATEPOPUP(By.id("usermgmt:FieldBrowseDataBtn1"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_SAVEBTN(By.id(""),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		
		RM_USER_ORTAB(By.id("usermgmt:tab3A"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_ORSEARCHPOPUP(By.id("usermgmt:cmdPicklist_ObjectType"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_ORSELECTVALUE(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"dataRow\"]"),By.name(""), By.linkText("")),
		RM_USER_ORSELECTGENREPORT(By.id("usermgmt:rightList:0:rightCheck"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_ORADDBTN(By.id("usermgmt:cmdAdd"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_ORSAVEBTN(By.id(""),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_ORCLOSEBTN(By.id("usermgmt:cmdCancel"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_DELETEUSER(By.id("profilemgmt:cmddeleteenableU1"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_USER_DELETEPOPUPNO(By.id("profilemgmt:panelfordelete:cmdNo"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		/**************GROUP TAB *************/
		RM_GRPTAB(By.id("profilemgmt:j_idt43"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPTAB_SEARCHGRPTXT(By.id("profilemgmt:Prefix"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPTAB_SEARCHGRPBTN(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"profilemgmt:s1\"]/tbody/tr/td/div/input[3]"),By.name(""), By.linkText("")),
		RM_GRPTAB_SELECTGRP(By.id("profilemgmt:grouplist:0:chkGroup"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPTAB_ADD(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"profilemgmt:tab5\"]/table/tbody/tr/td[1]/label"),By.name(""), By.linkText("")),
		RM_GRPADD_GRPNAME(By.id("groupmgmt:txtGroupName"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPADD_OWNERSEARCHPOPUP(By.id("groupmgmt:cmdPicklist_Group"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPADD_OWNERFILTERONNAME(By.id("UserPickList:blankpanel:bp:plus"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPADD_OWNERFILERONUSERNAME(By.id("UserPickList:blankpanel:bp:selectRadio:0"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPADD_OWNERFILTERONSEARCHUSER(By.id("UserPickList:blankpanel:bp:Prefix"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPADD_OWNERFILTERONSEARCHUSER_BTN(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"UserPickList:blankpanel:bp:s1\"]/tbody/tr/td/div/input[3]"),By.name(""), By.linkText("")),
		RM_GRPADD_OWNERFILTERONSELECTVALUE(By.id("UserPickList:blankpanel:bp:userlisttable:0:userName"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPADD_PARENTGROUPSEARCHPOPUP(By.id("groupmgmt:parentgrouppicklist"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPADD_PARENTGROUPSEARCHUSERTXT(By.id("GroupPickList:blankpanel:bp:PGPrefix"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPADD_PARENTGROUPSEARCHUSERTXT_BTN(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"GroupPickList:blankpanel:bp:PGs1\"]/tbody/tr/td/div/input[3]"),By.name(""), By.linkText("")),
		RM_GRPADD_PARENTGROUPSELECTUSER(By.id("GroupPickList:blankpanel:bp:dataTable:0:qname"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPADD_COMMENTS(By.id("groupmgmt:txtcomments"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPADD_USERNAMERADIO(By.id("groupmgmt:optGroup:1"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPADD_USERIDRADIO(By.id("groupmgmt:optGroup:0"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPADD_SEARCHUSERID(By.id("groupmgmt:PUPrefix"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPADD_SEARCHUSERIDBTN(By.id(""),By.cssSelector(""),By.xpath("//*[@id=\"groupmgmt:PUs1\"]/tbody/tr/td/div/input[3]"),By.name(""), By.linkText("")),
		RM_GRPADD_SELECTUSER(By.id("groupmgmt:groupuserlist:0:userlistchkBox"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPADD_USERADDBTN(By.id("groupmgmt:cmdAddUser"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		
		RM_GRPADDP_PRFLTAB(By.id("groupmgmt:tab2A"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPADD_PRFL_SEARCHPRFLTXT(By.id("groupmgmt:PPPrefix"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPADD_PRFL_SEARCHPRFLBTN(By.id("//*[@id=\"groupmgmt:PPs1\"]/tbody/tr/td/div/input[3]"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPADD_PRFL_SELECTPFRL(By.id("groupmgmt:groupmgmprofilelist:0:profilelistchkBox"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPADD_PRFL_ASSGNMTTILLDATE(By.id("groupmgmt:typeselectRadio:1"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPADD_PRFL_ADD(By.id("groupmgmt:cmdAddProfile"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		
		
		
		RM_GRPADD_ORTAB(By.id("groupmgmt:tab3A"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPADD_OR_OBJTYPEPOPUP(By.id("groupmgmt:cmdPicklist_ObjectType"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPADD_OR_SELECTOBJTYPE(By.id("groupmgmt:picklistPanel:bp:dataTable:0:objectTypeName"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPADD_OR_CHECKALL(By.id("groupmgmt:checkAllRights"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPADD_OR_UNCHECKALL(By.id("groupmgmt:uncheckAllRights"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPADD_OR_ADD(By.id("groupmgmt:cmdAdd"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		RM_GRPADD_OR_CLOSE(By.id("groupmgmt:cmdCancel"),By.cssSelector(""),By.xpath(""),By.name(""), By.linkText("")),
		
		
		
		
		;
	
		
		private  By id;		
		private  By cssPath;
		private  By xPath;
		private  By name;
		private  By linktext;

		private CommonPageObjects(By idLoc, By cssPathLoc, By xPathLoc, By nameObj,By linkText) {
			id = idLoc;
			cssPath = cssPathLoc;
			xPath = xPathLoc;
			name = nameObj;
			linktext=linkText;
		}

		public By getId() {
			return id;
		}

		public By getCssPath() {
			return cssPath;
		}

		public By getXPath() {
			return xPath;
		}

		public By getLabel() {
			return name;
		}

		public By byLocator() {
			
			if(id.equals(By.id(""))){
				if(cssPath.equals(By.cssSelector(""))){
					if(name.equals(By.name(""))){
						if(linktext.equals(By.linkText("")))
							return(xPath);
						else
							return linktext;
					}else{
						return(name);
					}
				}else{
					return(cssPath);
				}
			}else{
				return(id);
			}
		}
	}		
}
