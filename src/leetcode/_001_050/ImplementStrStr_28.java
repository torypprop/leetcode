package leetcode._001_050;

public class ImplementStrStr_28 {
    public int strStr(String haystack, String needle) {
    	char[] cs1 = haystack.toCharArray();
    	char[] cs2 = needle.toCharArray();
    	for (int i = 0; i <= cs1.length - cs2.length; i++) {
    		int j;
    		for (j = 0; j < cs2.length; j++) {
    			if (cs1[i+j] != cs2[j]) {
    				break;
    			}
    		}
    		if (j == cs2.length)
    			return i;
    	}
        return -1;
    }
}
