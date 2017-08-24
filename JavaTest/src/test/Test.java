package test;


public class Test {
	
	public static String all(String toRepeat, int length) {
	    return repeatString(toRepeat, length);
	}
	
	public static String repeatString(String strSource, int numTimes) {
	    // If strSource is null then simply return strSource
	    int len = length(strSource);

	    if (len == 0) {
	      return strSource;
	    }

	    if (numTimes == 0) {
	      return "";
	    }

	    if (numTimes == 1) {
	      return strSource;
	    }

	    StringBuffer strToReturn = new StringBuffer(numTimes * len);

	    for (int i = 0; i < numTimes; ++i) {
	      strToReturn.append(strSource);
	    }

	    return strToReturn.toString();
	  }
	
	public static int length(String strSource) {
	    return (strSource == null) ? 0 : strSource.length();
	  }
	

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder(all(" ", 20));
		System.out.println(sb.replace(19, 20, "A"));
	}
}

