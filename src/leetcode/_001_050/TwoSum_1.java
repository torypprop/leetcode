package leetcode._001_050;


import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;


public class TwoSum_1 {

    public int[] twoSum1(int[] nums, int target) {
    	int[] result = new int[2];
    	int i = 0;
    	int j = 0;
    	outterLoop: for(i = 0; i < nums.length - 1; i++) {
            for(j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    break outterLoop;
                }
            }
        }
        result[0] = i;
        result[1] = j;
        return result;
    }
    
    public int[] twoSum(int[] nums, int target) {
    	Map<Integer, Integer> map = new HashMap<>();
    	Map<Integer, Integer> map2 = new HashMap<>();
    	for (int i = 0; i < nums.length; i++) {
    		if(map.containsKey(nums[i])) {
    			map2.put(nums[i], i);
    		} else {
    			map.put(nums[i], i);
    		}
    	}
    	Arrays.sort(nums);
    	int[] result = new int[2];
    	int i = 0;
    	int j = nums.length - 1;
    	while (i < j) {
    		if (nums[i] + nums[j] == target) 
    			break;
    		else if (nums[i] + nums[j] < target) {
    			i ++;
    		} else {
    			j --;
    		}
    	}
        result[0] = map.get(nums[i]);
        if (nums[i] == nums[j]) {
            result[1] = map2.get(nums[j]);
        } else {
            result[1] = map.get(nums[j]);
        }
        return result;
    }

}
