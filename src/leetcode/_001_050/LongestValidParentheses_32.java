package leetcode._001_050;

import java.util.*;

public class LongestValidParentheses_32 {

    public int longestValidParentheses(String s) {
    	
    	char[] cs = s.toCharArray();
    	int[] len = new int[cs.length]; //pos is from, value is len;
    	ArrayList<Integer> frompos = new ArrayList<>(cs.length);
    	ArrayList<Integer> fromposNext = new ArrayList<>(cs.length);
    	
    	for(int i = 0; i < cs.length-1; i++) {
    		if(cs[i] == '(' && cs[i+1] == ')') {
    			len[i] = 2;
    			frompos.add(i);
    			i++;
    		}
    	}
    	while(true) {
    		if(frompos.isEmpty()) {
    			break;
    		}
    		boolean skip = false;
    		boolean mod = false;
    		for(Integer pos: frompos) {
    			if(skip) {
    				skip = false;
    				continue;
    			}
    			if(pos+len[pos] < cs.length  && len[pos+len[pos]] != 0) {
    				len[pos] += len[pos+len[pos]];
    				fromposNext.add(pos);
    				skip = true;
    				mod = true;
    			} else if(pos > 0 && cs[pos-1] == '(' && pos+len[pos] < cs.length && cs[pos+len[pos]] == ')') {
    				len[pos-1] = len[pos] + 2;
    				fromposNext.add(pos-1);
    				mod = true;
    			} else {
    				fromposNext.add(pos);
    			}
    		}
    		if(!mod) break;
    		ArrayList<Integer> tmp = frompos;
    		frompos = fromposNext;
    		fromposNext = tmp;
    		fromposNext.clear();
    	} 
    	
    	int max = 0;
    	for(int l: len) {
    		if(max < l) max = l;
    	}
        return max;
    }
    
    
    public static void main(String[] args) {
    	LongestValidParentheses_32 demo = new LongestValidParentheses_32();
    	String s = "()(())";
    	System.out.println(demo.longestValidParentheses(s));
    }
}
