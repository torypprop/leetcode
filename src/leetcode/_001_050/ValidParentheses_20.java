package leetcode._001_050;

import java.util.LinkedList;

public class ValidParentheses_20 {
    public boolean isValid(String s) {
    	char[] cs = s.toCharArray();
		char c; 
		LinkedList<Character> stk = new LinkedList<>();
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] == '(' || cs[i] == '[' || cs[i] == '{') {
				stk.addFirst(cs[i]);
			} else if (cs[i] == ')') {
				if (stk.isEmpty())
					return false;
				c = stk.removeFirst();
				if ( c != '(')
					return false;
			} else if (cs[i] == ']') {
				if (stk.isEmpty())
					return false;
				c = stk.removeFirst();
				if ( c != '[')
					return false;
			} else if (cs[i] == '}') {
				if (stk.isEmpty())
					return false;
				c = stk.removeFirst();
				if ( c != '{')
					return false;
			}
		}
        return stk.isEmpty();
    }
}
