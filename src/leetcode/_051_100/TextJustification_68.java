package leetcode._051_100;

import java.util.*;

public class TextJustification_68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
    	int from = 0;
    	int len = words[0].length();
    	int konggeshu = 0;
    	List<String> result = new LinkedList<>();
    	for(int i = 1; i < words.length; i++) {
    		if(len + konggeshu + 1 + words[i].length() > maxWidth) {
    			if(konggeshu == 0) {
	    			StringBuilder sb = new StringBuilder();
	    			sb.append(words[from]);
	    			len = maxWidth - len;
	    			for(int j = 0; j < len; j++) {
	    				sb.append(" ");
	    			}
	    			result.add(sb.toString());
    			} else {
	    			int konggejiange = (maxWidth - len) / konggeshu;
	    			int num = maxWidth - len - konggejiange*konggeshu;
	    			StringBuilder sb = new StringBuilder();
	    			sb.append(words[from]);
	    			for(int j = from+1; j < i; j++) {
	    				for(int k = 0; k < konggejiange; k++) {
	    					sb.append(" ");
	    				}
	    				if(num > 0) {
	    					sb.append(" ");
	        				num--;
	    				}
	    				sb.append(words[j]);
	    			}
	    			result.add(sb.toString());
    			}
    			from = i;
    			len = words[i].length();
    			konggeshu = 0;
    		} else {
    			len += words[i].length();
    			konggeshu++;
    		}
    	}
		StringBuilder sb = new StringBuilder();
		sb.append(words[from]);
		for(int j = from+1; j < words.length; j++) {
			sb.append(" ");
			sb.append(words[j]);
		}
		len = maxWidth - len - konggeshu;
		for(int j = 0; j < len; j++) {
			sb.append(" ");
		}
		result.add(sb.toString());
        return result;
    }
    
    public static void main(String[] args) {
    	TextJustification_68 demo = new TextJustification_68();
    	String[] words1 = {"This", "is", "an", "example", "of", "text", "justification."};
    	List<String> result1 = demo.fullJustify(words1, 16);
    	for(String s: result1) {
    		System.out.println("\""+s+"\"");
    	}
    	System.out.println();
    	String[] words2 = {"What","must","be","acknowledgment","shall","be"};
    	List<String> result2 = demo.fullJustify(words2, 16);
    	for(String s: result2) {
    		System.out.println("\""+s+"\"");
    	}
    	System.out.println();
    	String[] words3 = {"Science","is","what","we","understand","well","enough","to","explain",
    	         "to","a","computer.","Art","is","everything","else","we","do"};
    	List<String> result3 = demo.fullJustify(words3, 20);
    	for(String s: result3) {
    		System.out.println("\""+s+"\"");
    	}
	}
    
    
}
