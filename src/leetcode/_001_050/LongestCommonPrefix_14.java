package leetcode._001_050;

public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int minLen = Integer.MAX_VALUE;
        for (String str: strs) {
        	if (minLen > str.length()) {
        		minLen = str.length();
        	}
        }
        int i;
        L1:
        for (i = 0; i < minLen; i++) {
        	for (int j = 1; j < strs.length; j++) {
        		if(strs[0].charAt(i) != strs[j].charAt(i)) 
        			break L1;
        	}
        }
        return strs[0].substring(0, i);
    }
}
