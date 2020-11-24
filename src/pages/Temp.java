package pages;



import java.text.SimpleDateFormat;
import java.util.Date;

public class Temp {

	public static void main(String[] args) {
	
		
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	
		String wsname  = "dccmWorkspace";
		String path = System.getProperty("user.dir");
		int pos = path.indexOf(wsname);
		System.out.println(path.substring(0,pos+wsname.length()));		
	}

}
