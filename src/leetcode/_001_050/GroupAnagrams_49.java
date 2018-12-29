package leetcode._001_050;

import java.util.*;

public class GroupAnagrams_49 {

//    public List<List<String>> groupAnagrams(String[] strs) {
//      HashMap<String, LinkedList<String>> map = new HashMap<>();
//    	for(String s: strs) {
//    		boolean fould = false;
//    		for(java.util.Map.Entry<String, LinkedList<String>> entry: map.entrySet()) {
//    			if(match(s, entry.getKey())) {
//    				entry.getValue().add(s);
//    				fould = true;
//    				break;
//    			}
//    		}
//    		if(!fould) {
//    			LinkedList<String> v = new LinkedList<>();
//    			v.add(s);
//    			map.put(s, v);
//    		}
//    	}
//    	return new LinkedList<List<String>>(map.values());
//    }
	
	public List<List<String>> groupAnagrams(String[] strs) {
		LinkedList<List<String>> result = new LinkedList<>();
		HashMap<Integer, LinkedList<String>> map = new HashMap<>();
		for(String s: strs) {
			int key = hash(s);
			LinkedList<String> v;
			if(map.containsKey(key)) {
				v = map.get(key);
			} else {
				v = new LinkedList<>();
				map.put(key, v);
			}
			v.add(s);
		}
		
//		for(LinkedList<String> list : map.values()) {
//			for(String s: list) {
//				System.out.print(s + " ");
//			}
//			System.out.println();
//		}
		
		for(LinkedList<String> list : map.values()) {
			HashMap<String, LinkedList<String>> map2 = new HashMap<>();
	    	for(String s: list) {
	    		boolean fould = false;
	    		for(java.util.Map.Entry<String, LinkedList<String>> entry: map2.entrySet()) {
	    			if(match(s, entry.getKey())) {
	    				entry.getValue().add(s);
	    				fould = true;
	    				break;
	    			}
	    		}
	    		if(!fould) {
	    			LinkedList<String> v = new LinkedList<>();
	    			v.add(s);
	    			map2.put(s, v);
	    		}
	    	}
	    	result.addAll(map2.values());
		}
		return result;
	}

	private int hash(String s) {
		int h = 0;
		for(char c: s.toCharArray()) {
			h += c*c*c;
		}
		return h;
	}

	private boolean match(String s, String t) {
		HashMap<Character, Integer> map = new HashMap<>();
		for(char c : s.toCharArray()) {
			int num = 0;
			if(map.containsKey(c)) {
				num = map.get(c);
			}
			map.put(c, num+1);
		}
		for(char c : t.toCharArray()) {
			if(!map.containsKey(c)) {
				return false;
			}
			int num = map.get(c);
			num--;
			if(num == 0) {
				map.remove(c);
			} else {
				map.put(c, num);
			}
		}
		return map.isEmpty();
	}
	
	public static void main(String[] args) {
		GroupAnagrams_49 demo = new GroupAnagrams_49();
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> res = demo.groupAnagrams(strs);
		for(List<String> list: res) {
			for(String s :list) {
				System.out.print(s+" ");
			}
			System.out.println();
		}
	}
}
