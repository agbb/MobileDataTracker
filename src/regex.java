import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {

	private static Pattern p;
	private static Globals data;
	public static void createRegex(Globals data){
		regex.data = data;

	    String re1=".*?";	// Non-greedy match on filler
	    String re2="([+-]?\\d*\\.?\\d+)(?![-+0-9\\.])";	// Float 1
	    String re3="((?:[a-z][a-z]+))";	// Word 1
	    String re4=".*?";	// Non-greedy match on filler
	    String re5="(\\d+)";	// Integer Number 1
	    String re6="((?:[a-z][a-z]+))";	// Word 2
	    String re7=".*?";	// Non-greedy match on filler
	    String re8="(\\d+)";	// Integer Number 2

	    p = Pattern.compile(re1+re2+re3+re4+re5+re6+re7+re8,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	}
	
	public static void regexSort(String input){
		System.out.println("input received "+input);
	    Matcher m = p.matcher(input);
	    if (m.find())
	    {
	        String dataLeft=m.group(1);
	        String dataLeftunit=m.group(2);
	        String totalData=m.group(3);
	        String totalDataUnit=m.group(4);
	        String daysLeft=m.group(5);
	        
	        data.updateLiveData(Float.parseFloat(totalData), Float.parseFloat(dataLeft), Integer.parseInt(daysLeft), totalDataUnit, dataLeftunit);
	        
	    }
	  }
}
