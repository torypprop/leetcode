package leetcode._001_050;

public class SearchInsertPosition_35 {

    public int searchInsert(int[] nums, int target) {
    	
    	int left = 0;
    	int right = nums.length-1;
    	int mid = 0;
    	while(left <= right) {
    		mid = (left+right)/2;
    		if(target == nums[mid]) return mid;
    		if(target < nums[mid]) {
    			right = mid - 1;
    		} else {
    			left = mid + 1;
    		}
    	}  
        return left;
    }
}
