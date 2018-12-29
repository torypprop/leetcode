package leetcode._001_050;
//import java.util.ArrayList;
import java.util.Arrays;
//import java.util.List;

public class _3SumClosest_16 {
	
    public int threeSumClosest(int[] nums, int target) {
    	int result = 0;
    	int closestDist = Integer.MAX_VALUE;
    	if (nums.length < 3) return result;
    	Arrays.sort(nums);
    	int len = nums.length;
        for (int i = 0; i < len-2; i++) {
        	if (i > 0 && nums[i] == nums[i-1]) continue;
        	 
            int l = i+1, r = len-1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < target) {
                    if (target-sum < closestDist) {
                        closestDist = target - sum;
                        result = sum;
                    }
                    l++;
                } else if (sum > target) {
                    if (sum-target < closestDist) {
                        closestDist = sum - target;
                        result = sum;
                    }
                    r--;
                } else { //when sum == target, return sum.
                    return sum;
                }
            }
        }
        
        return result;
    }
}
