package leetcode._001_050;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {
	List<String> ret;
    public List<String> generateParenthesis(int n) {
    	ret = new ArrayList<>();
    	char[] s = new char[n*2];
    	func2(s,0,0);
    	return ret;
    }
    void func2(char[] s, int pos, int num) {
    	if (pos == s.length) {
    		if (num == 0) {
    			ret.add(new String(s));
    		}
    	} else {
    		s[pos] = '(';
    		func2(s,pos+1,num+1);
    		if(num>0) {
        		s[pos] = ')';
    			func2(s,pos+1,num-1);
    		}
    	}
    }
}
