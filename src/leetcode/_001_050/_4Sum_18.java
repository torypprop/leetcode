package leetcode._001_050;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _4Sum_18 {
	class pair {
		public pair(int first, int second) {
			super();
			this.first = first;
			this.second = second;
		}
		int first;
		int second;
	}
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> ret = new ArrayList<>();
    	if (nums.length < 4)
    		return ret;
    	Map<Integer, List<pair>> twoSum = new HashMap<>();
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length - 1; i++) {
    		for (int j = i + 1; j < nums.length; j++) {
    			int key = nums[i] + nums[j];
    			if (!twoSum.containsKey(key)) {
    				twoSum.put(key, new ArrayList<>());
    			}
				twoSum.get(key).add(new pair(i,j));
    		}
    	}
    	Set<List<Integer>> set = new HashSet<>();
    	Iterator<Integer> iter = twoSum.keySet().iterator();
    	while (iter.hasNext()) {
    		Integer key = iter.next();
    		if (key > target/2) 
    			continue;
    		if (twoSum.containsKey(target-key)) {
    			for (pair p1: twoSum.get(key)) {
        			for (pair p2: twoSum.get(target-key)) {
        				if (!check(p1, p2))
        					continue;
        				Integer[] l = {nums[p1.first], nums[p1.second], nums[p2.first], nums[p2.second]};
        				Arrays.sort(l);
        				set.add(Arrays.asList(l));  //记住这个转换：Arrays.asList
        			}
    			}
    		}
    	}
    	for (List<Integer> ss: set) {
    		ret.add(ss);
    	}
        return ret;
    }
    boolean check(pair p1, pair p2) {
    	return p1.first != p2.first && p1.first != p2.second
    			&& p1.second != p2.first && p1.second != p2.second;
    }

	public static void main(String[] args) {

	}

}
