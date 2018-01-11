package generic;
import java.text.SimpleDateFormat;
public class DateFormatModify {
	public static void main(String[] args) {
		java.util.Date d=new java.util.Date();
		System.out.println(d);
		SimpleDateFormat s=new SimpleDateFormat("dd-MMM-yy    hh-mm-ss");
		String strDate=s.format(d);
		System.out.println(strDate);
	}
}
