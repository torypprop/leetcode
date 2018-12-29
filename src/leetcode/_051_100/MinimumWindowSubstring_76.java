package leetcode._051_100;

import java.util.*;

public class MinimumWindowSubstring_76 {
	
    public String minWindow(String s, String t) {
    	if(t.isEmpty()) return "";
    	
    	HashMap<Character, Integer> characters = new HashMap<>(t.length()*2);
    	HashMap<Character, Integer> characters2 = new HashMap<>(t.length()*2);
    	HashMap<Character, Integer> map = new HashMap<>(t.length()*2);
    	for(char c: t.toCharArray()) {
    		characters.put(c, 0);
    		characters2.put(c, 0);
    		map.put(c, 0);
    	}
    	for(char c: t.toCharArray()) {
    		characters.put(c, characters.get(c)+1);
    		characters2.put(c, characters2.get(c)+1);
    	}
    	char[] ss = s.toCharArray();
    	int fromPos = 0;
    	int toPos = 0;
    	while(!characters2.isEmpty() && toPos < ss.length) {
    		if(characters2.containsKey(ss[toPos])) {
        		int num = characters2.get(ss[toPos]);
    			num--;
    			if(num == 0) {
    				characters2.remove(ss[toPos]);
    			} else {
    				characters2.put(ss[toPos], num);
    			}
    		}
    		if(map.containsKey(ss[toPos])) {
    			map.put(ss[toPos], map.get(ss[toPos])+1);
    		}
    		toPos++;
    	}
    	if(!characters2.isEmpty()) {
    		return "";
    	}
    	int minLen = toPos - fromPos;
    	String result = s.substring(fromPos, toPos);
    	//System.out.println(result);
    	while(true) {
    		while(fromPos < toPos) {
    			if(map.containsKey(ss[fromPos])) {
    				int num = map.get(ss[fromPos]);
    				if(num == characters.get(ss[fromPos])) {
				    	//System.out.println(result);
    					if(toPos - fromPos < minLen) {
    						minLen = toPos - fromPos;
    						result = s.substring(fromPos, toPos);
    					}
						break;
    				} else {
    					map.put(ss[fromPos], num-1);
    				}
    			}
    			fromPos++;
    		}
    		if(toPos == ss.length) {
    			break;
    		}
    		while(toPos < ss.length) {
    			if(map.containsKey(ss[toPos])) {
    				map.put(ss[toPos], map.get(ss[toPos])+1);
    				toPos++;
    				break;
    			}
    			toPos++;
    		}
    	}
    	//System.out.println(fromPos + " " + toPos);
    	System.out.println(result);
        return result;
    }
    
    public static void main(String[] args) {
    	MinimumWindowSubstring_76 demo = new MinimumWindowSubstring_76();
    	demo.minWindow("ADOBECODEBANC", "ABC");
    	demo.minWindow("aa", "aa");
	}
    
    
}
