package leetcode._051_100;

import java.util.*;

public class SimplifyPath_71 {

    public String simplifyPath(String path) {
        String[] ss = path.split("/");
    	LinkedList<String> stack = new LinkedList<>();
    	for(String s: ss) {
    		if(s.isEmpty() || s.equals(".")) {
    			continue;
    		} else if(s.equals("..")) {
    			if(!stack.isEmpty()) {
    				stack.removeLast();
    			}
    		} else {
    			stack.addLast(s);
    		}
    	}
    	StringBuilder sb = new StringBuilder();
    	for(String s: stack) {
    		sb.append("/").append(s);
    	}
    	String res = sb.toString();
    	if(res.isEmpty()) {
    		res = "/";
    	}
    	return res;
    }
}
