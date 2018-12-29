package leetcode._001_050;

public class LongestPalindromicSubstring_5 {
    public String longestPalindrome(String s) {
    	if (s.isEmpty()) {
    		return s;
    	}
    	int lenS = s.length();
    	int start = 0;
    	int to = 0;
    	int lenResult = 1;
    	boolean[][] a = new boolean[lenS][lenS];
    	for (int i = 0; i < lenS; i++) {
    		a[i][i] = true;
    	}
    	for (int i = 0; i < lenS - 1; i++) {
    		if (s.charAt(i) == s.charAt(i+1)) {
    			a[i][i+1] = true;
    			if (lenResult != 2) {
    				lenResult = 2;
    				start = i;
    				to = i + 1;
    			}
    		}
    	}
    	for (int lenTemp = 2; lenTemp < lenS; lenTemp ++) {
    		for (int i = 0; i + lenTemp < lenS; i++) {
    			if (a[i+1][i+lenTemp-1] == true && s.charAt(i) == s.charAt(i+lenTemp)) {
    				a[i][i+lenTemp] = true;
        			if (lenResult != lenTemp + 1) {
        				lenResult = lenTemp + 1;
        				start = i;
        				to = i + lenTemp;
        			}
    			}
    		}
    		if (lenResult + 2 < lenTemp) {
    			break;
    		}
    	}
        return s.substring(start, to + 1);
    }
    public static void main(String[] args) {
    	LongestPalindromicSubstring_5 a = new LongestPalindromicSubstring_5();
    	System.out.println(a.longestPalindrome(""));
    	System.out.println(a.longestPalindrome("a"));
    	System.out.println(a.longestPalindrome("ab"));
    	System.out.println(a.longestPalindrome("aa"));
    	System.out.println(a.longestPalindrome("abc"));
    	System.out.println(a.longestPalindrome("abb"));
    	System.out.println(a.longestPalindrome("aba"));
    	System.out.println(a.longestPalindrome("abcd"));
    	System.out.println(a.longestPalindrome("abbc"));
    	System.out.println(a.longestPalindrome("abaa"));
    	System.out.println(a.longestPalindrome("abba"));
    	System.out.println(a.longestPalindrome("abbcdadc"));
    }
}
