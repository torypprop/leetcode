package leetcode._001_050;

public class ZigZagConversion_6 {
    public String convert(String s, int numRows) {
    	if (numRows == 1) {
    		return s;
    	}
    	StringBuilder result = new StringBuilder();
    	int lenOfCycle = 2 * numRows - 2;
    	for (int pos = 0; pos < s.length(); pos += lenOfCycle) {
    		result.append(s.charAt(pos));
    	}
    	for (int row = 2; row <= numRows - 1; row ++) {
        	for (int pos = row - 1; pos < s.length(); pos += lenOfCycle) {
        		result.append(s.charAt(pos));
        		if (pos + lenOfCycle - row * 2 + 2< s.length()) {
        			result.append(s.charAt(pos + lenOfCycle - row * 2 + 2));
        		}
        	}
    	}
    	for (int pos = numRows - 1; pos < s.length(); pos += lenOfCycle) {
    		result.append(s.charAt(pos));
    	}
        return result.toString();
    }

	public static void main(String[] args) {
		ZigZagConversion_6 a = new ZigZagConversion_6();
		System.out.println(a.convert("abcdefghijklmn", 1));
		System.out.println(a.convert("abcdefghijklmn", 2));
		System.out.println(a.convert("abcdefghijklmn", 3));
		System.out.println(a.convert("abcdefghijklmn", 4));
		System.out.println(a.convert("abcdefghijklmn", 5));
		System.out.println(a.convert("abcdefghijklmn", 6));
		System.out.println(a.convert("abcdefghijklmn", 7));
		System.out.println(a.convert("abcdefghijklmn", 8));
		System.out.println(a.convert("abcdefghijklmn", 9));
		System.out.println(a.convert("abcdefghijklmn", 10));
		System.out.println(a.convert("abcdefghijklmn", 11));
		System.out.println(a.convert("abcdefghijklmn", 12));
		System.out.println(a.convert("abcdefghijklmn", 13));
		System.out.println(a.convert("abcdefghijklmn", 14));
		System.out.println(a.convert("abcdefghijklmn", 15));
		System.out.println(a.convert("abcdefghijklmn", 16));

	}

}
