package leetcode._001_050;

public class RemoveDuplicatesFromSortedArray_26 {
    public int removeDuplicates(int[] nums) {
    	if (nums.length == 0) 
    		return 0;
        int ret = 1;
        int tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] != tmp) {
        		nums[ret] = nums[i];
        		tmp = nums[ret];
        		ret++;
        	}
        }
        return ret;
    }
}
