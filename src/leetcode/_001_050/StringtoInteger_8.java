package leetcode._001_050;

public class StringtoInteger_8 {
//    public int myAtoi(String str) {
//    	if (str.isEmpty())
//    		return 0;
//    	int result = 0;
//    	int flag = 1;
//    	int pos = 0;
//    	if (str.charAt(pos) == '-') {
//    		flag = -1;
//    		pos ++;
//    		if (str.length() == 1) 
//        		return 0;
//    	} else if (str.charAt(pos) == '+') {
//    		pos ++;
//    		if (str.length() == 1) 
//        		return 0;
//    	}
//    	int rank = 10;
//    	if (str.charAt(pos) == '0') {
//    		pos ++;
//    		if (str.length() == 2) 
//        		return 0;
//    		switch((String)str.subSequence(pos, pos+1)) {
//    		case "b":
//    		case "B":
//    			rank = 2;
//        		pos ++;
//        		break;
//    		case "x":
//    		case "X":
//    			rank = 16;
//        		pos ++;
//        		break;
//        	default:
//    			rank = 8;
//        		break;
//    		}
//    	}
//    	while (pos < str.length()) {
//    		char c = str.charAt(pos);
//    		if (c >= '0' && c <= '9') {
//    			result = result * rank + c - '0';
//    		} else if (c >= 'a' && c <= 'f') {
//    			result = result * rank + c - 'a' + 10;
//    			if (rank != 16)
//    				return 0;
//    		} else if (c >= 'A' && c <= 'F') {
//    			result = result * rank + c - 'A' + 10;
//    			if (rank != 16)
//    				return 0;
//    		} else {
//    			return 0;
//    		}
//    		switch(rank) {
//    		case 2:
//    			if (c != '0' && c != '1')
//    				return 0;
//    		case 8:
//    			if (c > '7' || c < '0')
//    				return 0;
//    		case 10:
//    			if (c > '9' || c < '0')
//    				return 0;
//    		case 16:
//    		}
//    		pos ++;
//    	}
//    	
//        return result * flag;
//    }
	
	
	public int myAtoi(String str) {
		str = str.trim();
    	if (str.isEmpty())
    		return 0;
    	int result = 0;
    	int flag = 1;
    	int pos = 0;
    	if (str.charAt(pos) == '-') {
    		flag = -1;
    		pos ++;
    		if (str.length() == 1) 
        		return 0;
    	} else if (str.charAt(pos) == '+') {
    		pos ++;
    		if (str.length() == 1) 
        		return 0;
    	}
    	while (pos < str.length()) {
    		char c = str.charAt(pos);
			if (c > '9' || c < '0')
				return result * flag;
			if (result > Integer.MAX_VALUE /10)
				return flag==1 ? Integer.MAX_VALUE: Integer.MIN_VALUE;
			else if (result == Integer.MAX_VALUE /10) {
				if (c == '8' || c == '9')
					return flag==1 ? Integer.MAX_VALUE: Integer.MIN_VALUE;
			}
			result = result * 10 + c - '0';
    		pos ++;
    	}
    	
        return result * flag;
    }

	public static void main(String[] args) {
		StringtoInteger_8 a = new StringtoInteger_8();
		System.out.println(a.myAtoi("20"));
		System.out.println(a.myAtoi("-20"));
		System.out.println(a.myAtoi("012"));
		System.out.println(a.myAtoi("0b101"));
		System.out.println(a.myAtoi("0B101"));
		System.out.println(a.myAtoi("0xf1"));
		System.out.println(a.myAtoi("0xF1"));
		System.out.println(a.myAtoi("0Xf1"));
		System.out.println(a.myAtoi("0XF1"));
	}

}
