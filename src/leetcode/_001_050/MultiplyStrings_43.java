package leetcode._001_050;


public class MultiplyStrings_43 {

    public String multiply(String num1, String num2) {
    	if(num1.length() <= 9 && num2.length() <= 9) {
    		return Long.toString(Long.parseLong(num1) * Long.parseLong(num2));
    	}
    	if(num1.length() > 9) {
    		int len = num1.length();
    		int len1 = len/2;
    		int len2 = len - len1;
    		String num11 = num1.substring(0, len1);
    		String num12 = num1.substring(len1);
    		String res1 = multiply(num11, num2);
    		String res2 = multiply(num12, num2);
    		StringBuilder sb = new StringBuilder(res1);
    		for(int i = 0; i < len2; i++) {
    			sb.append('0');
    		}
    		return add(sb.toString(), res2);
    	} 
        return multiply(num2, num1);
    }

	private String add(String num1, String num2) {
		char[] cs1 = num1.toCharArray();
		char[] cs2 = num2.toCharArray();
		int len = cs1.length > cs2.length ? cs1.length : cs2.length;
		len++;
		char[] result = new char[len]; 
		int pos1 = cs1.length-1;
		int pos2 = cs2.length-1;
		int pos = result.length-1;
		int jinwei = 0;
		while(pos1 >= 0 || pos1 >= 0) {
			int num = jinwei;
			jinwei = 0;
			if(pos1 >= 0) {
				num += (cs1[pos1]-'0');
				pos1--;
			}
			if(pos2 >= 0) {
				num += (cs2[pos2]-'0');
				pos2--;
			}
			if(num >= 10) {
				num -= 10;
				jinwei = 1;
			}
			result[pos--] = (char)(num + '0');
		}
		if(result[0] == 0) {
			return new String(result, 1, len-1);
		} else {
			return new String(result);
		}
	}
}
