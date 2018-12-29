package leetcode._001_050;

public class SearchforARange_34 {

    public int[] searchRange(int[] nums, int target) {
        int minPos = searchMinPos(nums, target);
        if(minPos == -1) {
        	return new int[]{-1,-1};
        } else {
        	int maxPos = searchMaxPos(nums, target);
        	return new int[] {minPos, maxPos};
        }
    }
    

    private int searchMinPos(int[] nums, int target) {
    	if(nums.length == 0) return -1;
    	int left = 0;
    	int right = nums.length-1;
    	int mid = 0;
    	while(left <= right) {
    		if(left == right || left+1 == right) {
    			if(nums[left] == target) return left;
    			if(nums[right] == target) return right;
    			return -1;
    		}
    		mid = (left + right)/2;
    		if(target > nums[mid]) {
    			left = mid+1;
    		} else if(target < nums[mid]) {
    			right = mid-1;
    		} else {
    			right = mid;
    		}
    	}
    	return -1;
    }
    
    private int searchMaxPos(int[] nums, int target) {
    	if(nums.length == 0) return -1;
    	int left = 0;
    	int right = nums.length-1;
    	int mid = 0;
    	while(left <= right) {
    		if(left == right || left+1 == right) {
    			if(nums[right] == target) return right;
    			if(nums[left] == target) return left;
    			return -1;
    		}
    		mid = (left + right)/2;
    		if(target > nums[mid]) {
    			left = mid+1;
    		} else if(target < nums[mid]) {
    			right = mid-1;
    		} else {
    			left = mid;
    		}
    	}
    	return -1;
    }
    
   
}
