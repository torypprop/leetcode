package leetcode._001_050;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters_3 {

//    public int lengthOfLongestSubstring(String s) {
//        int maxLength = 0;
//        char[] chs = s.toCharArray();
//        HashSet<Character> set = new HashSet<>();
//        for (int i = 0, j = 0; i < chs.length; i++) {
//        	if(set.contains(chs[i])) {
//        		if(set.size() > maxLength) {
//        			maxLength = set.size();
//        		}
//        		while(chs[i] != chs[j]){
//        			set.remove(chs[j]);       			
//        			j++;
//        		}
//        		j += 1;
//        	} else {
//        		set.add(chs[i]);
//        	}
//        }
//		if(set.size() > maxLength) {
//			maxLength = set.size();
//		}
//        return maxLength;
//    }
    

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
        	if(set.contains(s.charAt(i))) {
        		if(set.size() > maxLength) {
        			maxLength = set.size();
        		}
        		while(s.charAt(i) != s.charAt(j)){
        			set.remove(s.charAt(j));       			
        			j++;
        		}
        		j += 1;
        	} else {
        		set.add(s.charAt(i));
        	}
        }
		if(set.size() > maxLength) {
			maxLength = set.size();
		}
        return maxLength;
    }
}
