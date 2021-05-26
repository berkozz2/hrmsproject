package hrmsproject.hrms.microService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FakeService {
	public static boolean mernisCheck(String TCNO) {
	
	String regex = "^[1-9]{1}[0-9]{9}[02468]{1}$";
	Pattern pattern = Pattern.compile(regex);
	Matcher matcher = pattern.matcher(TCNO);
	 
	if(TCNO.length()==11) {
		return true;
	}
	else if (matcher.matches() && !TCNO.startsWith("0")) {
		return true;
	}
	else {
		return false;
	}
	
	}
}
