package leetcode._051_100;

public class SearchinRotatedSortedArrayII_81 {

    public boolean search(int[] nums, int target) {
    	int left = 0, right = nums.length - 1;
	    while (left <= right) {
	        int mid = (left + right) / 2;
	        if (target == nums[mid]) return true;		//先判定是否相等
	        if (nums[mid] == nums[left]) left++;		//此处关键,因为left可能和mid相等
	        else if (nums[mid] > nums[left]) {
	            if (nums[left] <= target && nums[mid] > target) right = mid - 1;
	            else left = mid + 1;
	        } else {
	            if (nums[mid] < target && target <= nums[right]) left = mid + 1;
	            else right = mid - 1;
	        }
	    }
	    return false;
    }
}
