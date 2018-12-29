package leetcode._001_050;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber_17 {
    List<String> ret;
    char[] s1;
	
    public List<String> letterCombinations(String digits) {
    	ret = new ArrayList<>();
    	s1 = new char[digits.length()];
    	func2(digits, 0);
        return ret;
    }
    
    void func2(String digits, int pos) {
        String[] mapping = {"abc", "def", "ghi", "jkl", "mno", "pqrs","tuv", "wxyz"};
        if (digits.equals(""))
        	return;
    	if (pos == digits.length()) {
    		ret.add(new String(s1));
    	} else {
    		char c1 = digits.charAt(pos);
    		char[] s = mapping[c1-'2'].toCharArray();
    		for (char c2: s) {
    			s1[pos] = c2;
    			func2(digits, pos+1);
    		}
    	}
    }
    
    public static void main(String[] args) {
    	LetterCombinationsOfAPhoneNumber_17 o = new LetterCombinationsOfAPhoneNumber_17();
    	System.out.println(o.letterCombinations(""));
    	System.out.println(o.letterCombinations("1"));
    	System.out.println(o.letterCombinations("12"));
    	System.out.println(o.letterCombinations("123"));
    	

    	System.out.println(o.letterCombinations("8"));
    }
}
