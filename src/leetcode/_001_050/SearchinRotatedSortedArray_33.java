package leetcode._001_050;

public class SearchinRotatedSortedArray_33 {
	
	
    public int search(int[] nums, int target) {
    	if(nums.length == 0) return -1;
    	if(nums[0] <= nums[nums.length-1]) {
    		return search(nums, target, 0, nums.length-1);
    	} else {
    		int minPos = findMinPos(nums, target);
    		if(nums[0] > target) {
    			return search(nums, target, minPos, nums.length-1);
    		} else {
    			return search(nums, target, 0, minPos-1);
    		}
    	}
    }

    private int findMinPos(int[] nums, int target) {
    	
    	
    	int left = 0;
    	int right = nums.length-1;
    	int mid = 0;
    	while(true) {
    		if(left+1==right) return right;
    		mid = (left+right)/2;
    		if(nums[mid] > nums[left]) {
    			left = mid;
    		} else {
    			right = mid;
    		}
    	}
    }
    
    private int search(int[] nums, int target, int from, int to) {
    	int mid = 0;
    	while(from <= to) {
    		mid = (from+to)/2;
    		if(target == nums[mid]) {
    			return mid;
    		} else if(target < nums[mid]) {
    			to = mid-1;
    		} else {
    			from = mid+1;
    		}
    	}
    	return -1;
    }
}
