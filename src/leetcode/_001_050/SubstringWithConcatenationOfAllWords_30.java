package leetcode._001_050;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords_30 {
	
    public List<Integer> findSubstring(String s, String[] words) {
    	List<Integer> ret = new ArrayList<>();
    	if (words.length == 0 || s.length() == 0 || words[0].length() == 0)
    		return ret;
    	Map<String, Integer> map = new HashMap<>();
    	for (String word: words) {
    		if (map.containsKey(word)) {
    			int num = map.get(word);
    			map.put(word, num+1);
    		} else {
    			map.put(word, 1);
    		}
    	}
//    	for (String key: map.keySet()) {
//    		System.out.println("key:" + key + ";value:" + map.get(key));
//    	}
    	int len1 = words.length;
    	int len2 = words[0].length();
    	Map<String, Integer> map2 = new HashMap<>();
    	for (int k = 0; k < len2; k++) {
    		map2.clear();
    		int pos = k;
    		for (int i = k; i + len2 <= s.length(); i += len2) {
    			String w = s.substring(i, i + len2);
    			//不是words的单词
    			if (!map.containsKey(w)) {
    				map2.clear();
    				pos = i + len2;
    				continue;
    			} 
    			if (!map2.containsKey(w)) {
    				map2.put(w, 0);
    			} 
				int num1 = map.get(w);
				int num2 = map2.get(w);
    			String w2 = s.substring(pos, pos + len2);
    			if (num1 > num2) {
    				map2.put(w, num2+1);
    				if (i - pos == (len1 - 1) * len2) {
    					ret.add(pos);
    					map2.remove(w2);
    					pos += len2;
    				}
    			} else {
	    			while (pos < i && !w2.equals(w)) {
	    				map2.remove(w2);
	    				pos += len2;
	    				w2 = s.substring(pos, pos + len2);
	    			}
	    			pos += len2;
    			}
    		}
    	}
    	
    	return ret;
    }

	public static void main(String[] args) {
		SubstringWithConcatenationOfAllWords_30 o = new SubstringWithConcatenationOfAllWords_30();
//		System.out.println(o.findSubstring("", new String[]{"a", "b", "a"}));
		System.out.println(o.findSubstring("aaa", new String[]{"aa"}));
		System.out.println(o.findSubstring("aab", new String[]{"a", "b", "a"}));
		System.out.println(o.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
	}

}
