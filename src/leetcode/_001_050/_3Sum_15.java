package leetcode._001_050;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class _3Sum_15 {
	List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
    	if (nums.length < 3) return result;
    	Arrays.sort(nums);
    	int len = nums.length;
        for (int i = 0; i < len-2; i++) {
        	if (i > 0 && nums[i] == nums[i-1]) continue;
        	find(nums, i+1, len-1, nums[i]); 
        }
    	return result;
    }
    public void find(int[] num, int begin, int end, int target) {
        int l = begin, r = end;
        while (l < r) {
            if (num[l] + num[r] + target == 0) {
                List<Integer> ans = new ArrayList<Integer>();
                ans.add(target);
                ans.add(num[l]);
                ans.add(num[r]);
                result.add(ans); //放入结果集中
                while (l < r && num[l] == num[l+1]) l++;
                while (l < r && num[r] == num[r-1]) r--;
                l++;
                r--;
            } else if (num[l] + num[r] + target < 0) {
                l++;
            } else {
                r--;
            }
        }
    }
}
