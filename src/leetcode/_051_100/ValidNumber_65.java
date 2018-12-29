package leetcode._051_100;

public class ValidNumber_65 {

    public boolean isNumber(String s) {
    	int from = 0;
    	while(from < s.length() && s.charAt(from) == ' ') from++;
    	if(from == s.length()) {
    		return false;
    	}
    	int to = s.length();
    	while(s.charAt(to-1) == ' ') to--;
    	s = s.substring(from, to);
    	if(s.isEmpty()) {
    		return false;
    	}
    	int index = s.indexOf('e');
    	if(index < 0) {
    		if(isNumber2(s)) {
    			return true;
    		} else {
    			return false;
    		}
    	} else {
    		String s1 = s.substring(0, index);
    		String s2 = s.substring(index+1);
    		if(!s2.isEmpty() && (s2.charAt(0) == '-' || s2.charAt(0) == '+')) {
    			s2 = s2.substring(1);
    		}
    		if(isNumber2(s1) && isNumber3(s2)) {
    			return true;
    		} else {
    			return false;
    		}
    	}
    }

	private boolean isNumber2(String s) {
    	if(s.isEmpty()) {
    		return false;
    	}
		if(s.charAt(0) == '-' || s.charAt(0) == '+') {
			s = s.substring(1);
		}
    	int index = s.indexOf('.');
    	if(index < 0) {
    		if(isNumber3(s)) {
    			return true;
    		} else {
    			return false;
    		}
    	} else {
    		String s1 = s.substring(0, index);
    		String s2 = s.substring(index+1);
    		if(s1.isEmpty() && s2.isEmpty()) {
    			return false;
    		} else if((isNumber3(s1) || s1.isEmpty()) && (isNumber3(s2) || s2.isEmpty())) {
    			return true;
    		} else {
    			return false;
    		}
    	}
	}

	private boolean isNumber3(String s) {
		if(s.length() == 0) {
			return false;
		}
		for(char c: s.toCharArray()) {
			if(c > '9' || c < '0') {
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		ValidNumber_65 demo = new ValidNumber_65();
		System.out.println(demo.isNumber(" "));
	}
}
